using BusinessObjects;
using Microsoft.AspNetCore.Mvc;
using Services;

namespace FUNewsManagementSystem.Controllers
{
    public class StaffController : Controller
    {
        private readonly CategoryService _categoryService;
        private readonly NewsService _newsService;
        /*private readonly NewsArticleTagService _newsArticleTagService;*/
        private readonly TagService _tagService;
        private readonly IAccountService _accountService;

        public StaffController()
        {
            // Read appsettings.json in the MVC project
            var config = new ConfigurationBuilder()
                .AddJsonFile("appsettings.json", optional: false, reloadOnChange: true)
                .Build();

            string adminEmail = config["DefaultAdminAccount:Email"];
            string adminPassword = config["DefaultAdminAccount:Password"];

            _categoryService = new CategoryService();
            _newsService = new NewsService();
            _tagService = new TagService();
            /*_newsArticleTagService = new NewsArticleTagService();*/
            _accountService = new AccountService(adminEmail, adminPassword);
        }
        private bool IsStaff()
        {
            return HttpContext.Session.GetInt32("UserRole") == 1;
        }

        public IActionResult Dashboard()
        {
            if (!IsStaff()) return RedirectToAction("Login", "Account");

            return View();
        }

        // ------- CATEGORY MANAGEMENT -------
        public IActionResult ManageCategories()
        {
            var categories = _categoryService.GetAllCategories();
            return View(categories);
        }

        [HttpPost]
        public IActionResult CreateCategory(Category category)
        {
            if (ModelState.IsValid)
            {
                _categoryService.AddCategory(category);
                return RedirectToAction("ManageCategories", "Staff");

            }
            return RedirectToAction("ManageCategories", "Staff");
        }

        [HttpPost]
        public IActionResult EditCategory(Category category)
        {
            if (ModelState.IsValid)
            {
                _categoryService.UpdateCategory(category);
                return RedirectToAction("ManageCategories", "Staff");
            }
            return RedirectToAction("ManageCategories", "Staff");
        }

        [HttpPost]
        public IActionResult ConfirmDeleteCategory(short id)
        {
            _categoryService.DeleteCategory(id);
            return RedirectToAction("ManageCategories", "Staff");
        }

        // ------- NEWS ARTICLE MANAGEMENT -------
        public IActionResult ManageNewsArticle()
        {
            var news = _newsService.GetAllNews();
            ViewBag.Categories = _categoryService.GetAllCategories();
            ViewBag.Tags = _tagService.GetAllTags();
            return View(news);
        }

        [HttpPost]
        public IActionResult CreateNews(NewsArticle news, List<int> TagIds)
        {
            short userId = Convert.ToInt16(HttpContext.Session.GetInt32("UserId"));

            // Gán thông tin cho bài báo
            news.CreatedById = userId;
            news.UpdatedById = userId;
            news.CreatedDate = DateTime.Now;
            news.ModifiedDate = DateTime.Now;

            // Lấy danh sách Tag từ TagIds
            using (var context = new FunewsManagementContext())
            {
                // Thêm bài báo vào DB trước
                context.NewsArticles.Add(news);
                context.SaveChanges(); // Lưu để có NewsArticleId

                // Gán các Tag cho NewsArticle
                if (TagIds != null && TagIds.Any())
                {
                    var tags = context.Tags.Where(t => TagIds.Contains(t.TagId)).ToList();
                    news.Tags = tags; // Gán danh sách Tag vào NewsArticle
                    context.SaveChanges(); // Lưu mối quan hệ vào NewsArticleTag
                }
            }

            return RedirectToAction("ManageNewsArticle", "Staff");
        }


        [HttpPost]
        public IActionResult EditNews(NewsArticle news)
        {
            if (ModelState.IsValid)
            {
                _newsService.UpdateNews(news);
                return RedirectToAction("ManageNewsArticle", "Staff");

            }
            return RedirectToAction("ManageNewsArticle", "Staff");

        }


        [HttpPost]
        public IActionResult ConfirmDeleteNews(string id)
        {
            _newsService.DeleteNews(id);
            return RedirectToAction("ManageNewsArticle", "Staff");
        }

        public IActionResult Profile()
        {
            if (!IsStaff()) return RedirectToAction("Login", "Account");
            short userId = Convert.ToInt16(HttpContext.Session.GetInt32("UserId"));
            var user = _accountService.GetUserById(userId);
            if (user == null) return NotFound();
            return View(user);
        }

        [HttpPost]
        public IActionResult UpdateProfile(SystemAccount model)
        {
            short userId = Convert.ToInt16(HttpContext.Session.GetInt32("UserId"));
            if (userId != model.AccountId) return BadRequest("Unauthorized!");

            var user = _accountService.GetUserById(userId);
            if (user == null) return NotFound();

            user.AccountName = model.AccountName;

            _accountService.UpdateAccount(user);
            TempData["SuccessMessage"] = "Profile updated successfully.";
            return RedirectToAction("Profile");
        }

        [HttpPost]
        public IActionResult ChangePassword(short userId, string currentPassword, string newPassword)
        {
            if (userId != Convert.ToInt16(HttpContext.Session.GetInt32("UserId")))
                return BadRequest("Unauthorized!");

            var result = _accountService.ChangePassword(userId, currentPassword, newPassword);
            if (!result) TempData["ErrorMessage"] = "Current password is incorrect!";
            else TempData["SuccessMessage"] = "Password changed successfully.";

            return RedirectToAction("Profile");
        }

        [HttpGet]
        public IActionResult NewsHistory()
        {
            if (!IsStaff()) return RedirectToAction("Login", "Account");
            short userId = Convert.ToInt16(HttpContext.Session.GetInt32("UserId"));
            var newsList = _newsService.GetNewsByCreator(userId);
            return View(newsList);
        }
    }
}

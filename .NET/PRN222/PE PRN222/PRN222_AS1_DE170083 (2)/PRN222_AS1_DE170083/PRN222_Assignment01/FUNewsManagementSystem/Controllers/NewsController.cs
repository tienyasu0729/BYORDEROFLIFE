using BusinessObjects;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Services;
using X.PagedList;
using X.PagedList.Extensions;

namespace FUNewsManagementSystem.Controllers
{
    public class NewsController : Controller
    {
        private readonly FunewsManagementContext _context;
        private readonly NewsService _newsService = new NewsService();
        private readonly CategoryService _categoryService = new CategoryService();
        private readonly TagService _tagService = new TagService();

        public NewsController(FunewsManagementContext context)
        {
            _context = context;
        }

        //public IActionResult Index(int? categoryId, int? tagId)
        //{
        //    // Lấy tất cả bài báo dưới dạng IQueryable
        //    var newsArticles = _context.NewsArticles.AsQueryable();
        //    ViewBag.Categories = _categoryService.GetAllCategories();
        //    ViewBag.Tags = _tagService.GetAllTags();
        //    // Lọc theo categoryId nếu có
        //    if (categoryId.HasValue)
        //    {
        //        newsArticles = newsArticles.Where(n => n.CategoryId == categoryId.Value);
        //    }

        //    // Lọc theo tagId nếu có, sử dụng truy vấn SQL trực tiếp nếu cần
        //    if (tagId.HasValue)
        //    {
        //        var tagFilterQuery = $@"
        //    SELECT DISTINCT na.NewsArticleId 
        //    FROM NewsArticle na
        //    JOIN NewsArticleTag nt ON na.NewsArticleId = nt.NewsArticleId
        //    WHERE nt.TagId = {tagId.Value}";

        //        var filteredNewsArticleIds = _context.NewsArticles
        //            .FromSqlRaw(tagFilterQuery)
        //            .Select(n => n.NewsArticleId)
        //            .ToList();

        //        newsArticles = newsArticles.Where(n => filteredNewsArticleIds.Contains(n.NewsArticleId));
        //    }

        //    // Trả về danh sách kết quả
        //    return View(newsArticles.ToList());
        //}

        public IActionResult Index(int? categoryId, int? tagId, int? page)
        {
            int pageSize = 6; // Số bài viết trên mỗi trang
            int pageNumber = page ?? 1; // Nếu không có số trang, mặc định là trang 1

            // Lấy tất cả bài báo dưới dạng IQueryable
            var newsArticles = _context.NewsArticles.Include(n => n.Category).AsQueryable();

            ViewBag.Categories = _categoryService.GetAllCategories();
            ViewBag.Tags = _tagService.GetAllTags();

            // Lọc theo categoryId nếu có
            if (categoryId.HasValue)
            {
                newsArticles = newsArticles.Where(n => n.CategoryId == categoryId.Value);
            }

            // Lọc theo tagId nếu có
            if (tagId.HasValue)
            {
                var tagFilterQuery = @"
                SELECT DISTINCT na.NewsArticleId 
                FROM NewsArticle na
                JOIN NewsArticleTag nt ON na.NewsArticleId = nt.NewsArticleId
                WHERE nt.TagId = {0}";

                var filteredNewsArticleIds = _context.NewsArticles
                    .FromSqlRaw(tagFilterQuery, tagId.Value)
                    .Select(n => n.NewsArticleId)
                    .ToList();

                newsArticles = newsArticles.Where(n => filteredNewsArticleIds.Contains(n.NewsArticleId));
            }

            // Phân trang danh sách bài viết
            var pagedNews = newsArticles.OrderByDescending(n => n.CreatedDate).ToPagedList(pageNumber, pageSize);

            return View(pagedNews);
        }

        public IActionResult Details(string id)
        {
            var news = _newsService.GetNewsById(id);
            if (news == null) return NotFound();

            ViewBag.Categories = _categoryService.GetAllCategories();
            ViewBag.Tags = _tagService.GetAllTags();
            return View(news);
        }
    }
}

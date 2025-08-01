using BusinessObjects.Models;
using Microsoft.AspNetCore.Mvc;
using PawnShop.Models;

namespace PawnShop.Controllers
{
    public class PawnItemController : Controller
    {
        private readonly PawnShopDbContext _context;

        public PawnItemController()
        {
            _context = new PawnShopDbContext();
        }

        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(PawnItemViewModel model)
        {
            if (!ModelState.IsValid) return View(model);

            // Lấy IdShop từ session
            int? idShop = HttpContext.Session.GetInt32("ShopId");
            if (idShop == null) return RedirectToAction("UserLogin", "Login");

            // Tìm hoặc tạo User
            var user = _context.Users.FirstOrDefault(u => u.PhoneNumber == model.CustomerPhoneNumber);
            if (user == null)
            {
                user = new User
                {
                    PhoneNumber = model.CustomerPhoneNumber,
                    Name = model.CustomerName
                };
                _context.Users.Add(user);
                _context.SaveChanges();
            }

            // Tạo thư mục lưu ảnh
            string timestamp = DateTime.Now.ToString("yyyyMMdd_HHmmss");
            string folderPath = Path.Combine("wwwroot", "uploads", "pawnitems", idShop.ToString(), timestamp);
            if (!Directory.Exists(folderPath))
                Directory.CreateDirectory(folderPath);

            List<string> savedPaths = new();
            if (model.ImageFiles != null)
            {
                if (model.ImageFiles.Count > 9)
                {
                    ModelState.AddModelError("ImageFiles", "Chỉ được tải lên tối đa 9 ảnh.");
                    return View(model);
                }

                foreach (var file in model.ImageFiles)
                {
                    if (file.Length > 0)
                    {
                        string uniqueName = Guid.NewGuid() + Path.GetExtension(file.FileName);
                        string fullPath = Path.Combine(folderPath, uniqueName);

                        using (var stream = new FileStream(fullPath, FileMode.Create))
                        {
                            file.CopyTo(stream);
                        }

                        string relativePath = $"/uploads/pawnitems/{idShop}/{timestamp}/{uniqueName}";
                        savedPaths.Add(relativePath);
                    }
                }
            }

            // Tạo PawnItem
            var pawnItem = new PawnItem
            {
                IdUser = user.Id,
                IdShop = idShop.Value,
                IdCategory = model.IdCategory,
                NameProduct = model.NameProduct,
                ProductDescription = model.ProductDescription,
                PawnPrice = model.PawnPrice,
                Condition = model.Condition,
                PawnDate = DateOnly.FromDateTime(model.PawnDate),
                PawnTime = model.PawnTime,
                ImageFolder = string.Join(";", savedPaths)
            };

            _context.PawnItems.Add(pawnItem);
            _context.SaveChanges();

            return RedirectToAction("Index");
        }
    }
}

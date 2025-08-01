using Microsoft.AspNetCore.Mvc;
using PawnShop.Models;
using Services;
using Services.Interface;

namespace PawnShop.Controllers
{
    public class LoginController : Controller
    {
        private readonly IUserService _userService;
        private readonly IShopService _shopService;

        public LoginController()
        {
            _userService = new UserService();
            _shopService = new ShopService();
        }

        // ==================== User Login ====================
        [HttpGet]
        public IActionResult UserLogin()
        {
            if (HttpContext.Session.GetInt32("UserId") != null)
            {
                return RedirectToAction("Index", "Home");
            }

            return View();
        }

        [HttpPost]
        public IActionResult UserLogin(LoginViewModel model)
        {
            if (!ModelState.IsValid) return View(model);

            var user = _userService.GetUserByPhoneAndPassword(model.PhoneNumber, model.Password);
            if (user != null)
            {
                HttpContext.Session.SetInt32("UserId", user.Id);
                HttpContext.Session.SetString("UserName", user.Name ?? "");
                return RedirectToAction("Index", "Home");
            }

            ViewBag.Error = "Sai số điện thoại hoặc mật khẩu";
            return View(model);
        }

        // ==================== Shop Login ====================
        [HttpGet]
        public IActionResult ShopLogin()
        {
            if (HttpContext.Session.GetInt32("ShopId") != null)
            {
                return RedirectToAction("Index", "Home");
            }

            return View();
        }

        [HttpPost]
        public IActionResult ShopLogin(LoginViewModel model)
        {
            if (!ModelState.IsValid) return View(model);

            var shop = _shopService.GetShopByPhoneAndPassword(model.PhoneNumber, model.Password);
            if (shop != null)
            {
                HttpContext.Session.SetInt32("ShopId", shop.Id);
                HttpContext.Session.SetString("ShopName", shop.ShopName ?? "");
                return RedirectToAction("Index", "Home");
            }

            ViewBag.Error = "Invalid phone number or password";
            return View(model);
        }

        // ==================== Logout ====================
        public IActionResult Logout()
        {
            HttpContext.Session.Clear();
            return RedirectToAction("UserLogin");
        }
    }
}

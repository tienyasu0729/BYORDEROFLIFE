using Chill_Computer.Services;
using Chill_Computer.ViewModels;
using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;

namespace Chill_Computer.Controllers
{
    public class AccountController : Controller
    {
        private readonly IUserService _userService;

        public AccountController(IUserService userService)
        {
            _userService = userService;
        }

        // GET: /Account/Login
        [HttpGet]
        public IActionResult Login()
        {
            return View(new LoginViewModel());
        }

        // POST: /Account/Login
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Login(LoginViewModel model)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            var success = await _userService.LoginAsync(model.UserName, model.Password);
            if (success)
            {
                // Add authentication logic here (e.g., set cookie or token)
                return RedirectToAction("Index", "Home");
            }

            ModelState.AddModelError("", "Tên đăng nhập hoặc mật khẩu không đúng.");
            return View(model);
        }

        // GET: /Account/Register
        [HttpGet]
        public IActionResult Register()
        {
            return View(new RegisterViewModel());
        }

        // POST: /Account/Register
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Register(RegisterViewModel model)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            var success = await _userService.RegisterAsync(model);
            if (success)
            {
                return RedirectToAction("Login");
            }

            ModelState.AddModelError("", "Đăng ký thất bại. Tên đăng nhập hoặc email đã tồn tại.");
            return View(model);
        }

        // GET: /Account/VerifyEmail
        [HttpGet]
        public IActionResult VerifyEmail()
        {
            return View(new VerifyEmailViewModel());
        }

        // POST: /Account/VerifyEmail
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> VerifyEmail(VerifyEmailViewModel model)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            var emailExists = await _userService.VerifyEmailAsync(model.Email);
            if (emailExists)
            {
                // Simulate sending a reset link (implement email service in production)
                TempData["Message"] = "Link đặt lại mật khẩu đã được gửi đến email của bạn.";
                return RedirectToAction("Login");
            }

            ModelState.AddModelError("", "Email không tồn tại.");
            return View(model);
        }

        // GET: /Account/ChangePassword
        [HttpGet]
        public IActionResult ChangePassword()
        {
            return View(new ChangePasswordViewModel());
        }

        // POST: /Account/ChangePassword
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> ChangePassword(ChangePasswordViewModel model)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            // Assume username is retrieved from logged-in user (e.g., via authentication)
            string username = "currentUsername"; // Replace with actual logic (e.g., User.Identity.Name)

            var success = await _userService.ChangePasswordAsync(username, model.OldPassword, model.NewPassword);
            if (success)
            {
                TempData["Message"] = "Đổi mật khẩu thành công.";
                return RedirectToAction("Login");
            }

            ModelState.AddModelError("", "Mật khẩu cũ không đúng hoặc đổi mật khẩu thất bại.");
            return View(model);
        }
    }
}
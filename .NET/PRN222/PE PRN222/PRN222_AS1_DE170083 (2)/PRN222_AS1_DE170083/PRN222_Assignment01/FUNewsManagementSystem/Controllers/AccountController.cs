using BusinessObjects;
using FUNewsManagementSystem.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Authentication;
using Services;
using Microsoft.AspNetCore.Authentication.Google;
using System.Security.Claims;
using Microsoft.AspNetCore.Authentication.Cookies;

namespace FUNewsManagementSystem.Controllers
{
    public class AccountController : Controller
    {

        private readonly IAccountService _accountService;

        public AccountController()
        {
            // Read appsettings.json in the MVC project
            var config = new ConfigurationBuilder()
                .AddJsonFile("appsettings.json", optional: false, reloadOnChange: true)
                .Build();

            string adminEmail = config["DefaultAdminAccount:Email"];
            string adminPassword = config["DefaultAdminAccount:Password"];

            _accountService = new AccountService(adminEmail, adminPassword);
        }
        public IActionResult Login()
        {
            return View();
        }

        [HttpGet]
        public IActionResult ExternalLogin(string provider)
        {
            var redirectUrl = Url.Action("ExternalLoginCallback", "Account", values: null, protocol: Request.Scheme);
            var properties = new AuthenticationProperties { RedirectUri = redirectUrl };
            return Challenge(properties, provider);
        }

       

        public IActionResult ExternalLoginCallback()
        {
            var authenticateResult = HttpContext.AuthenticateAsync(GoogleDefaults.AuthenticationScheme);
            if (!authenticateResult.Result.Succeeded)
            {
                Console.WriteLine("Google authentication failed!");
                return RedirectToAction("Login", "Account");
            }

            var googleId = authenticateResult.Result.Principal.FindFirst(ClaimTypes.NameIdentifier)?.Value;
            var email = authenticateResult.Result.Principal.FindFirst(ClaimTypes.Email)?.Value;
            var name = authenticateResult.Result.Principal.FindFirst(ClaimTypes.Name)?.Value;

            Console.WriteLine($"Google ID: {googleId}");
            Console.WriteLine($"Email: {email}");
            Console.WriteLine($"Name: {name}");

            if (googleId == null || email == null)
            {
                Console.WriteLine("Google authentication returned null values.");
                return RedirectToAction("Login", "Account");
            }

            return RedirectToAction("Index", "News");
        }


        [HttpPost]
        public IActionResult Login(AccountViewModel model)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            var user = _accountService.ValidateUser(model.Email, model.Password);
            //if (user != null)
            //{
            //    return RedirectToAction("Index", "News");
            //}

            if (user == null)
            {
                ViewData["ErrorMessage"] = "Invalid email or password.";
                return View(model);
            }

            if (user.AccountRole == -1)
            {
                ViewData["ErrorMessage"] = "Your account is deactivated.";
                return View(model);
            }
            // Store login status in session
            HttpContext.Session.SetInt32("UserId", user.AccountId);
            HttpContext.Session.SetString("UserName", user.AccountName);
            HttpContext.Session.SetInt32("UserRole", user.AccountRole) ;

            if (user.AccountRole == 0)
            {
                return RedirectToAction("Dashboard", "Admin");
            }



            return RedirectToAction("Index", "News");
            //ViewBag.ErrorMessage = "Invalid email or password";
            //return View();
        }
        public IActionResult Logout()
        {
            HttpContext.Session.Clear(); // Clear all session data
            return RedirectToAction("Login");
        }

        [HttpGet]
        public IActionResult Profile()
        {
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
    }
}

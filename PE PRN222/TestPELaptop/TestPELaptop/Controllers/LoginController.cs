using GroupProjectDataAccess;
using Microsoft.AspNetCore.Mvc;

namespace TestPELaptop.Controllers
{
    public class LoginController : Controller
    {
        [HttpGet]
        public IActionResult Login()
        {
            // Nếu đã đăng nhập rồi, chuyển hướng theo role
            if (HttpContext.Session.GetInt32("UserId") != null)
            {
                var role = HttpContext.Session.GetString("Role");

                if (role == "Lecturer")
                    return RedirectToAction("Dashboard", "Lecturer");

                return RedirectToAction("Dashboard", "Student");
            }

            return View();
        }

        [HttpPost]
        public IActionResult Login(string email, string password)
        {
            if (string.IsNullOrEmpty(email) || string.IsNullOrEmpty(password))
            {
                ViewBag.Error = "Vui lòng nhập đầy đủ thông tin.";
                return View();
            }

            var user = UserDAO.GetToLogin(email, password);

            if (user != null)
            {
                // Lưu thông tin người dùng vào session
                HttpContext.Session.SetInt32("UserId", user.Id);
                HttpContext.Session.SetString("Role", user.Role ?? "Student");
                HttpContext.Session.SetString("Email", user.Email ?? "");

                // Điều hướng theo role
                if (user.Role == "Lecturer")
                {
                    return RedirectToAction("Dashboard", "Lecturer");
                }
                else
                {
                    return RedirectToAction("Dashboard", "Student");
                }
            }

            ViewBag.Error = "Email hoặc mật khẩu không đúng.";
            return View();
        }

        public IActionResult Logout()
        {
            HttpContext.Session.Clear();
            return RedirectToAction("Login", "Login");
        }

    }
}

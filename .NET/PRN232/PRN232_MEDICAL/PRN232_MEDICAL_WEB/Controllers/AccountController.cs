using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Mvc;
using PRN232_MEDICAL_WEB.ViewModels;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;

namespace PRN232_MEDICAL_WEB.Controllers
{
    public class AccountController : Controller
    {
        private readonly IHttpClientFactory _httpClientFactory;

        public AccountController(IHttpClientFactory httpClientFactory)
        {
            _httpClientFactory = httpClientFactory;
        }

        // GET: /Account/Login (Hiển thị form đăng nhập)
        [HttpGet]
        public IActionResult Login()
        {
            return View();
        }

        // POST: /Account/Login (Xử lý form đăng nhập)
        [HttpPost]
        public async Task<IActionResult> Login(LoginViewModel model)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            // 1. Tạo client để gọi API
            var client = _httpClientFactory.CreateClient("ApiClient");

            // 2. Gọi API /api/auth/login
            var response = await client.PostAsJsonAsync("api/auth/login", model);

            if (response.IsSuccessStatusCode)
            {
                // 3. Đọc token từ API response
                var loginResponse = await response.Content.ReadFromJsonAsync<LoginResponse>();
                var token = loginResponse.Token;

                // 4. THỰC HIỆN YÊU CẦU 2.1: Lưu JWT vào Session
                // (HttpClient đã được cấu hình trong Program.cs để tự động đọc từ đây)
                HttpContext.Session.SetString("JWToken", token); // [cite: 42]

                // 5. BƯỚC QUAN TRỌNG (Để MVC hiểu): Đọc claims từ token và tạo Cookie
                var handler = new JwtSecurityTokenHandler();
                var jwtToken = handler.ReadJwtToken(token);
                var claims = jwtToken.Claims; //

                var identity = new ClaimsIdentity(claims, CookieAuthenticationDefaults.AuthenticationScheme);
                var principal = new ClaimsPrincipal(identity);

                // Đăng nhập người dùng vào MVC (tạo cookie)
                await HttpContext.SignInAsync(CookieAuthenticationDefaults.AuthenticationScheme, principal);

                // 6. Chuyển hướng đến trang Doctors
                return RedirectToAction("Index", "Doctors");
            }
            else
            {
                // Xử lý lỗi đăng nhập
                ModelState.AddModelError(string.Empty, "Login Failed. Invalid Email or Password.");
                return View(model);
            }
        }

        // GET hoặc POST: /Account/Logout
        [HttpGet]
        public async Task<IActionResult> Logout()
        {
            // Xóa JWT khỏi Session
            HttpContext.Session.Remove("JWToken");

            // Xóa Cookie xác thực của MVC
            await HttpContext.SignOutAsync(CookieAuthenticationDefaults.AuthenticationScheme);

            return RedirectToAction("Login", "Account");
        }
    }
}

using Microsoft.AspNetCore.Mvc;
using System.Text.Json;
using System.Text;

public class AccountController : Controller
{
    private readonly IHttpClientFactory _clientFactory;

    public AccountController(IHttpClientFactory clientFactory)
    {
        _clientFactory = clientFactory;
    }

    // GET: /Account/Login
    public IActionResult Login()
    {
        return View();
    }

    // POST: /Account/Login
    [HttpPost]
    public async Task<IActionResult> Login(LoginViewModel model)
    {
        if (!ModelState.IsValid)
        {
            return View(model);
        }

        var client = _clientFactory.CreateClient("ApiClient");

        // Chuyển model thành JSON
        var jsonContent = new StringContent(
            JsonSerializer.Serialize(model),
            Encoding.UTF8,
            "application/json");

        // Gọi API /api/auth/login
        var response = await client.PostAsync("api/auth/login", jsonContent);

        if (response.IsSuccessStatusCode)
        {
            // Đọc response body (chứa UserId và Role)
            var responseBody = await response.Content.ReadAsStringAsync();
            var userResponse = JsonSerializer.Deserialize<UserLoginResponse>(responseBody,
                new JsonSerializerOptions { PropertyNameCaseInsensitive = true });

            // Lưu UserId và Role vào Session
            HttpContext.Session.SetInt32("UserId", userResponse.UserId);
            HttpContext.Session.SetInt32("Role", userResponse.Role);

            // Đăng nhập thành công, chuyển hướng đến trang Vehicles
            return RedirectToAction("Index", "Vehicles");
        }
        else
        {
            // Thất bại, báo lỗi
            ModelState.AddModelError(string.Empty, "Invalid login attempt.");
            return View(model);
        }
    }
}
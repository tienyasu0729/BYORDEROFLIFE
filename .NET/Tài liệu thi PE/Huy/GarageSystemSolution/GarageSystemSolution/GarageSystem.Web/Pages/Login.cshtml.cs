using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Text.Json;
using System.Text;
using System.Data;

namespace GarageSystem.Web.Pages
{
    public class LoginModel : PageModel
    {
        private readonly IHttpClientFactory _clientFactory;

        public LoginModel(IHttpClientFactory factory)
        {
            _clientFactory = factory;
        }
        [BindProperty]
        public string Email { get; set; }

        [BindProperty]
        public string Password { get; set; }

        public string ErrorMessage { get; set; }

        public async Task<IActionResult> OnPostAsync()
        {
            var client = _clientFactory.CreateClient("garageapi");

            var loginData = new { Email, Password };
            var content = new StringContent(JsonSerializer.Serialize(loginData), Encoding.UTF8, "application/json");

            var response = await client.PostAsync("api/auth/login", content);

            if (response.IsSuccessStatusCode)
            {
                var result = JsonDocument.Parse(await response.Content.ReadAsStringAsync());
                var token = result.RootElement.GetProperty("token").GetString();
                var role = result.RootElement.GetProperty("role").GetString();
                HttpContext.Session.SetString("token", token);
                HttpContext.Session.SetString("role", role); // thêm dòng này
                return RedirectToPage("/Vehicles/Index");
            }

            ErrorMessage = "Đăng nhập thất bại!";
            return Page();
        }
    }
}

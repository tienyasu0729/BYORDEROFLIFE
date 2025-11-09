using Azure;
using GarageSystem.BusinessLogic.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.IO;
using System.Net.Http;
using System.Net.Http.Json;
using System.Text.Json;

namespace GarageSystem.Web.Pages.Vehicles
{
    public class IndexModel : PageModel
    {
        private readonly HttpClient _client;
        [BindProperty]
        public List<Vehicle> Vehicles { get; set; } = new();
        public string Role { get; set; }
        public IndexModel(IHttpClientFactory factory)
        {
            _client = factory.CreateClient("garageapi");
        }

        public async Task<IActionResult> OnGetAsync()
        {
            var token = HttpContext.Session.GetString("token");
            if (string.IsNullOrEmpty(token)) return RedirectToPage("/Login");

            _client.DefaultRequestHeaders.Authorization = new("Bearer", token);
            var res = await _client.GetStreamAsync("odata/vehicles?$orderby=PlateNumber desc");
            using var doc = await JsonDocument.ParseAsync(res);
            //var response = await _client.GetFromJsonAsync<ODataResponse<Vehicle>>("odata/Vehicles?$orderby=PlateNumber desc"); value là danh sách cần, cố deserialize toàn bộ vào List<Vehicle>, nên lỗi.
            //Vehicles = response?.Value ?? new();
            var vehiclesJson = doc.RootElement.GetProperty("value").GetRawText();
            Vehicles = JsonSerializer.Deserialize<List<Vehicle>>(vehiclesJson) ?? new();

            Role = HttpContext.Session.GetString("role") ?? "0"; // dùng trong View

            return Page();
        }

        public async Task<IActionResult> OnPostDeleteAsync(int id)
        {
            var token = HttpContext.Session.GetString("token");
            if (string.IsNullOrEmpty(token)) return RedirectToPage("/Login");

            _client.DefaultRequestHeaders.Authorization = new("Bearer", token);
            var response = await _client.DeleteAsync($"odata/Vehicles({id})");

            if (response.IsSuccessStatusCode)
                TempData["message"] = "Deletion successful!";
            else
                TempData["error"] = "Unable to delete vehicle. You do not have sufficient permissions?";

            return RedirectToPage(); // gọi lại OnGetAsync
        }
    }
}

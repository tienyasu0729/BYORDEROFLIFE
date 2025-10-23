using GarageSystemWeb.Models;
using Microsoft.AspNetCore.Mvc;
using System.Text.Json;

namespace GarageSystem.Web.Controllers
{
    public class VehiclesController : Controller
    {
        private readonly IHttpClientFactory _clientFactory;

        public VehiclesController(IHttpClientFactory clientFactory)
        {
            _clientFactory = clientFactory;
        }

        // GET: /Vehicles
        public async Task<IActionResult> Index()
        {
            // Kiểm tra xem đã đăng nhập chưa (lấy từ Session)
            var userId = HttpContext.Session.GetInt32("UserId");
            var userRole = HttpContext.Session.GetInt32("Role"); // 1 = Admin, 0 = Staff

            if (userId == null || userRole == null)
            {
                // Nếu chưa, đá về trang Login
                return RedirectToAction("Login", "Account");
            }

            var client = _clientFactory.CreateClient("ApiClient");
            string apiUrl = "";

            // === XỬ LÝ PHÂN QUYỀN ===
            if (userRole == 1) // 1 là Admin (từ file SQL)
            {
                apiUrl = "odata/Vehicles";
            }
            else // 0 là Staff
            {
                apiUrl = $"odata/Vehicles?$filter=UserId eq {userId}";
            }

            List<Vehicle> vehicles = new List<Vehicle>();
            var response = await client.GetAsync(apiUrl);

            if (response.IsSuccessStatusCode)
            {
                var responseBody = await response.Content.ReadAsStringAsync();

                // Đọc OData response (lấy từ trường "value")
                var odataResponse = JsonSerializer.Deserialize<ODataVehicleResponse>(responseBody);
                vehicles = odataResponse.value;
            }

            // Gửi Role sang View để quyết định hiện nút Delete
            ViewBag.UserRole = userRole;

            return View(vehicles);
        }

        // POST: /Vehicles/Delete/5
        [HttpPost]
        public async Task<IActionResult> Delete(int id)
        {
            var userRole = HttpContext.Session.GetInt32("Role");
            if (userRole != 1) // 1 là Admin
            {
                return Unauthorized("You are not authorized to delete.");
            }

            var client = _clientFactory.CreateClient("ApiClient");

            // Gọi API DELETE của OData
            var response = await client.DeleteAsync($"odata/Vehicles({id})");

            // Quay về trang Index
            return RedirectToAction("Index");
        }
    }
}
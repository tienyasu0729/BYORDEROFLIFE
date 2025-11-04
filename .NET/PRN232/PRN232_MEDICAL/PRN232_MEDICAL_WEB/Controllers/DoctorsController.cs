using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using PRN232_MEDICAL_WEB.ViewModels;
using System.Text.Json;

namespace PRN232_MEDICAL_WEB.Controllers
{
    [Authorize] //
    public class DoctorsController : Controller
    {
        private readonly IHttpClientFactory _httpClientFactory;

        public DoctorsController(IHttpClientFactory httpClientFactory)
        {
            _httpClientFactory = httpClientFactory;
        }

        // GET: /Doctors/Index (Câu 2.2)
        public async Task<IActionResult> Index()
        {
            var client = _httpClientFactory.CreateClient("ApiClient");

            // Gọi API /api/doctors
            var response = await client.GetAsync("api/doctors");

            List<DoctorViewModel> doctors = new List<DoctorViewModel>();

            if (response.IsSuccessStatusCode)
            {
                var apiResponse = await response.Content.ReadAsStringAsync();

                // Cần cấu hình để khớp chữ hoa/thường (camelCase từ JSON)
                var options = new JsonSerializerOptions
                {
                    PropertyNameCaseInsensitive = true
                };
                doctors = JsonSerializer.Deserialize<List<DoctorViewModel>>(apiResponse, options);
            }
            else
            {
                // Xử lý trường hợp API lỗi
                ViewBag.ErrorMessage = "Could not load doctors.";
            }

            // Trả về View với danh sách doctors
            return View(doctors);
        }
    }
}

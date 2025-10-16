using FA25_PRN232_MVC.Models;
using Microsoft.AspNetCore.Mvc;
using System.Text.Json;

namespace FA25_PRN232_MVC.Controllers
{
    public class CoursesController : Controller
    {
        private readonly IHttpClientFactory _clientFactory;

        // Sử dụng dependency injection để inject IHttpClientFactory.
        public CoursesController(IHttpClientFactory clientFactory)
        {
            _clientFactory = clientFactory;
        }

        // GET: /Courses (Hiển thị danh sách khóa học)
        public async Task<IActionResult> Index()
        {
            // Tạo một client để gọi API.
            var client = _clientFactory.CreateClient("MyWebAPI");

            // Gửi request GET đến endpoint 'courses' của API.
            var response = await client.GetAsync("courses");

            if (response.IsSuccessStatusCode)
            {
                // Đọc nội dung JSON trả về.
                var jsonString = await response.Content.ReadAsStringAsync();
                // Cấu hình để không phân biệt chữ hoa/thường của thuộc tính JSON.
                var options = new JsonSerializerOptions { PropertyNameCaseInsensitive = true };
                // Chuyển đổi JSON thành danh sách các đối tượng CourseDto.
                var courses = JsonSerializer.Deserialize<List<CourseDto>>(jsonString, options);
                // Trả về View cùng với danh sách khóa học.
                return View(courses);
            }
            else
            {
                ViewBag.ErrorMessage = "Không thể lấy dữ liệu từ API.";
                return View(new List<CourseDto>());
            }
        }

        // GET: /Courses/Details/5 (Hiển thị chi tiết một khóa học)
        public async Task<IActionResult> Details(int id)
        {
            var client = _clientFactory.CreateClient("MyWebAPI");
            var response = await client.GetAsync($"courses/{id}");

            if (response.IsSuccessStatusCode)
            {
                var jsonString = await response.Content.ReadAsStringAsync();
                var options = new JsonSerializerOptions { PropertyNameCaseInsensitive = true };
                var course = JsonSerializer.Deserialize<CourseDto>(jsonString, options);
                return View(course);
            }
            else
            {
                return NotFound(); // Trả về lỗi 404 nếu không tìm thấy khóa học.
            }
        }

        // POST: /Courses/Register (Xử lý đăng ký khóa học)
        [HttpPost]
        public async Task<IActionResult> Register(int courseId)
        {
            // Giả sử người dùng hiện tại có UserId = 2 (student1@fpt.edu.vn) để test.
            var enrollmentDto = new CreateEnrollmentDto
            {
                CourseId = courseId,
                UserId = 2
            };

            var client = _clientFactory.CreateClient("MyWebAPI");
            // Gửi request POST với dữ liệu enrollmentDto lên API.
            var response = await client.PostAsJsonAsync("enrollments", enrollmentDto);

            if (response.IsSuccessStatusCode)
            {
                // Sử dụng TempData để hiển thị thông báo thành công ở trang kế tiếp.
                TempData["SuccessMessage"] = "Đăng ký thành công!";
            }
            else
            {
                TempData["ErrorMessage"] = "Đăng ký thất bại!";
            }

            // Chuyển hướng người dùng về lại trang chi tiết của khóa học vừa đăng ký.
            return RedirectToAction("Details", new { id = courseId });
        }
    }
}

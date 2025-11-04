using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PRN232_MEDICAL.Data;
using PRN232_MEDICAL.DTOs;
using PRN232_MEDICAL.Models;
using System.Security.Claims;

namespace PRN232_MEDICAL.Controllers
{
    [Route("api/appointments")]
    [ApiController]
    [Authorize] // Yêu cầu đăng nhập cho TẤT CẢ các endpoint trong controller này
    public class AppointmentsController : ControllerBase
    {
        private readonly ApplicationDbContext _context;

        public AppointmentsController(ApplicationDbContext context)
        {
            _context = context;
        }

        // POST: /api/appointments (Câu 1.4 - Patient creates appointment)
        [HttpPost]
        [Authorize(Policy = "Patient")] // Chỉ Patient
        public async Task<ActionResult<Appointment>> CreateAppointment([FromBody] AppointmentCreateRequest request)
        {
            // 1. Lấy UserId của Patient từ JWT token
            var userIdString = User.FindFirstValue(ClaimTypes.NameIdentifier);
            if (string.IsNullOrEmpty(userIdString))
            {
                return Unauthorized("User ID not found in token.");
            }
            var userId = int.Parse(userIdString);

            // 2. Kiểm tra bác sĩ có tồn tại và "Available" không
            var doctor = await _context.Doctors.FindAsync(request.DoctorId);
            if (doctor == null || !doctor.Available)
            {
                return BadRequest("Doctor is not available or does not exist.");
            }

            // 3. Tạo appointment mới
            var appointment = new Appointment
            {
                DoctorId = request.DoctorId,
                UserId = userId, // Lấy từ token
                AppointmentDate = request.AppointmentDate,
                Notes = request.Notes,
                Status = "Pending" // Mặc định theo yêu cầu
            };

            _context.Appointments.Add(appointment);
            await _context.SaveChangesAsync();

            return CreatedAtAction(nameof(GetAppointment), new { id = appointment.AppointmentId }, appointment);
        }

        // PATCH: /api/appointments/{id}/approve (Câu 1.4 - Doctor approves)
        [HttpPatch("{id}/approve")]
        [Authorize(Policy = "Doctor")] // Chỉ Doctor
        public async Task<IActionResult> ApproveAppointment(int id)
        {
            // Lấy UserId của Doctor từ token
            var doctorUserIdString = User.FindFirstValue(ClaimTypes.NameIdentifier);
            var doctorUserId = int.Parse(doctorUserIdString);

            var appointment = await _context.Appointments
                                    .Include(a => a.Doctor) //
                                    .FirstOrDefaultAsync(a => a.AppointmentId == id);

            if (appointment == null)
            {
                return NotFound("Appointment not found.");
            }

            // (Nâng cao): Chúng ta giả sử UserID (từ bảng User) của Doctor
            // không liên quan trực tiếp đến DoctorId (từ bảng Doctor)
            // Nếu có liên quan, bạn cần kiểm tra:
            // if (appointment.Doctor.UserId != doctorUserId) //
            // {
            //     return Forbid("You are not authorized to approve this appointment.");
            // }

            if (appointment.Status != "Pending")
            {
                return BadRequest("Only pending appointments can be approved.");
            }

            appointment.Status = "Approved";
            await _context.SaveChangesAsync();

            return Ok(new { message = "Appointment approved successfully." });
        }

        // PATCH: /api/appointments/{id}/complete (Câu 1.4 - Doctor marks complete)
        [HttpPatch("{id}/complete")]
        [Authorize(Policy = "Doctor")] // Chỉ Doctor
        public async Task<IActionResult> CompleteAppointment(int id)
        {
            var appointment = await _context.Appointments
                                    .Include(a => a.Doctor)
                                    .FirstOrDefaultAsync(a => a.AppointmentId == id);

            if (appointment == null)
            {
                return NotFound("Appointment not found.");
            }

            // (Tương tự, kiểm tra DoctorId nếu cần)

            if (appointment.Status != "Approved")
            {
                return BadRequest("Only approved appointments can be completed.");
            }

            appointment.Status = "Completed";
            await _context.SaveChangesAsync();

            return Ok(new { message = "Appointment completed successfully." });
        }

        // Endpoint phụ để CreatedAtAction (ở hàm POST) hoạt động
        [HttpGet("{id}")]
        [Authorize(Policy = "Patient")] // Hoặc "Doctor"
        public async Task<ActionResult<Appointment>> GetAppointment(int id)
        {
            var appointment = await _context.Appointments
                .Include(a => a.Doctor)
                .Include(a => a.User)
                .FirstOrDefaultAsync(a => a.AppointmentId == id);

            if (appointment == null)
            {
                return NotFound();
            }

            // (Nên kiểm tra xem user này có phải là Patient hoặc Doctor của appointment không)
            return appointment;
        }
    }
}

// Thay thế TOÀN BỘ file EnrollmentsController.cs của bạn bằng code này

using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Đảm bảo namespace này đúng
using PRN_Sum25B5_Q1_Solution.Models.DTOs; // <-- Đảm bảo namespace này đúng

namespace PRN_Sum25B5_Q1_Solution.Controllers // <-- Đảm bảo namespace này đúng
{
    [Route("api/[controller]")]
    [ApiController]
    public class EnrollmentsController : ControllerBase
    {
        // SỬA Ở ĐÂY: Dùng CodeDbContext
        private readonly CodeDbContext _context;

        // SỬA Ở ĐÂY: Dùng CodeDbContext
        public EnrollmentsController(CodeDbContext context)
        {
            _context = context;
        }

        // POST: api/enrollments
        [HttpPost]
        public async Task<IActionResult> CreateEnrollment([FromBody] EnrollmentRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            // SỬA Ở ĐÂY: Dùng StudentId và CourseId
            var studentExists = await _context.Students.AnyAsync(s => s.StudentId == request.StudentId);
            var courseExists = await _context.Courses.AnyAsync(c => c.CourseId == request.CourseId);

            if (!studentExists || !courseExists)
            {
                return NotFound("StudentId or CourseId does not exist in the database");
            }

            // SỬA Ở ĐÂY: Dùng StudentId và CourseId
            var enrollmentExists = await _context.Enrollments
                .AnyAsync(e => e.StudentId == request.StudentId && e.CourseId == request.CourseId);

            if (enrollmentExists)
            {
                return Conflict("The student is already enrolled in the course");
            }

            var newEnrollment = new Enrollment
            {
                // SỬA Ở ĐÂY: Dùng StudentId, CourseId, và EnrollDate (kiểu DateOnly?)
                StudentId = (int)request.StudentId,
                CourseId = (int)request.CourseId,
                EnrollDate = (DateOnly)request.EnrollDate,
                Grade = (double)request.Grade
            };

            _context.Enrollments.Add(newEnrollment);
            await _context.SaveChangesAsync();

            return StatusCode(201, newEnrollment);
        }
    }
}
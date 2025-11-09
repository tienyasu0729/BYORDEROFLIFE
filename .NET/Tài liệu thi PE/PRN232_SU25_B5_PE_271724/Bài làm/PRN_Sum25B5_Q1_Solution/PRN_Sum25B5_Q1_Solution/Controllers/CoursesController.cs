// Thay thế TOÀN BỘ file CoursesController.cs của bạn bằng code này

using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using PRN_Sum25B5_Q1_Solution.Models; // <-- Đảm bảo namespace này đúng

namespace PRN_Sum25B5_Q1_Solution.Controllers // <-- Đảm bảo namespace này đúng
{
    [Route("api/[controller]")]
    [ApiController]
    public class CoursesController : ControllerBase
    {
        // SỬA Ở ĐÂY: Dùng CodeDbContext
        private readonly CodeDbContext _context;

        // SỬA Ở ĐÂY: Dùng CodeDbContext
        public CoursesController(CodeDbContext context)
        {
            _context = context;
        }

        // GET: api/courses/topics/{keyword}
        [HttpGet("topics/{keyword}")]
        public async Task<IActionResult> GetCoursesWithTopics(string keyword)
        {
            if (string.IsNullOrEmpty(keyword))
            {
                return BadRequest("Keyword is null or empty.");
            }

            var courses = await _context.Courses
                .Where(c => c.Title.ToLower().Contains(keyword.ToLower()))

                // SỬA Ở ĐÂY: Dùng Include(c.Topics)
                .Include(c => c.Topics)
                .Select(c => new
                {
                    // SỬA Ở ĐÂY: Dùng c.CourseId
                    courseId = c.CourseId,
                    title = c.Title,

                    // SỬA Ở ĐÂY: Lặp qua c.Topics
                    topics = c.Topics.Select(t => new
                    {
                        // SỬA Ở ĐÂY: Dùng t.TopicId
                        id = t.TopicId,
                        name = t.Name
                    }).ToList()
                })
                .ToListAsync();

            if (courses == null || !courses.Any())
            {
                return NoContent();
            }
            return Ok(courses);
        }

        // DELETE: api/courses/{courseId}
        [HttpDelete("{courseId}")]
        public async Task<IActionResult> DeleteCourse(int courseId)
        {
            // SỬA Ở ĐÂY: Dùng e.CourseId
            var hasEnrollments = await _context.Enrollments.AnyAsync(e => e.CourseId == courseId);
            if (hasEnrollments)
            {
                return BadRequest("Course has enrolled students");
            }

            var course = await _context.Courses.FindAsync(courseId);
            if (course == null)
            {
                return NotFound("Course not found");
            }

            // SỬA Ở ĐÂY: XÓA 2 DÒNG truy cập _context.CourseTopics
            // (Vì nó không tồn tại và EF Core sẽ tự động xóa)

            _context.Courses.Remove(course);
            await _context.SaveChangesAsync();

            return Ok("Successfully deleted");
        }
    }
}
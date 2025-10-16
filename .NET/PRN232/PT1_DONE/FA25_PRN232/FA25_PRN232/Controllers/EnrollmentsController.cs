using FA25_PRN232.DTOs;
using FA25_PRN232.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace FA25_PRN232.Controllers
{
    [Route("api/enrollments")]
    [ApiController]
    public class EnrollmentsController : ControllerBase
    {
        private readonly IEnrollmentService _enrollmentService;

        public EnrollmentsController(IEnrollmentService enrollmentService)
        {
            _enrollmentService = enrollmentService;
        }

        [HttpPost]
        public async Task<IActionResult> EnrollCourse([FromBody] CreateEnrollmentDto enrollmentDto)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            var enrollment = await _enrollmentService.CreateEnrollment(enrollmentDto);

            if (enrollment == null)
            {
                return Conflict("User is already enrolled in this course.");
            }

            return CreatedAtAction(nameof(EnrollCourse), new { id = enrollment.EnrollmentId }, enrollment);
        }
    }
}

using FA25_PRN232.DTOs;
using FA25_PRN232.Interfaces;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.OData.Query;

namespace FA25_PRN232.Controllers
{
    [Route("api/courses")]
    [ApiController]
    public class CoursesController : ControllerBase
    {
        private readonly ICourseService _courseService;

        public CoursesController(ICourseService courseService)
        {
            _courseService = courseService;
        }

        [HttpGet]
        [EnableQuery] // This enables OData query options
        public IQueryable<CourseDto> GetCourses()
        {
            return _courseService.GetAllCourses();
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<CourseDto>> GetCourse(int id)
        {
            var course = await _courseService.GetCourseById(id);
            if (course == null)
            {
                return NotFound();
            }
            return Ok(course);
        }

        [HttpPost]
        public async Task<ActionResult<CourseDto>> PostCourse(CreateCourseDto courseDto)
        {
            var newCourse = await _courseService.CreateCourse(courseDto);
            var courseResult = await _courseService.GetCourseById(newCourse.CourseId);
            return CreatedAtAction(nameof(GetCourse), new { id = newCourse.CourseId }, courseResult);
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> PutCourse(int id, CreateCourseDto courseDto)
        {
            var result = await _courseService.UpdateCourse(id, courseDto);
            if (!result)
            {
                return NotFound();
            }
            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteCourse(int id)
        {
            var result = await _courseService.DeleteCourse(id);
            if (!result)
            {
                return NotFound();
            }
            return NoContent();
        }
    }
}

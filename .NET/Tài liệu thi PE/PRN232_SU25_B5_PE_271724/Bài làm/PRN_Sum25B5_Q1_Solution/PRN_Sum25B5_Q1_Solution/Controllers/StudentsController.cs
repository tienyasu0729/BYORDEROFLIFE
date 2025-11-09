using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.OData.Query;
using PRN_Sum25B5_Q1_Solution.Models;

namespace PRN_Sum25B5_Q1_Solution.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentsController : ControllerBase
    {
        private readonly CodeDbContext _context;

        public StudentsController(CodeDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        [EnableQuery] // Bật OData
        public IActionResult GetStudents()
        {
            var students = _context.Students.AsQueryable();
            if (students == null || !students.Any())
            {
                return NoContent(); // 204 No Content [cite: 80]
            }
            return Ok(students); // 200 OK [cite: 79]
        }
    }
}
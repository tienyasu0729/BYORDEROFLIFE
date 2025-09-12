using eStoreAPI.Models;
using Microsoft.AspNetCore.Mvc;

namespace eStoreAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CategoryController : ControllerBase
    {
        private static List<Category> categories = new List<Category>
        {
            new Category { CategoryId = 1, CategoryName = "Electronics" },
            new Category { CategoryId = 2, CategoryName = "Accessories" }
        };

        // GET: api/Category
        [HttpGet]
        public ActionResult<IEnumerable<Category>> GetAll()
        {
            return Ok(categories);
        }

        // GET: api/Category/1
        [HttpGet("{id}")]
        public ActionResult<Category> GetById(int id)
        {
            var category = categories.FirstOrDefault(c => c.CategoryId == id);
            if (category == null)
            {
                return NotFound();
            }
            return Ok(category);
        }

        // POST: api/Category
        [HttpPost]
        public ActionResult<Category> Post(Category category)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            category.CategoryId = categories.Any() ? categories.Max(c => c.CategoryId) + 1 : 1;
            categories.Add(category);
            return CreatedAtAction(nameof(GetById), new { id = category.CategoryId }, category);
        }
    }
}
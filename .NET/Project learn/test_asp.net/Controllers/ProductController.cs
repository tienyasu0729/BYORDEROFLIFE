using Microsoft.AspNetCore.Mvc;
using test_asp.net.Models;

namespace test_asp.net.Controllers
{
    public class ProductController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
        
        public IActionResult Details(string id)
        {
            return View(new Product()
            {
                Id = id,
                Name = $"Product test name: {id}",
            });
        }
    }
}

using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using test_asp.net.Models;

namespace test_asp.net.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly IRepository repository;

        public HomeController(IRepository repository, ILogger<HomeController> logger)
        {
            this.repository = repository;
            _logger = logger;
        }

        public IActionResult Index()
        {
            return View();
        }

        public IActionResult NewActionMethod(String name)
        {
            return Content("asdasdasdasdadasd" + repository.getId("abc ") + name);
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}

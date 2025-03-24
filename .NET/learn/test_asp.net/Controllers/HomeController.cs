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
            return View(new HelloModel {Name = "ASPPPPPP"});
        }

        public IActionResult NewActionMethod(String name)
        {
            //return Content("asdasdasdasdadasd" + repository.getId("abc ") + name);
            //return View("Index", new HelloModel { Name = "23423423423" });
            return View();
        }

        [NonAction]
        public ActionResult Contact()
        {
            return View();
        }

        // Mặc định nếu viết hàm public hay hàm nằm trong controller thì asp sẽ tự động coi nó là 1 action method ( đường đãn tới url )
        public ActionResult testMethod()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}

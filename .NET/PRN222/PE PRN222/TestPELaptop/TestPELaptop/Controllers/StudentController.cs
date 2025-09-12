using GroupProjectDataAccess;
using Microsoft.AspNetCore.Mvc;

namespace TestPELaptop.Controllers
{  
    public class StudentController : Controller
    {
        public IActionResult Dashboard()
        {
            var team = TeamDAO.GetById((int)(HttpContext.Session.GetInt32("UserId")));
            return View(team);
        }
            
        public IActionResult CreateTeam()
        {
            return View();
        }
    }
}

using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace FUNewsManagementSystem.Controllers
{
    public class IndexController : Controller
    {
        private readonly ILogger<IndexController> _logger;

        public IndexController(ILogger<IndexController> logger)
        {
            _logger = logger;
        }

        //[HttpGet]
        //public IActionResult ExternalLogin(string provider)
        //{
        //    var redirectUrl = Url.Action("ExternalLoginCallback", "Account", values: null, protocol: Request.Scheme);
        //    var properties = new AuthenticationProperties { RedirectUri = redirectUrl };
        //    return Challenge(properties, provider);
        //}
    }
}

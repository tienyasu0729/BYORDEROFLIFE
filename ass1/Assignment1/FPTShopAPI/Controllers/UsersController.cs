using Microsoft.AspNetCore.Mvc;
using Services;

namespace FPTShopAPI.Controllers
{
    // Lớp nhỏ để nhận dữ liệu JSON cho việc đăng nhập
    public class LoginRequest
    {
        public string Email { get; set; }
        public string Password { get; set; }
    }

    [Route("api/[controller]")]
    [ApiController]
    public class UsersController : ControllerBase
    {
        private readonly IUserService _userService = new UserService();

        // POST: api/users/login
        [HttpPost("login")]
        public IActionResult Login(LoginRequest request)
        {
            var user = _userService.Login(request.Email, request.Password);
            if (user == null)
            {
                return Unauthorized("Invalid email or password.");
            }
            return Ok(user);
        }
    }
}
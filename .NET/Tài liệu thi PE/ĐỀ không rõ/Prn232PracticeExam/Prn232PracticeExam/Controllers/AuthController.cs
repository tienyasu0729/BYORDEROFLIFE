using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;
using System.ComponentModel.DataAnnotations;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;

namespace Prn232PracticeExam.Controllers
{
    // Các DTO (Lớp đối tượng truyền dữ liệu)
    // Để đơn giản, tôi đặt chúng ở đây. Bạn có thể tạo file riêng.
    public class AuthRequest
    {
        [Required]
        public string Email { get; set; }
        [Required]
        public string Password { get; set; }
    }
    public class AuthResponse
    {
        public string Token { get; set; }
    }


    [Route("api/[controller]")]
    [ApiController]
    public class AuthController : ControllerBase
    {
        private readonly IConfiguration _config;

        public AuthController(IConfiguration config)
        {
            _config = config;
        }

        [HttpPost]
        public IActionResult Login([FromBody] AuthRequest login)
        {
            // Yêu cầu hardcode của đề bài
            if (login.Email == "administrator@leopard.com" && login.Password == "admin")
            {
                var token = GenerateJwtToken(login.Email, "Administrator");
                return Ok(new AuthResponse { Token = token });
            }

            // Các role khác (Moderator, Developer, Member) không được cấp token
            // Trả về lỗi 401 với format yêu cầu (Mục 2.3)
            return Unauthorized(new { errorCode = "HB40101", errorMessage = "Invalid credentials or role not allowed" });
        }

        private string GenerateJwtToken(string email, string role)
        {
            var securityKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_config["Jwt:Key"]));
            var credentials = new SigningCredentials(securityKey, SecurityAlgorithms.HmacSha256);

            var claims = new[]
            {
                new Claim(JwtRegisteredClaimNames.Email, email),
                new Claim(ClaimTypes.Role, role), // Đây là mấu chốt để phân quyền
                new Claim(JwtRegisteredClaimNames.Jti, Guid.NewGuid().ToString())
            };

            var token = new JwtSecurityToken(
                issuer: _config["Jwt:Issuer"],
                audience: _config["Jwt:Audience"],
                claims: claims,
                expires: DateTime.Now.AddHours(2), // Token hết hạn sau 2 giờ
                signingCredentials: credentials);

            return new JwtSecurityTokenHandler().WriteToken(token);
        }
    }
}
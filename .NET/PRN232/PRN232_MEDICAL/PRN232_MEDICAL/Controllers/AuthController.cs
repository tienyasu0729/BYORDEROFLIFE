using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using PRN232_MEDICAL.Data;
using PRN232_MEDICAL.DTOs;
using PRN232_MEDICAL.Models;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;

namespace PRN232_MEDICAL.Controllers
{
    [Route("api/auth")]
    [ApiController]
    public class AuthController : ControllerBase
    {
        private readonly ApplicationDbContext _context;
        private readonly IConfiguration _config;

        public AuthController(ApplicationDbContext context, IConfiguration config)
        {
            _context = context;
            _config = config;
        }

        [HttpPost("login")] // Endpoint: /api/auth/login 
        public async Task<IActionResult> Login([FromBody] LoginRequest loginRequest)
        {
            // 1. Tìm user theo email
            var user = await _context.Users
                .SingleOrDefaultAsync(u => u.Email == loginRequest.Email);

            // 2. Kiểm tra user và mật khẩu
            // !!! LƯU Ý QUAN TRỌNG:
            // Trong thực tế, bạn PHẢI HASH mật khẩu khi đăng ký
            // và dùng BCrypt.Net.BCrypt.Verify() để kiểm tra.
            // Ở đây, chúng ta tạm thời so sánh mật khẩu dạng văn bản thô (plain text)
            // để đơn giản hóa bài làm.
            if (user == null || user.Password != loginRequest.Password)
            {
                return Unauthorized("Invalid Email or Password.");
            }

            // 3. Nếu hợp lệ, tạo JWT Token
            var token = GenerateJwtToken(user);

            return Ok(new { token = token }); // Trả về token cho client 
        }

        private string GenerateJwtToken(User user)
        {
            var tokenHandler = new JwtSecurityTokenHandler();
            // Lấy khóa bí mật từ appsettings.json
            var key = Encoding.ASCII.GetBytes(_config["JwtSettings:Key"]);

            // Tạo các "Claims" (thông tin chứa trong token)
            var claims = new[]
            {
                new Claim(ClaimTypes.NameIdentifier, user.UserId.ToString()), // UserId 
                new Claim(ClaimTypes.Email, user.Email), // Email 
                new Claim(ClaimTypes.Role, user.Role) // Role 
            };

            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(claims),
                Expires = DateTime.UtcNow.AddDays(1), // Token hết hạn sau 1 ngày
                SigningCredentials = new SigningCredentials(
                    new SymmetricSecurityKey(key),
                    SecurityAlgorithms.HmacSha256Signature
                )
            };

            var token = tokenHandler.CreateToken(tokenDescriptor);
            return tokenHandler.WriteToken(token);
        }
    }
}

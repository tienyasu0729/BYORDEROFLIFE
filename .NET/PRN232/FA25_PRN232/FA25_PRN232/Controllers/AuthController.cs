using FA25_PRN232.DTOs;
using FA25_PRN232.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using FA25_PRN232.DTOs; // Namespace DTO
using FA25_PRN232.Models; // Namespace Models

namespace FA25_PRN232.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AuthController : ControllerBase
    {
        private readonly SU25_PRN232_01Context _context;

        public AuthController(SU25_PRN232_01Context context)
        {
            _context = context;
        }

        // POST /api/auth/login
        [HttpPost("login")]
        public async Task<IActionResult> Login([FromBody] LoginRequestDto loginRequest)
        {
            // Tìm user dựa trên Email
            var user = await _context.Users
                .FirstOrDefaultAsync(u => u.Email == loginRequest.Email);

            // Kiểm tra user và password
            // Dữ liệu trong file .sql của bạn là 'admin' và 'staff', không phải hash
            // nên ta so sánh trực tiếp
            if (user == null || user.PasswordHash != loginRequest.Password)
            {
                return Unauthorized("Invalid email or password.");
            }

            var loginResponse = new
            {
                user.UserId,
                user.Role
            };

            return Ok(loginResponse);
        }
    }
}
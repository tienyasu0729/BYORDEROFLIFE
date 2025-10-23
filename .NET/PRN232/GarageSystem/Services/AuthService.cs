using Repositories.IRepository;
using Services.DTOs;
using Services.IService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class AuthService : IAuthService
    {
        private readonly IUserRepository _userRepository;

        public AuthService(IUserRepository userRepository)
        {
            _userRepository = userRepository;
        }

        public async Task<LoginResponseDto> LoginAsync(LoginRequestDto request)
        {
            var user = await _userRepository.GetUserByEmailAndPassword(request.Email, request.Password);
            if (user == null)
            {
                return null; // Đăng nhập thất bại
            }

            return new LoginResponseDto
            {
                UserId = user.UserId,
                Role = user.Role
            };
        }
    }
}

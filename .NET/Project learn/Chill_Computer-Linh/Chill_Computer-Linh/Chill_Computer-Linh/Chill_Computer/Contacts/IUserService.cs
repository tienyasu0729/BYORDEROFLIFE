using Chill_Computer.Models;
using Chill_Computer.ViewModels;
using System.Threading.Tasks;

namespace Chill_Computer.Services
{
    public interface IUserService
    {
        Task<bool> LoginAsync(string username, string password);
        Task<bool> RegisterAsync(RegisterViewModel model);
        Task<bool> VerifyEmailAsync(string email);
        Task<bool> ChangePasswordAsync(string username, string oldPassword, string newPassword);
    }
}


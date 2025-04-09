using Chill_Computer.Models;
using Chill_Computer.ViewModels;
using Microsoft.EntityFrameworkCore;

namespace Chill_Computer.Services
{
    public class UserService : IUserService
    {
        private readonly ChillComputerContext _context;

        public UserService(ChillComputerContext context)
        {
            _context = context;
        }

        public async Task<bool> LoginAsync(string username, string password)
        {
            var account = await _context.Accounts
                .FirstOrDefaultAsync(a => a.UserName == username && a.Password == password);
            return account != null;
        }

        public async Task<bool> RegisterAsync(RegisterViewModel model)
        {
            // Check if username or email already exists
            if (await _context.Accounts.AnyAsync(a => a.UserName == model.UserName))
            {
                return false;
            }

            // Create new Account
            var account = new Account
            {
                UserName = model.UserName,
                Password = model.Password, // In production, hash the password
                RoleId = 2 // Default role (e.g., User role)
            };

            // Add to database
            _context.Accounts.Add(account);
            
            try
            {
                await _context.SaveChangesAsync();
                return true;
            }
            catch
            {
                return false;
            }
        }

        public async Task<bool> VerifyEmailAsync(string email)
        {
            var user = await _context.Users
                .FirstOrDefaultAsync(u => u.Email == email);
            return user != null; // Return true if email exists (for sending reset link)
        }

        public async Task<bool> ChangePasswordAsync(string username, string oldPassword, string newPassword)
        {
            var account = await _context.Accounts
                .FirstOrDefaultAsync(a => a.UserName == username && a.Password == oldPassword);

            if (account == null)
            {
                return false; // Invalid username or old password
            }

            account.Password = newPassword; // In production, hash the password
            try
            {
                await _context.SaveChangesAsync();
                return true;
            }
            catch
            {
                return false;
            }
        }
    }
}
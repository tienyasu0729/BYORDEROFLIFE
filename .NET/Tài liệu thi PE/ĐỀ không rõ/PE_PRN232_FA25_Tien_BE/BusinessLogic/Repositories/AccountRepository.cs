using BusinessLogic.Repositories.Interfaces;
using DataAccess;
using DataAccess.Models;
using Microsoft.EntityFrameworkCore;
using System.Threading.Tasks;
using BusinessLogic.Repositories.Interfaces;
using DataAccess;
using DataAccess.Models;

namespace BusinessLogic.Repositories
{
    public class AccountRepository : IAccountRepository
    {
        private readonly FA25BearDBContext _context;

        public AccountRepository(FA25BearDBContext context)
        {
            _context = context;
        }

        public async Task<BearAccount> LoginAsync(string email, string password)
        {
            // Tìm tài khoản bằng Email (UserName) và Password
            // Đây là cách xác thực không an toàn, chỉ dùng cho bài thi
            return await _context.BearAccounts
                .FirstOrDefaultAsync(a => a.Email == email && a.Password == password);
        }
    }
}
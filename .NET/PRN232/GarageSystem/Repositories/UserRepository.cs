using Data.Models;
using Microsoft.EntityFrameworkCore;
using Repositories.IRepository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class UserRepository : IUserRepository
    {
        private readonly SU25_PRN232_01Context _context;

        public UserRepository(SU25_PRN232_01Context context)
        {
            _context = context;
        }

        public async Task<User> GetUserByEmailAndPassword(string email, string password)
        {
            // Dùng PasswordHash == password vì file .sql đang lưu plain text
            return await _context.Users
                .FirstOrDefaultAsync(u => u.Email == email && u.PasswordHash == password);
        }
    }
}

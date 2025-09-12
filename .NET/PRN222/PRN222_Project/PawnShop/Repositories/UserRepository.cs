using BusinessObjects.Models;
using Repositories.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class UserRepository : IUserRepository
    {
        private readonly PawnShopDbContext _context;

        public UserRepository()
        {
            _context = new PawnShopDbContext();
        }

        public User GetUserByPhoneAndPassword(string phone, string password)
        {
            return _context.Users
                .FirstOrDefault(u => u.PhoneNumber == phone && u.Password == password);
        }
    }
}

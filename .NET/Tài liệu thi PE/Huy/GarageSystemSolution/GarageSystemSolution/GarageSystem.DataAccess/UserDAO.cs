using GarageSystem.BusinessLogic.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.DataAccess
{
    public class UserDAO
    {
        private readonly Su25Prn23201Context _context;

        public UserDAO(Su25Prn23201Context context)
        {
            _context = context;
        }

        public User? GetByEmailAndPassword(string email, string passwordHash) =>
            _context.Users.FirstOrDefault(u => u.Email == email && u.PasswordHash == passwordHash);

        public User? GetById(int id) => _context.Users.Find(id);
    }
}

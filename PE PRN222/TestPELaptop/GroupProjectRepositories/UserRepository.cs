using GroupProjectBusiness.Models;
using GroupProjectRepositories.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GroupProjectRepositories
{
    public class UserRepository : IRepository<User>
    {
        private readonly InnoCodeDbContext _context;

        public UserRepository(InnoCodeDbContext context)
        {
            _context = context;
        }

        public void Add(User entity)
        {
            _context.Users.Add(entity);
        }

        public void Delete(User entity)
        {
            _context.Users.Remove(entity);
        }

        public List<User> GetAll()
        {
            return _context.Users.ToList();
        }

        public User? GetById(int id)
        {
            return _context.Users.FirstOrDefault(u => u.Id == id);
        }

        public void Save()
        {
            _context.SaveChanges();
        }

        public void Update(User entity)
        {
            _context.Users.Update(entity);
        }

        public User GetToLogin(String email, String passwork)
        {
            return _context.Users.FirstOrDefault(u => u.Email == email && u.Passwork == passwork);
        }

        public bool EmailExists(string email)
        {
            return _context.Users.Any(u => u.Email == email);
        }

        public string? GetRoleByEmail(string email)
        {
            return _context.Users.Where(u => u.Email == email)
                                 .Select(u => u.Role)
                                 .FirstOrDefault();
        }
    }
}

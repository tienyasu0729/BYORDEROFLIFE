using GameProjectBusiness.Models;
using GameProjectRepositories.Repositories;
using GameProjectServices.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameProjectServices.Repositories
{
    public class UserSercvice : IUserSercvice
    {
        private readonly UserRepository _context = new UserRepository();



        public void Add(User entity)
        {
            _context.Add(entity);
        }

        public void Delete(User entity)
        {
            _context.Delete(entity);
        }

        public List<User> GetAll()
        {
            return _context.GetAll();
        }

        public User? GetById(int id)
        {
            return _context.GetById(id);
        }

        public void Save()
        {
            _context.Save();
        }

        public void Update(User entity)
        {
            _context.Update(entity);
        }

        public User GetToLogin(String email, String password)
        {
            return _context.GetToLogin(email, password);
        }

        public bool EmailExists(string email)
        {
            return _context.EmailExists(email);
        }

        public string GetRoleByEmail(string email)
        {
            return _context.GetRoleByEmail(email);
        }
    }
}

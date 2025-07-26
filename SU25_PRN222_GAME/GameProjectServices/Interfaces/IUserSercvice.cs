using GameProjectBusiness.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameProjectServices.Interfaces
{
    public interface IUserSercvice
    {
        public void Add(User entity);

        public void Delete(User entity);

        public List<User> GetAll();

        public User? GetById(int id);

        public void Save();

        public void Update(User entity);

        public User GetToLogin(String email, String password);

        public bool EmailExists(string email);

        public string GetRoleByEmail(string email);
    }
}

using GameProjectBusiness.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameProjectRepositories.Interfaces
{
    public interface IUserRepository
    {
        void Add(User entity);

        void Delete(User entity);

        List<User> GetAll();

        User? GetById(int id);

        void Save();

        void Update(User entity);

        User GetToLogin(String email, String password);

        bool EmailExists(string email);

        string GetRoleByEmail(string email);
    }
}

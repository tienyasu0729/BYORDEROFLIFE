using GroupProjectBusiness.Models;
using GroupProjectRepositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GroupProjectDataAccess
{
    public class UserDAO
    {
        private static readonly UserRepository repository = new UserRepository(new InnoCodeDbContext());

        public static List<User> GetAll()
        {
            return repository.GetAll();
        }

        public static User? GetById(int id)
        {
            return repository.GetById(id);
        }

        public static void Add(User user)
        {
            repository.Add(user);
            repository.Save();
        }

        public static void Update(User user)
        {
            repository.Update(user);
            repository.Save();
        }

        public static void Delete(User user)
        {
            repository.Delete(user);
            repository.Save();
        }

        public static User? GetToLogin(string email, string password)
        {
            return repository.GetToLogin(email, password);
        }

        public static bool EmailExists(string email)
        {
            return repository.EmailExists(email);
        }

        public static string? GetRoleByEmail(string email)
        {
            return repository.GetRoleByEmail(email);
        }
    }
}

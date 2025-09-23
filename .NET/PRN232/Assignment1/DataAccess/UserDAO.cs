using BusinessObjects;
using BusinessObjects.Models;
using System.Linq;

namespace DataAccessLayer
{
    public class UserDAO
    {
        public User GetById(int id)
        {
            using var context = new FptshopDbContext();
            return context.Users.FirstOrDefault(u => u.UserId == id);
        }

        public User GetByEmailAndPassword(string email, string password)
        {
            using var context = new FptshopDbContext();
            return context.Users.FirstOrDefault(u => u.Email == email && u.Password == password);
        }
    }
}
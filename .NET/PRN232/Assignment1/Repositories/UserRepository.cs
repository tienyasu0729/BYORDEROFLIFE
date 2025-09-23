using BusinessObjects;
using BusinessObjects.Models;
using DataAccessLayer;

namespace Repositories
{
    public class UserRepository : IUserRepository
    {
        private readonly UserDAO userDAO = new UserDAO();

        public User GetById(int id)
        {
            return userDAO.GetById(id);
        }

        public User GetByEmailAndPassword(string email, string password)
        {
            return userDAO.GetByEmailAndPassword(email, password);
        }
    }
}
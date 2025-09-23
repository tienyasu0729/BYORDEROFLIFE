using BusinessObjects.Models;
using Repositories;

namespace Services
{
    public class UserService : IUserService
    {
        private readonly IUserRepository _userRepository = new UserRepository();

        public User GetUserById(int id)
        {
            return _userRepository.GetById(id);
        }

        public User Login(string email, string password)
        {
            return _userRepository.GetByEmailAndPassword(email, password);
        }
    }
}
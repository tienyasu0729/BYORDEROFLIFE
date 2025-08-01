using BusinessObjects.Models;
using Repositories;
using Repositories.Interface;
using Services.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class UserService : IUserService
    {
        private readonly IUserRepository _userRepository;

        public UserService()
        {
            _userRepository = new UserRepository();
        }

        public User GetUserByPhoneAndPassword(string phone, string password)
        {
            return _userRepository.GetUserByPhoneAndPassword(phone, password);
        }
    }
}

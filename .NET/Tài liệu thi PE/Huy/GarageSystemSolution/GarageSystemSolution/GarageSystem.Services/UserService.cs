using GarageSystem.BusinessLogic.Models;
using GarageSystem.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.Services
{
    public class UserService : IUserService
    {
        private readonly IUserRepository _repo;

        public UserService(IUserRepository repo)
        {
            _repo = repo;
        }

        public User? GetByEmailAndPassword(string email, string passwordHash) =>
            _repo.GetByEmailAndPassword(email, passwordHash);

        public User? GetById(int id) => _repo.GetById(id);
    }
}

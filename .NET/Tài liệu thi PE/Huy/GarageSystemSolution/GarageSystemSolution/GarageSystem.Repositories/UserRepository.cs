using GarageSystem.BusinessLogic.Models;
using GarageSystem.DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.Repositories
{
    public class UserRepository : IUserRepository
    {
        private readonly UserDAO _dao;

        public UserRepository(UserDAO dao)
        {
            _dao = dao;
        }

        public User? GetByEmailAndPassword(string email, string passwordHash) =>
            _dao.GetByEmailAndPassword(email, passwordHash);

        public User? GetById(int id) => _dao.GetById(id);
    }
}

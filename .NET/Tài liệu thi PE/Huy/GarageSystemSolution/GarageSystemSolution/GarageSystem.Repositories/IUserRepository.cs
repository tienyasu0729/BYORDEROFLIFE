using GarageSystem.BusinessLogic.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.Repositories
{
    public interface IUserRepository
    {
        User? GetByEmailAndPassword(string email, string passwordHash);
        User? GetById(int id);
    }
}

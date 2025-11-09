using GarageSystem.BusinessLogic.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.Repositories
{
    public interface IVehicleRepository
    {
        List<Vehicle> GetAll();
        List<Vehicle> GetByUserId(int userId);
        Vehicle? GetById(int id);
        void Add(Vehicle v);
        void Update(Vehicle v);
        void Delete(Vehicle v);
    }
}

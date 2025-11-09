using GarageSystem.BusinessLogic.Models;
using GarageSystem.DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.Repositories
{
    public class VehicleRepository : IVehicleRepository
    {
        private readonly VehicleDAO _dao;
        public VehicleRepository(VehicleDAO dao) => _dao = dao;

        public List<Vehicle> GetAll() => _dao.GetAll();
        public List<Vehicle> GetByUserId(int userId) => _dao.GetByUserId(userId);
        public Vehicle? GetById(int id) => _dao.GetById(id);
        public void Add(Vehicle v) => _dao.Add(v);
        public void Update(Vehicle v) => _dao.Update(v);
        public void Delete(Vehicle v) => _dao.Delete(v);
    }
}

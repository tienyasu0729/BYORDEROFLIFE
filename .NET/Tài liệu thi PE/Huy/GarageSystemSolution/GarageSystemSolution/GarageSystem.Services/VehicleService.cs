using GarageSystem.BusinessLogic.Models;
using GarageSystem.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.Services
{
    public class VehicleService : IVehicleService
    {
        private readonly IVehicleRepository _repo;

        public VehicleService(IVehicleRepository repo)
        {
            _repo = repo;
        }

        public List<Vehicle> GetAll() => _repo.GetAll();
        public List<Vehicle> GetByUserId(int userId) => _repo.GetByUserId(userId);
        public Vehicle? GetById(int id) => _repo.GetById(id);
        public void Add(Vehicle v) => _repo.Add(v);
        public void Update(Vehicle v) => _repo.Update(v);
        public void Delete(Vehicle v) => _repo.Delete(v);
    }
}

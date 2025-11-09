using GarageSystem.BusinessLogic.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.DataAccess
{
    public class VehicleDAO
    {
        private readonly Su25Prn23201Context _context;

        public VehicleDAO(Su25Prn23201Context context)
        {
            _context = context;
        }

        public List<Vehicle> GetAll() => _context.Vehicles.ToList();

        public List<Vehicle> GetByUserId(int userId) =>
            _context.Vehicles.Where(v => v.UserId == userId).ToList();

        public Vehicle? GetById(int id) => _context.Vehicles.Find(id);

        public void Add(Vehicle vehicle)
        {
            _context.Vehicles.Add(vehicle);
            _context.SaveChanges();
        }

        public void Update(Vehicle vehicle)
        {
            _context.Vehicles.Update(vehicle);
            _context.SaveChanges();
        }

        public void Delete(Vehicle vehicle)
        {
            _context.Vehicles.Remove(vehicle);
            _context.SaveChanges();
        }
    }
}

using GarageSystem.BusinessLogic.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.DataAccess
{
    public class ServiceOrderDAO
    {
        private readonly Su25Prn23201Context _context;

        public ServiceOrderDAO(Su25Prn23201Context context)
        {
            _context = context;
        }

        public void Create(ServiceOrder order)
        {
            _context.ServiceOrders.Add(order);
            _context.SaveChanges();
        }

        public List<ServiceOrder> GetAll() => _context.ServiceOrders.ToList();

        public List<ServiceOrder> GetByUser(int userId) =>
            _context.ServiceOrders
                .Where(o => o.Vehicle != null && o.Vehicle.UserId == userId)
                .ToList();
    }
}

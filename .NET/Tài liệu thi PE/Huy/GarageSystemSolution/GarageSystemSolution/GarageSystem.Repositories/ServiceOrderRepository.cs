using GarageSystem.BusinessLogic.Models;
using GarageSystem.DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.Repositories
{
    public class ServiceOrderRepository : IServiceOrderRepository
    {
        private readonly ServiceOrderDAO _dao;

        public ServiceOrderRepository(ServiceOrderDAO dao)
        {
            _dao = dao;
        }

        public void Create(ServiceOrder order) => _dao.Create(order);
        public List<ServiceOrder> GetAll() => _dao.GetAll();
        public List<ServiceOrder> GetByUser(int userId) => _dao.GetByUser(userId);
    }
}

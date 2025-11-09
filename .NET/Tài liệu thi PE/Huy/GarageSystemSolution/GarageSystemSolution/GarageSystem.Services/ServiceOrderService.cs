using GarageSystem.BusinessLogic.Models;
using GarageSystem.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.Services
{
    public class ServiceOrderService: IServiceOrderService
    {
        private readonly IServiceOrderRepository _repo;

        public ServiceOrderService(IServiceOrderRepository repo)
        {
            _repo = repo;
        }

        public void Create(ServiceOrder order) => _repo.Create(order);
        public List<ServiceOrder> GetAll() => _repo.GetAll();
        public List<ServiceOrder> GetByUser(int userId) => _repo.GetByUser(userId);
    }
}

using GarageSystem.BusinessLogic.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageSystem.Repositories
{
    public interface IServiceOrderRepository
    {
        void Create(ServiceOrder order);
        List<ServiceOrder> GetAll();
        List<ServiceOrder> GetByUser(int userId);
    }
}

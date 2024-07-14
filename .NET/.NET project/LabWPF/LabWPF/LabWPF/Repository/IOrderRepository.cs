using BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
    public interface IOrderRepository
    {
        Task<IEnumerable<Order>> GetAllOrder();
        Task<Order> GetOrderById(int id);

        Task AddOrder(Order order);

        Task UpdateOrder(Order order);
        Task DeleteOrder(int id);
    }
}

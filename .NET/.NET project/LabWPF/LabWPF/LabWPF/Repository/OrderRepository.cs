using BusinessObject;
using DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
    public class OrderRepository : IOrderRepository
    {


        public async Task AddOrder(Order order) => await OrderDAO.instance.Add(order);

        public async Task DeleteOrder(int id) => await OrderDAO.instance.Delete(id);


        public async Task<IEnumerable<Order>> GetAllOrder() => await OrderDAO.instance.GetOrdersAll();


        public async Task<Order> GetOrderById(int id) => await OrderDAO.instance.GetOrderById(id);

        public async Task Update(Order order) => await OrderDAO.instance.Update(order);


        public async Task UpdateOrder(Order order) => await OrderDAO.instance.Update(order);

    }
}

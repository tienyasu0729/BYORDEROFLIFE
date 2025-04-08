using BusinessObject;
using DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
    public class OrderDetailRepository : IOrderDetailRepository
    {
        public async Task AddOrderDetail(OrderDetail order) => await OrderDetailDAO.instance.Add(order);

        public async Task DeleteOrderDetail(int orderId, int productId) => await OrderDetailDAO.instance.Delete(orderId, productId);


        public async Task<IEnumerable<OrderDetail>> GetAllOrderDetail() => await OrderDetailDAO.instance.GetOrderDetailsAll();


        public async Task<IEnumerable<OrderDetail>> GetOrderDetailByOrderId(int orderId) => await OrderDetailDAO.instance.GetOrderDetailByOrderId(orderId);


        public async Task<OrderDetail> GetOrderDetailByOrderIdProductId(int orderId, int productId) => await OrderDetailDAO.instance.GetOrderDetailByOrderIdProductId(orderId, productId);

        public async Task UpdateOrderDetail(OrderDetail order) => await OrderDetailDAO.instance.Update(order);

    }
}


using BusinessObject;

namespace Repository
{
    public interface IOrderDetailRepository
    {
        Task<IEnumerable<OrderDetail>> GetAllOrderDetail();
        Task<IEnumerable<OrderDetail>> GetOrderDetailByOrderId(int orderId);
        Task<OrderDetail> GetOrderDetailByOrderIdProductId(int orderId, int productId);
        Task AddOrderDetail(OrderDetail order);

        Task UpdateOrderDetail(OrderDetail order);
        Task DeleteOrderDetail(int orderId, int productId);
    }
}

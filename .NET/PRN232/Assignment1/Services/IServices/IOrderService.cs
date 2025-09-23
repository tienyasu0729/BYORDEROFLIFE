using BusinessObjects.Models;

namespace Services
{
    public interface IOrderService
    {
        Order CreateOrder(int laptopId, int userId, int quantity);
    }
}
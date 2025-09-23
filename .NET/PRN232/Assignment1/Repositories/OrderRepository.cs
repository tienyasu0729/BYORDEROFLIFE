using BusinessObjects;
using BusinessObjects.Models;
using DataAccess;
using DataAccessLayer;

namespace Repositories
{
    public class OrderRepository : IOrderRepository
    {
        private readonly OrderDAO orderDAO = new OrderDAO();

        public void Add(Order order)
        {
            orderDAO.Add(order);
        }
    }
}
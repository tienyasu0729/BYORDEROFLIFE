using BusinessObjects;
using BusinessObjects.Models;

namespace DataAccess
{
    public class OrderDAO
    {
        public void Add(Order order)
        {
            using var context = new FptshopDbContext();
            context.Orders.Add(order);
            context.SaveChanges();
        }
    }
}
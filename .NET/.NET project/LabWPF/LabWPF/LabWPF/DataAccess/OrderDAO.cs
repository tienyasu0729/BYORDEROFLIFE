using BusinessObject;
using Microsoft.EntityFrameworkCore;

namespace DataAccess

{
    public class OrderDAO : SingletonBase<OrderDAO>
    {
        public async Task<IEnumerable<Order>> GetOrdersAll()
        {
            return await _context.Orders.ToArrayAsync();
        }

        public async Task<Order> GetOrderById(int id)
        {
            var order = await _context.Orders.FirstOrDefaultAsync(c => c.OrderId == id);
            if (order == null)
            {
                return null;
            }
            return order;
        }

        public async Task Add(Order order)
        {
            _context.Orders.Add(order);
            await _context.SaveChangesAsync();
        }

        public async Task Update(Order order)
        {
            var existingItem = await GetOrderById(order.OrderId);
            if (existingItem != null)
            {
                _context.Entry(existingItem).CurrentValues.SetValues(order);

            }
            await _context.SaveChangesAsync();
        }

        public async Task Delete(int id)
        {
            var existingItem = await GetOrderById(id);
            if (existingItem != null)
            {
                _context.Orders.Remove(existingItem);
                await _context.SaveChangesAsync();
            }
        }
    }
}

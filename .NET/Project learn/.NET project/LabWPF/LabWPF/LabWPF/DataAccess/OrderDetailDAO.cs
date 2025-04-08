using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BusinessObject;
using Microsoft.EntityFrameworkCore;

namespace DataAccess
{
    public class OrderDetailDAO : SingletonBase<OrderDetailDAO>
    {
        public async Task<IEnumerable<OrderDetail>> GetOrderDetailsAll()
        {
            return await _context.OrderDetails.ToArrayAsync();
        }

        public async Task<IEnumerable<OrderDetail>> GetOrderDetailByOrderId(int orderId)
        {
            var order = await _context.OrderDetails.Where(c => c.OrderId == orderId).ToListAsync();
            if (order == null)
            {
                return null;
            }
            return order;
        }

        public async Task<OrderDetail> GetOrderDetailByOrderIdProductId(int orderId, int productId)
        {
            var order = await _context.OrderDetails.FirstOrDefaultAsync(c => c.ProductId == productId && c.OrderId == orderId);
            if (order == null)
            {
                return null;
            }
            return order;
        }

        public async Task Add(OrderDetail order)
        {
            _context.OrderDetails.AddAsync(order);
            await _context.SaveChangesAsync();
        }

        public async Task Update(OrderDetail order)
        {
            var existingItem = await GetOrderDetailByOrderIdProductId(order.OrderId, order.ProductId);
            if (existingItem != null)
            {
                _context.Entry(existingItem).CurrentValues.SetValues(existingItem);

            }
            await _context.SaveChangesAsync();
        }

        public async Task Delete(int orderId, int productId)
        {
            var existingItem = await GetOrderDetailByOrderIdProductId(orderId, productId);
            if (existingItem != null)
            {
                _context.OrderDetails.Remove(existingItem);
                await _context.SaveChangesAsync();
            }
        }
    }
}

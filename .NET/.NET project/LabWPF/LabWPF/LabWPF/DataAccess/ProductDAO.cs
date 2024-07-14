using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BusinessObject;
using Microsoft.EntityFrameworkCore;

namespace DataAccess
{
    public class ProductDAO : SingletonBase<ProductDAO>
    {
        public async Task<IEnumerable<Product>> GetProductsAll()
        {
            return await _context.Products.ToArrayAsync();
        }

        public async Task<Product> GetProductById(int id)
        {
            var Product = await _context.Products.FirstOrDefaultAsync(c => c.ProductId == id);
            if (Product == null)
            {
                return null;
            }
            return Product;
        }

        public async Task Add(Product Product)
        {
            _context.Products.Add(Product);
            await _context.SaveChangesAsync();
        }

        public async Task Update(Product Product)
        {
            var existingItem = await GetProductById(Product.ProductId);
            if (existingItem != null)
            {
                _context.Entry(existingItem).CurrentValues.SetValues(Product);

            }
            await _context.SaveChangesAsync();
        }

        public async Task Delete(int id)
        {
            var existingItem = await GetProductById(id);
            if (existingItem != null)
            {
                _context.Products.Remove(existingItem);
                await _context.SaveChangesAsync();
            }
        }
    }
}

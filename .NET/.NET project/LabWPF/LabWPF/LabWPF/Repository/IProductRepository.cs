using BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
    public interface IProductRepository
    {
        Task<IEnumerable<Product>> GetAllProduct();
        Task<Product> GetPoductById(int id);

        Task AddProduct(Product order);

        Task UpdateProduct(Product order);
        Task DeleteProduct(int id);
    }
}

using BusinessObject;
using DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
    public class ProductRepository : IProductRepository
    {
        public async Task AddProduct(Product order) => await ProductDAO.instance.Add(order);


        public async Task DeleteProduct(int id) => await ProductDAO.instance.Delete(id);

        public async Task<IEnumerable<Product>> GetAllProduct() => await ProductDAO.instance.GetProductsAll();


        public async Task<Product> GetPoductById(int id) => await ProductDAO.instance.GetProductById(id);


        public async Task UpdateProduct(Product order) => await ProductDAO.instance.Update(order);

    }
}

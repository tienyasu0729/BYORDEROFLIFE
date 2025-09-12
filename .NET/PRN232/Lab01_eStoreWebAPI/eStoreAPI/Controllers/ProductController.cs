using eStoreAPI.Models;
using Microsoft.AspNetCore.Mvc;

namespace eStoreAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProductController : ControllerBase
    {
        // Dữ liệu giả lập, sử dụng List<T> làm nguồn dữ liệu tạm thời
        private static List<Product> products = new List<Product>
        {
            new Product { ProductId = 1, ProductName = "Laptop Dell XPS", UnitPrice = 2500, UnitsInStock = 10, CategoryId = 1 },
            new Product { ProductId = 2, ProductName = "Monitor Samsung 27 inch", UnitPrice = 300, UnitsInStock = 20, CategoryId = 1 },
            new Product { ProductId = 3, ProductName = "Bàn phím cơ", UnitPrice = 150, UnitsInStock = 50, CategoryId = 2 }
        };

        // GET: api/Product
        [HttpGet]
        public ActionResult<IEnumerable<Product>> GetAll()
        {
            return Ok(products);
        }

        // GET: api/Product/5
        [HttpGet("{id}")]
        public ActionResult<Product> GetById(int id)
        {
            var product = products.FirstOrDefault(p => p.ProductId == id);
            if (product == null)
            {
                return NotFound(); // Trả về 404 Not Found nếu không tìm thấy
            }
            return Ok(product);
        }

        // POST: api/Product
        [HttpPost]
        public ActionResult<Product> Post(Product product)
        {
            // Validate model state
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }
            // Logic để tạo ID mới (trong ứng dụng thực tế sẽ tự động)
            product.ProductId = products.Any() ? products.Max(p => p.ProductId) + 1 : 1;
            products.Add(product);
            // Trả về 201 Created cùng với location của resource mới
            return CreatedAtAction(nameof(GetById), new { id = product.ProductId }, product);
        }

        // PUT: api/Product/5
        [HttpPut("{id}")]
        public IActionResult Put(int id, Product product)
        {
            if (id != product.ProductId)
            {
                return BadRequest("Product ID in URL must match Product ID in body.");
            }

            var existingProduct = products.FirstOrDefault(p => p.ProductId == id);
            if (existingProduct == null)
            {
                return NotFound();
            }

            // Cập nhật thông tin
            existingProduct.ProductName = product.ProductName;
            existingProduct.UnitPrice = product.UnitPrice;
            existingProduct.UnitsInStock = product.UnitsInStock;
            existingProduct.CategoryId = product.CategoryId;

            return NoContent(); // Trả về 204 No Content
        }

        // DELETE: api/Product/5
        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            var product = products.FirstOrDefault(p => p.ProductId == id);
            if (product == null)
            {
                return NotFound();
            }
            products.Remove(product);
            return NoContent(); // Trả về 204 No Content
        }
    }
}
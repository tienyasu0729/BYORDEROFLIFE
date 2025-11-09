using AutoMapper;
using FPTShopLaptopAPI.Data;
using FPTShopLaptopAPI.DTOs;
using FPTShopLaptopAPI.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace FPTShopLaptopAPI.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class OrdersController : ControllerBase
    {
        private readonly AppDbContext _context;
        private readonly IMapper _mapper;
        public OrdersController(AppDbContext context, IMapper mapper)
        {
            _context = context;
            _mapper = mapper;
        }

        /*[HttpPost]
        public IActionResult PlaceOrder([FromBody] Order order)
        {
            var laptop = _context.Laptops.Find(order.LaptopId);
            if (laptop == null || laptop.StockQuantity < order.Quantity)
                return BadRequest("Laptop not found or insufficient stock");

            laptop.StockQuantity -= order.Quantity;
            order.OrderDate = DateTime.Now;
            _context.Orders.Add(order);
            _context.SaveChanges();
            return Ok(order);
        }*/
        [HttpPost]
        public IActionResult PlaceOrder([FromBody] NewOrderDTO dto)
        {
            var laptop = _context.Laptops.FirstOrDefault(l => l.LaptopId == dto.LaptopId);
            if (laptop == null) return NotFound(new { msg = "Laptop not found" });

            if (laptop.StockQuantity < dto.Quantity)
                return BadRequest(new { msg = "Not enough stock" });

            laptop.StockQuantity -= dto.Quantity;

            var order = new Order
            {
                LaptopId = dto.LaptopId,
                UserId = dto.UserId,
                Quantity = dto.Quantity,
                OrderDate = DateTime.Now
            };

            _context.Orders.Add(order);
            _context.SaveChanges();

            return Ok(order);
        }


        [HttpGet]
        public IActionResult GetAllOrders()
        {
            var orders = _context.Orders.Include(o => o.Laptop).Include(o => o.User).ToList();
            var orderDtos = _mapper.Map<List<OrderDTO>>(orders);
            return Ok(orderDtos);
        }
    }
}

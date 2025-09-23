using Microsoft.AspNetCore.Mvc;
using Services;
using System;

namespace FPTShopAPI.Controllers
{
    // Lớp nhỏ để nhận dữ liệu JSON từ body request
    public class OrderInput
    {
        public int LaptopId { get; set; }
        public int UserId { get; set; }
        public int Quantity { get; set; }
    }

    [Route("api/[controller]")]
    [ApiController]
    public class OrdersController : ControllerBase
    {
        private readonly IOrderService _orderService = new OrderService();

        // POST: api/orders
        [HttpPost]
        public IActionResult PostOrder(OrderInput input)
        {
            try
            {
                var order = _orderService.CreateOrder(input.LaptopId, input.UserId, input.Quantity);
                return Ok(order);
            }
            catch (Exception ex)
            {
                // Trả về lỗi 400 Bad Request kèm thông báo lỗi từ Service
                return BadRequest(ex.Message);
            }
        }
    }
}
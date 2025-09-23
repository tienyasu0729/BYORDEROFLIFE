using BusinessObjects;
using BusinessObjects.Models;
using Repositories;
using System;

namespace Services
{
    public class OrderService : IOrderService
    {
        private readonly ILaptopRepository _laptopRepository = new LaptopRepository();
        private readonly IOrderRepository _orderRepository = new OrderRepository();

        // Thay đổi ở đây: nhận các tham số riêng lẻ
        public Order CreateOrder(int laptopId, int userId, int quantity)
        {
            if (quantity <= 0)
            {
                throw new Exception("Quantity must be greater than 0.");
            }

            var laptop = _laptopRepository.GetById(laptopId);

            if (laptop == null)
            {
                throw new Exception("Laptop not found.");
            }

            if (laptop.StockQuantity < quantity)
            {
                throw new Exception("Not enough stock available.");
            }

            laptop.StockQuantity -= quantity;
            _laptopRepository.Update(laptop);

            var order = new Order
            {
                LaptopId = laptopId,
                UserId = userId,
                Quantity = quantity,
                OrderDate = DateTime.Now
            };

            _orderRepository.Add(order);

            return order;
        }
    }
}
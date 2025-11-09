namespace FPTShopLaptopAPI.Models
{
    public class Order
    {
        public int OrderId { get; set; }
        public int LaptopId { get; set; }
        public Laptop? Laptop { get; set; }
        public int UserId { get; set; }
        public User? User { get; set; }
        public int Quantity { get; set; }
        public DateTime OrderDate { get; set; } = DateTime.Now;
    }
}

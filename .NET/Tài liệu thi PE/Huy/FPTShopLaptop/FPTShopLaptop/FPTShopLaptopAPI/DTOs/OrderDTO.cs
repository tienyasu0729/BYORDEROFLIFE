namespace FPTShopLaptopAPI.DTOs
{
    public class OrderDTO
    {
        
        public int OrderId { get; set; }
        public string LaptopName { get; set; }
        public string BuyerEmail { get; set; }
        public int Quantity { get; set; }
        public DateTime OrderDate { get; set; }
        
        

    }
}

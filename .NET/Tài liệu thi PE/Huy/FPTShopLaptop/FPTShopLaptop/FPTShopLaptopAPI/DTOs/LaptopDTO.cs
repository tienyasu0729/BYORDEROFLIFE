namespace FPTShopLaptopAPI.DTOs
{
    public class LaptopDTO
    {
        public int LaptopId { get; set; }
        public string Name { get; set; }
        public string Brand { get; set; }
        public decimal Price { get; set; }
        public int StockQuantity { get; set; }
        public string UploaderEmail { get; set; }
    }
}

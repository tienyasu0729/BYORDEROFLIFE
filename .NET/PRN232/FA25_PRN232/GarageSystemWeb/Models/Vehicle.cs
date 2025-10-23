namespace GarageSystemWeb.Models
{
    public class Vehicle
    {
        public int VehicleId { get; set; }
        public string PlateNumber { get; set; }
        public string? Brand { get; set; } // Đề bài cho phép Brand null [cite: 11]
        public string OwnerName { get; set; }
        public int UserId { get; set; }
    }
}

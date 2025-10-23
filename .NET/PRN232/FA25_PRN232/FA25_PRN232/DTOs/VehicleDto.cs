using System.ComponentModel.DataAnnotations; // << THÊM DÒNG NÀY

namespace FA25_PRN232.DTOs
{
    public class VehicleDto
    {
        [Key] // << THÊM ATTRIBUTE NÀY
        public int VehicleId { get; set; }

        public string PlateNumber { get; set; }
        public string? Brand { get; set; }
        public string OwnerName { get; set; }
    }
}
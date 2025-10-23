using System.ComponentModel.DataAnnotations;

namespace FA25_PRN232.DTOs
{
    public class VehicleCreateDto
    {
        [Required]
        public string PlateNumber { get; set; }
        public string? Brand { get; set; }
        [Required]
        public string OwnerName { get; set; }
        public int UserId { get; set; }
    }
}

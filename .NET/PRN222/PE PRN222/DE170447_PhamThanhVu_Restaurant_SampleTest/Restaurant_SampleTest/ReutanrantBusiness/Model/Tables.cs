using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace Restaurant_SampleTest.Models
{
    public class Tables
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int ID { get; set; }

        [Required]
        [Range(1, int.MaxValue)]  // Ensure the number of seats is >= 1
        public int TableNumber { get; set; }

        [Required]
        [Range(1, int.MaxValue)]  // Ensure the number of seats is >= 1
        public int Seats { get; set; }

        [Required]
        [MaxLength(50)]
        public string Status { get; set; }  // "Available", "Reserved", "Occupied"

        public DateTime CreatedAt { get; set; } = DateTime.Now;

        public ICollection<Reservation>? Reservations { get; set; }
    }
}

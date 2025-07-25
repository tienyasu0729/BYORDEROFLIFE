using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace Restaurant_SampleTest.Models
{
    public class Reservation
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int ID { get; set; }

        [ForeignKey("User")]
        public int UserID { get; set; }
        public virtual User User { get; set; }

        [ForeignKey("Tables")]
        public int TableID { get; set; }
        public virtual Tables Tables { get; set; }

        [Required]
        public DateTime ReservationDate { get; set; }

        [Required]
        [MaxLength(50)]
        public string Status { get; set; }  // "Pending", "Confirmed", "Cancelled"

        public DateTime CreatedAt { get; set; } = DateTime.Now;
    }
}

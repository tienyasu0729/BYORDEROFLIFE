using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace PRN232_MEDICAL.Models
{
    public class Appointment
    {
        [Key] // [cite: 14]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int AppointmentId { get; set; } // [cite: 14]

        [Required]
        public int DoctorId { get; set; } // [cite: 14]

        [Required]
        public int UserId { get; set; } // [cite: 14]

        [Required]
        public DateTime AppointmentDate { get; set; } // [cite: 14]

        [StringLength(50)]
        public string Status { get; set; } = "Pending"; // [cite: 14]

        [StringLength(300)]
        public string? Notes { get; set; } // [cite: 14]

        [ForeignKey("DoctorId")]
        public virtual Doctor Doctor { get; set; }

        [ForeignKey("UserId")]
        public virtual User User { get; set; }
    }
}
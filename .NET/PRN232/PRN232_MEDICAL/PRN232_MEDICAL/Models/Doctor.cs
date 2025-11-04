using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace PRN232_MEDICAL.Models
{
    public class Doctor
    {
        [Key] // [cite: 12]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int DoctorId { get; set; } // [cite: 12]

        [Required] // [cite: 12]
        [StringLength(100)]
        public string Name { get; set; } // [cite: 12]

        [Required] // [cite: 12]
        [StringLength(100)]
        public string Specialty { get; set; } // [cite: 12]

        [Required]
        [Column(TypeName = "decimal(18,2)")] // [cite: 12]
        [Range(0.01, double.MaxValue, ErrorMessage = "Fee must be greater than 0")] // [cite: 12, 24]
        public decimal Fee { get; set; } // [cite: 12]

        public bool Available { get; set; } = true; // [cite: 12]

        [StringLength(300)]
        public string? Description { get; set; } // [cite: 12]

        // Navigation property
        public virtual ICollection<Appointment> Appointments { get; set; }
    }
}
using System.ComponentModel.DataAnnotations;

namespace PRN232_MEDICAL.DTOs
{
    public class AppointmentCreateRequest
    {
        [Required]
        public int DoctorId { get; set; }

        [Required]
        public DateTime AppointmentDate { get; set; }

        [StringLength(300)]
        public string? Notes { get; set; }
    }
}

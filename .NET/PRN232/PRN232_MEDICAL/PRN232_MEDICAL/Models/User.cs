using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace PRN232_MEDICAL.Models
{
    public class User
    {
        [Key] //
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int UserId { get; set; } //

        [Required] //
        [StringLength(100)]
        public string FullName { get; set; } //

        [Required] //
        [StringLength(100)]
        public string Email { get; set; } //

        [Required] //
        [StringLength(100)]
        public string Password { get; set; } //

        [Required] //
        [StringLength(20)]
        public string Role { get; set; } //

        // Navigation property
        public virtual ICollection<Appointment> Appointments { get; set; }
    }
}
using System.ComponentModel.DataAnnotations;

namespace Chill_Computer.ViewModels
{
    public class ForgotPasswordViewModel
    {
        [Required(ErrorMessage = "Email is required")]
        [EmailAddress(ErrorMessage = "Invalid email address")]
        [MaxLength(30, ErrorMessage = "Email cannot exceed 30 characters")]
        public string Email { get; set; }
    }
}

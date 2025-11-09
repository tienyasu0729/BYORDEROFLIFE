using System.ComponentModel.DataAnnotations;

namespace BusinessLogic.DTOs
{
    public class LoginRequestDto
    {
        [Required]
        [EmailAddress]
        public string UserName { get; set; } // Chính là Email

        [Required]
        public string Password { get; set; }
    }
}
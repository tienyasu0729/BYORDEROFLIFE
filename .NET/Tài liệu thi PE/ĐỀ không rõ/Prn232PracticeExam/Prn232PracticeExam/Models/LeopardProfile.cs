using System.ComponentModel.DataAnnotations;

namespace Prn232PracticeExam.Models
{
    public class LeopardProfile
    {
        [Key] // Đánh dấu Id là khóa chính
        public int Id { get; set; }

        [Required(ErrorMessage = "LeopardName is required")]
        [RegularExpression(@"^([A-Z][a-z]+(\s[A-Z][a-z]+)*)$",
            ErrorMessage = "LeopardName must be in Capitalized-case format (e.g. 'Panthera Tigris')")]
        public string LeopardName { get; set; }

        public DateTime DateOfBirth { get; set; }

        public double Weight { get; set; }

        public string Description { get; set; }

        public DateTime LastSeen { get; set; }

        public string LastSeenLocation { get; set; }

        public DateTime? ModifiedDate { get; set; }
    }
}
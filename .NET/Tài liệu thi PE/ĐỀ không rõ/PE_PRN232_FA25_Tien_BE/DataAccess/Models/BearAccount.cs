using System.ComponentModel.DataAnnotations;

namespace DataAccess.Models
{
    public class BearAccount
    {
        [Key]
        public int AccountId { get; set; }

        [Required]
        [StringLength(100)]
        public string UserName { get; set; } // Sẽ dùng Email cho mục này

        [Required]
        [StringLength(100)]
        public string Password { get; set; }

        [StringLength(150)]
        public string FullName { get; set; }

        [Required]
        [StringLength(100)]
        public string Email { get; set; }

        [StringLength(15)]
        public string Phone { get; set; }

        [Required]
        public int RoleId { get; set; } // 1: Admin, 2: Manager, 3: Staff, 4: Member
    }
}
using System.ComponentModel.DataAnnotations;

namespace eStoreAPI.Models
{
    public class Category
    {
        [Required]
        public int CategoryId { get; set; }

        [Required]
        [StringLength(100)]
        public string CategoryName { get; set; }
    }
}

using System.ComponentModel.DataAnnotations;

namespace PawnShop.Models
{
    public class PawnItemViewModel
    {
        [Required]
        public string CustomerPhoneNumber { get; set; }

        [Required]
        public string CustomerName { get; set; }

        [Required]
        public string NameProduct { get; set; }

        public string? ProductDescription { get; set; }

        [Required]
        public int PawnPrice { get; set; }

        public string? Condition { get; set; }

        [Required]
        public DateTime PawnDate { get; set; }

        public int? PawnTime { get; set; }

        public List<IFormFile>? ImageFiles { get; set; }

        public int? IdCategory { get; set; }
    }
}

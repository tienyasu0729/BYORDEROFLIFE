using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace DataAccess.Models
{
    public class BearType
    {
        [Key]
        public int BearTypeId { get; set; }

        [Required]
        [StringLength(100)]
        public string BearTypeName { get; set; }

        [StringLength(200)]
        public string Origin { get; set; }

        public string Description { get; set; }

        // Navigation property
        public virtual ICollection<BearProfile> BearProfiles { get; set; }

        public BearType()
        {
            BearProfiles = new HashSet<BearProfile>();
        }
    }
}
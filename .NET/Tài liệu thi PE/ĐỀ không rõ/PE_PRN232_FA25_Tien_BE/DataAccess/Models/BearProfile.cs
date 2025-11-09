using DataAccess.Models;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace DataAccess.Models
{
    public class BearProfile
    {
        [Key]
        public int BearProfileId { get; set; }

        [Required]
        public int BearTypeId { get; set; }

        [Required]
        [StringLength(50)]
        public string BearName { get; set; }

        [Required]
        public double BearWeight { get; set; }

        public string Characteristics { get; set; }
        public string CareNeeds { get; set; }
        public DateTime ModifiedDate { get; set; }

        // Navigation property
        [ForeignKey("BearTypeId")]
        public virtual BearType BearType { get; set; }
    }
}
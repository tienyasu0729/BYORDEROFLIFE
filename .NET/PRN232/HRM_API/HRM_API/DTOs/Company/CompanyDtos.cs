using System.ComponentModel.DataAnnotations;

namespace HRM_API.DTOs.Company
{
    public class CompanyDto
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
    }

    public class CompanyCreateDto
    {
        [Required(ErrorMessage = "Tên công ty là bắt buộc.")]
        [StringLength(100, ErrorMessage = "Tên công ty không được vượt quá 100 ký tự.")]
        public string Name { get; set; }

        public string Address { get; set; }
    }

    public class CompanyUpdateDto : CompanyCreateDto
    {
        [Required]
        public byte[] RowVersion { get; set; }
    }
}
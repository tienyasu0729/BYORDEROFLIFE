using System;
using System.ComponentModel.DataAnnotations;

namespace BusinessLogic.DTOs
{
    public class BearProfileCreateDto
    {
        [Required]
        public int BearTypeId { get; set; }

        [Required]
        [StringLength(50, MinimumLength = 4, ErrorMessage = "BearName phải từ 4 đến 50 ký tự.")]
        [RegularExpression(@"^([A-Z][a-zA-Z]*)(\s[A-Z][a-zA-Z]*)*$",
            ErrorMessage = "BearName phải chứa (a-z, A-Z, space) và mỗi từ phải bắt đầu bằng ký tự hoa.")]
        public string BearName { get; set; }

        [Required]
        [Range(200.01, double.MaxValue, ErrorMessage = "BearWeight phải lớn hơn 200.")]
        public double BearWeight { get; set; }

        // Các trường này là bắt buộc theo đề bài (All fields are required)
        [Required]
        public string Characteristics { get; set; }

        [Required]
        public string CareNeeds { get; set; }
    }
}
using HRM_API.ValidationAttributes;
using System.ComponentModel.DataAnnotations;

namespace HRM_API.DTOs.Employee
{
    public class EmployeeDto
    {
        public int Id { get; set; }
        public string FullName { get; set; }
        public string Email { get; set; }
        public decimal Salary { get; set; }
        public int CompanyId { get; set; }
    }

    public class EmployeeCreateDto
    {
        [Required]
        public string FullName { get; set; }

        [Required]
        [EmailAddress]
        public string Email { get; set; }

        [Range(1000, 10000, ErrorMessage = "Lương phải từ 1000 đến 10000.")]
        public decimal Salary { get; set; }

        [Required]
        [ValidCompanyId] // Custom validation attribute 
        public int CompanyId { get; set; }
    }

    public class EmployeeUpdateDto : EmployeeCreateDto
    {
        [Required]
        public byte[] RowVersion { get; set; }
    }
}
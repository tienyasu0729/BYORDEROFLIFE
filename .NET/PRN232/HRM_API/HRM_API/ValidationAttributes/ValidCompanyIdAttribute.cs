using HRM_API.Repositories;
using System.ComponentModel.DataAnnotations;

namespace HRM_API.ValidationAttributes
{
    public class ValidCompanyIdAttribute : ValidationAttribute
    {
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            var companyId = (int)value;

            if (companyId <= 0)
            {
                return new ValidationResult("CompanyId phải là một số dương.");
            }

            // Lấy RepositoryManager từ DI container
            var repositoryManager = (IRepositoryManager)validationContext
                .GetService(typeof(IRepositoryManager));

            var company = repositoryManager.Company.GetCompany(companyId, trackChanges: false);

            if (company == null)
            {
                return new ValidationResult($"Không tìm thấy công ty với Id = {companyId}.");
            }

            return ValidationResult.Success;
        }
    }
}
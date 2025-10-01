using HRM_API.Data;
using HRM_API.Models;
using Microsoft.EntityFrameworkCore;

namespace HRM_API.Repositories
{
    public class CompanyRepository : ICompanyRepository
    {
        private readonly AppDbContext _context;

        public CompanyRepository(AppDbContext context)
        {
            _context = context;
        }

        public IEnumerable<Company> GetAllCompanies(bool trackChanges) =>
            !trackChanges ?
            _context.Companies.AsNoTracking().Where(c => !c.IsDeleted).ToList() :
            _context.Companies.Where(c => !c.IsDeleted).ToList();


        public Company GetCompany(int companyId, bool trackChanges) =>
            !trackChanges ?
            _context.Companies.AsNoTracking().FirstOrDefault(c => c.Id == companyId && !c.IsDeleted) :
            _context.Companies.FirstOrDefault(c => c.Id == companyId && !c.IsDeleted);

        public void CreateCompany(Company company) => _context.Companies.Add(company);

        public void DeleteCompany(Company company)
        {
            // Đây là soft delete, chỉ cập nhật trạng thái
            company.IsDeleted = true;
            _context.Companies.Update(company);
        }
    }
}
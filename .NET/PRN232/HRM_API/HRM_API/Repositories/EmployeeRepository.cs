using HRM_API.Data;
using HRM_API.Models;
using Microsoft.EntityFrameworkCore;

namespace HRM_API.Repositories
{
    public class EmployeeRepository : IEmployeeRepository
    {
        private readonly AppDbContext _context;

        public EmployeeRepository(AppDbContext context)
        {
            _context = context;
        }

        public IEnumerable<Employee> GetAllEmployees(bool trackChanges) =>
            !trackChanges ?
            _context.Employees.AsNoTracking().Where(e => !e.IsDeleted).ToList() :
            _context.Employees.Where(e => !e.IsDeleted).ToList();

        public Employee GetEmployee(int employeeId, bool trackChanges) =>
            !trackChanges ?
            _context.Employees.AsNoTracking().FirstOrDefault(e => e.Id == employeeId && !e.IsDeleted) :
            _context.Employees.FirstOrDefault(e => e.Id == employeeId && !e.IsDeleted);

        public Employee GetEmployeeForCompany(int companyId, int employeeId, bool trackChanges) =>
            !trackChanges ?
            _context.Employees.AsNoTracking()
                .FirstOrDefault(e => e.CompanyId == companyId && e.Id == employeeId && !e.IsDeleted) :
            _context.Employees
                .FirstOrDefault(e => e.CompanyId == companyId && e.Id == employeeId && !e.IsDeleted);

        public void CreateEmployee(Employee employee) => _context.Employees.Add(employee);

        public void DeleteEmployee(Employee employee)
        {
            employee.IsDeleted = true;
            _context.Employees.Update(employee);
        }
    }
}
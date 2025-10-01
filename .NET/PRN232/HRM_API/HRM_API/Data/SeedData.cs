using HRM_API.Models;
using Microsoft.EntityFrameworkCore;

namespace HRM_API.Data
{
    public static class SeedData
    {
        public static void Initialize(IServiceProvider serviceProvider)
        {
            using (var context = new AppDbContext(
                serviceProvider.GetRequiredService<DbContextOptions<AppDbContext>>()))
            {
                if (context.Companies.Any() || context.Employees.Any())
                {
                    return; // DB has been seeded
                }

                var companies = new List<Company>
                {
                    new Company { Name = "Tech Solutions Inc.", Address = "123 Tech Park" },
                    new Company { Name = "Innovate LLC", Address = "456 Innovation Ave" },
                    new Company { Name = "Data Systems", Address = "789 Data Drive" },
                    new Company { Name = "Cloud Services Co.", Address = "101 Cloud Way" },
                    new Company { Name = "SecureNet", Address = "212 Security Blvd" }
                };
                context.Companies.AddRange(companies);
                context.SaveChanges();

                var employees = new List<Employee>();
                var random = new Random();
                for (int i = 1; i <= 40; i++)
                {
                    employees.Add(new Employee
                    {
                        FullName = $"Employee {i}",
                        Email = $"employee{i}@example.com",
                        Salary = random.Next(1500, 8000),
                        CompanyId = companies[random.Next(companies.Count)].Id
                    });
                }
                context.Employees.AddRange(employees);
                context.SaveChanges();
            }
        }
    }
}
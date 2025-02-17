using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace test1
{
    class Program
    {
        static void Main()
        {
            Console.WriteLine("Choose Employee Type:");
            Console.WriteLine("1. Salaried Employee");
            Console.WriteLine("2. Hourly Employee");
            int choice = int.Parse(Validate.CheckInput());

            Console.Write("SSN: "); string ssn = Console.ReadLine();
            Console.Write("First Name: "); string firstName = Console.ReadLine();
            Console.Write("Last Name: "); string lastName = Console.ReadLine();
            Console.Write("Birth Date (dd/MM/yyyy): "); string birthDate = Console.ReadLine();
            Console.Write("Phone: "); string phone = Console.ReadLine();
            Console.Write("Email: "); string email = Console.ReadLine();

            if (choice == 1)
            {
                Console.Write(  "Commission Rate: "); double commissionRate = double.Parse(Console.ReadLine());
                Console.Write("Gross Sales: "); double grossSales = double.Parse(Console.ReadLine());
                Console.Write("Basic Salary: "); double basicSalary = double.Parse(Console.ReadLine());

                SalariedEmployee employee = new SalariedEmployee(ssn, firstName, lastName, birthDate, phone, email, commissionRate, grossSales, basicSalary);
                Console.WriteLine("Employee Created:");
                Console.WriteLine(employee);
            }
            else if (choice == 2)
            {
                Console.Write("Wage: "); double wage = double.Parse(Console.ReadLine());
                Console.Write("Working Hours: "); double workingHours = double.Parse(Console.ReadLine());

                HourlyEmployee employee = new HourlyEmployee(ssn, firstName, lastName, birthDate, phone, email, wage, workingHours);
                Console.WriteLine("Employee Created:");
                Console.WriteLine(employee);
            }
            else
            {
                Console.WriteLine("Invalid choice.");
            }
        }
    }
}

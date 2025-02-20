using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class SalariedEmployee : Employee
    {
        public double CommissionRate { get; set; }
        public double GrossSales { get; set; }
        public double BasicSalary { get; set; }

        public SalariedEmployee()
        {
        }

        public SalariedEmployee(string sSN, string firstName, string lastName, string birthDate, string phone, string email, double commissionRate, double grossSales, double basicSalary) : base(sSN, firstName, lastName, birthDate, phone, email)
        {
            CommissionRate = commissionRate;
            GrossSales = grossSales;
            BasicSalary = basicSalary;
        }

        public override string? ToString()
        {
            return base.ToString() + $", Commission Rate: {CommissionRate}, Gross Sales: {GrossSales}, Basic Salary: {BasicSalary}";
        }
    }


}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace test1
{
    class HourlyEmployee : Employee
    {
        public double Wage { get; set; }
        public double WorkingHours { get; set; }

        public HourlyEmployee(string ssn, string firstName, string lastName, string birthDate, string phone, string email,
                              double wage, double workingHours)
            : base(ssn, firstName, lastName, birthDate, phone, email)
        {
            Wage = wage;
            WorkingHours = workingHours;
        }

        public override string ToString()
        {
            return base.ToString() + $", Wage: {Wage}, Working Hours: {WorkingHours}";
        }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Reflection.Metadata.Ecma335;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Model
{
     abstract class Employee
    {
        private String SSN { get; set; }
        private String FirstName { get; set; }
        private String LastName { get; set; }
        private DateTime BirthDate { get; set; }
        private String Phone { get; set; }
        private String Email { get; set; }

        public Employee()
        {
        }

        public Employee(string sSN, string firstName, string lastName, string birthDate, string phone, string email)
        {
            SSN = sSN;
            FirstName = firstName;
            LastName = lastName;
            BirthDate = ValidateDate(birthDate);
            Phone = ValidatePhone(phone);
            Email = ValidateEmail(email);
        }

        private DateTime ValidateDate(string date)
        {
            if (DateTime.TryParseExact(date, "dd/MM/yyyy", null, System.Globalization.DateTimeStyles.None, out DateTime parsedDate))
            {
                return parsedDate;
            }
            throw new ArgumentException("Invalid birth date format. Use dd/MM/yyyy.");
        }

        private string ValidatePhone(string phone)
        {
            if (Regex.IsMatch(phone, @"^\d{7,}$"))
                return phone;
            throw new ArgumentException("Phone must be at least 7 digits.");
        }

        private string ValidateEmail(string email)
        {
            if (Regex.IsMatch(email, @"^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$"))
                return email;
            throw new ArgumentException("Invalid email format.");
        }

        public override string? ToString()
        {
            return $"SSN: {SSN}, Name: {FirstName} {LastName}, BirthDate: {BirthDate:dd/MM/yyyy}, Phone: {Phone}, Email: {Email}";
        }
    }
}

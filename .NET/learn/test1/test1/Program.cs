using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Model;
using Repository;
using Validate;

    namespace test1
    {
        class Program
        {
        static void Main()
            {
            while (true)
            {
                Console.WriteLine("Choose Employee Type:");
                Console.WriteLine("1. Salaried Employee");
                Console.WriteLine("2. Hourly Employee");
                int choice = int.Parse(ValidateMethod.CheckInput(@"^\d+$", "- Only numbers can be entered, please re-enter: "));
                switch (choice)
                {
                    case 1:
                        while (true)
                        {
                            Console.WriteLine("Please select the admin area you require \r\n1. Import Employee. \r\n2. Display Employers Information. \r\n3. Search Employee. \r\n4. Exit. \r\n- Enter Menu Option Number:");
                        Nochoice2:
                            int choice2 = int.Parse(ValidateMethod.CheckInput(@"^\d+$", "- Only numbers can be entered, please re-enter: "));
                            switch (choice2)
                            {
                                case 1:
                                    SalariedEmployee employee = addNewSalariedEmployee();
                                  
                                    Console.WriteLine("Employee Created:");
                                    Console.WriteLine(employee.ToString);
                                    
                                    break;
                                case 2:


                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                default:
                                    Console.Write("- There are no options above, please re-enter: ");
                                    goto Nochoice2;
                            }
                        }
                        break;
                    case 2:
                        break;

                }

                //if (choice == 1)
                //{
                //    Console.Write("Commission Rate: "); double commissionRate = double.Parse(Console.ReadLine());
                //    Console.Write("Gross Sales: "); double grossSales = double.Parse(Console.ReadLine());
                //    Console.Write("Basic Salary: "); double basicSalary = double.Parse(Console.ReadLine());

                //    SalariedEmployee employee = new SalariedEmployee(ssn, firstName, lastName, birthDate, phone, email, commissionRate, grossSales, basicSalary);
                //    Console.WriteLine("Employee Created:");
                //    Console.WriteLine(employee);
                //}
                //else if (choice == 2)
                //{
                //    Console.Write("Wage: "); double wage = double.Parse(Console.ReadLine());
                //    Console.Write("Working Hours: "); double workingHours = double.Parse(Console.ReadLine());

                //    HourlyEmployee employee = new HourlyEmployee(ssn, firstName, lastName, birthDate, phone, email, wage, workingHours);
                //    Console.WriteLine("Employee Created:");
                //    Console.WriteLine(employee);
                //}
                //else
                //{
                //    Console.WriteLine("Invalid choice.");
                //}
            }
        }
        
        private static SalariedEmployee addNewSalariedEmployee()
        {
            Console.Write("SSN: "); string ssn = ValidateMethod.CheckInput(@"^\d+$", "- Only numbers can be entered, please re-enter: ");
            Console.Write("First Name: "); string firstName = ValidateMethod.CheckInput(@"^[a-zA-Z\s]+$", "- You can only enter letters and do not contain special characters. Please re-enter: ");
            Console.Write("Last Name: "); string lastName = ValidateMethod.CheckInput(@"^[a-zA-Z\s]+$", "- You can only enter letters and do not contain special characters. Please re-enter: ");
            Console.Write("Birth Date (dd/MM/yyyy): "); string birthDate = ValidateMethod.CheckInput(@"^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\d{4}$", "- Incorrect date of birth format, please re-enter: ");
            Console.Write("Phone: "); string phone = ValidateMethod.CheckInput(@"^(\+84|0)\d{9,10}$", "- Incorrect phone number format, please re-enter: ");
            Console.Write("Email: "); string email = ValidateMethod.CheckInput(@"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$", "- Incorrect Email format, please re-enter: ");
            Console.Write("Commission Rate: "); double commissionRate = double.Parse(ValidateMethod.CheckInput(@"^\d+$", "- Only numbers can be entered, please re-enter: "));
            Console.Write("Gross Sales: "); double grossSales = double.Parse(ValidateMethod.CheckInput(@"^\d+$", "- Only numbers can be entered, please re-enter: "));
            Console.Write("Basic Salary: "); double basicSalary = double.Parse(ValidateMethod.CheckInput(@"^\d+$", "- Only numbers can be entered, please re-enter: "));

            return new SalariedEmployee(ssn, firstName, lastName, birthDate, phone, email, commissionRate, grossSales, basicSalary);
        }
    }

}

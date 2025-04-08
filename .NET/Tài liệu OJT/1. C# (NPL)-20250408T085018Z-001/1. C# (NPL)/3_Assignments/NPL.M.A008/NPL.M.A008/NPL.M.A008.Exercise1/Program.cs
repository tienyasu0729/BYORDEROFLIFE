using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A008.Exercise1
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Starting application
            Console.WriteLine("Net.M.A008.Exercise1");

            //// This message to guide user
            Console.Write("Enter date value: ");

            //// Read value that use entered then convert it to number
            string date = Console.ReadLine();

            //// Call method to convert number to binary number
            bool isDate = CheckDateFormat(date);

            //// Update commment to explain this command
            Console.WriteLine(isDate ? "{0} is correct" : "{0} is incorrect", date);

            if (isDate)
            {
                var firstDayOfMonth = GetFirstDayOfMonth(date);
                Console.WriteLine("First day of month is: {0}", firstDayOfMonth.ToString());
            }

            //// Pause console window to see result
            Console.ReadLine();
        }

        private static bool CheckDateFormat(string date)
        {
            //// Check input is correct date format dd/MM/yyyy or not
            return false;
        }

        private static DateTime GetFirstDayOfMonth(string date)
        {
            return new DateTime();
        }
    }
}

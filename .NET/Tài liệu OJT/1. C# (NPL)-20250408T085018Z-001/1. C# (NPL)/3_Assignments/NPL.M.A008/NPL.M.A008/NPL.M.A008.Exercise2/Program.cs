using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A008.Exercise2
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Starting application
            Console.WriteLine("Net.M.A008.Exercise2");

            //// This message to guide user
            Console.Write("Enter month value in format MMM/yyyy: ");

            //// Read value that use entered then convert it to number
            string month = Console.ReadLine();

            //// Call method to convert number to binary number
            int countWorkingDay = CountWorkingDay(month);

            //// Print result
            Console.WriteLine("{0} has {1} working day", month, countWorkingDay);

            //// Pause console window to see result
            Console.ReadLine();
        }

        private static int CountWorkingDay(string month)
        {
            //// Write code to count number of working day in a month. 
            return 0;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A005.Exercise1
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Starting application
            Console.WriteLine("Net.M.A005.Exercise1");

            //// This message to guide user to enter a number
            Console.Write("Enter integer number: ");

            //// Read value that use entered then convert it to number
            int input = Convert.ToInt32(Console.ReadLine());

            //// Call method to convert number to binary number
            string output = ConvertToBinary(input);

            //// Print the result
            Console.Write("The binary is: ");
            Console.WriteLine(output);

            //// Pause console window to see result
            Console.ReadLine();
        }

        /// <summary>
        /// Update you comment
        /// </summary>
        /// <param name="input"></param>
        /// <returns></returns>
        private static string ConvertToBinary(int input)
        {
            //// Your code here
            return string.Empty;
        }
    }
}

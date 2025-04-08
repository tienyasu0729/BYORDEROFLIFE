using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A004.Excercise1
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Starting application
            Console.WriteLine("Net.M.A004.Excercise1");

            //// This message to guide user to enter a number
            Console.Write("Enter x =  ");

            //// Read value that use entered then convert it to number
            decimal xDecimal = Convert.ToDecimal(Console.ReadLine());

            //// Call method to convert number to binary number
            decimal output = EvaluatePolynomial(xDecimal);

            //// Print the result
            Console.Write("Result y = {0}", output);

            //// Pause console window to see result
            Console.ReadLine();
        }

        private static decimal EvaluatePolynomial(decimal xDecimal)
        {
            //// Your code here
            return 0;
        }
    }
}

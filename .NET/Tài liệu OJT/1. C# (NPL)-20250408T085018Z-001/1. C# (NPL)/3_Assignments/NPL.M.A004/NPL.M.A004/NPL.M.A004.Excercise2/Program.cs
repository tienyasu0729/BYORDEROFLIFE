using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A004.Excercise2
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Starting application
            Console.WriteLine("Net.M.A004.Excercise2");

            //// Initial Polynomial
            var polynomial = InitialPolynomial();

            //// This message to guide user to enter a number
            Console.Write("Enter x =  ");

            //// Read value that use entered then convert it to number
            decimal xDecimal = Convert.ToDecimal(Console.ReadLine());

            //// Update your comment
            decimal output = EvaluatePolynomial(polynomial, xDecimal);

            //// Print the result
            Console.Write("Result y = {0}", output);

            //// Pause console window to see result
            Console.ReadLine();
        }

        private static decimal[] InitialPolynomial()
        {
            //// Your code here
            return new decimal[0];
        }
        private static decimal EvaluatePolynomial(decimal[] polynomial, decimal xDecimal)
        {
            //// Your code here
            return 0;
        }
    }
}

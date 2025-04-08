using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A006.Exercise2
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Starting application
            Console.WriteLine("Net.M.A006.Exercise2");

            Console.Write("Enter the first number: ");
            int firstNumber = Convert.ToInt32(Console.ReadLine());

            Console.Write("Enter the second number: ");
            int secondNumber = Convert.ToInt32(Console.ReadLine());

            //// Call method to convert number to binary number
            int greatestCommonDivisor = GetGreatestCommonDivisor(firstNumber, secondNumber);

            //// Print the result
            Console.Write("The greatest common divisor of {0} and {1} is {2}", firstNumber, secondNumber, greatestCommonDivisor);
            Console.WriteLine(greatestCommonDivisor);

            //// Pause console window to see result
            Console.ReadLine();
        }

        private static int GetGreatestCommonDivisor(int firstNumber, int secondNumber)
        {
            //// Your code here
            return 0;
        }
    }
}

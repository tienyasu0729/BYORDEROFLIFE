using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Operators
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Operators - Get sum of 2 numbers");

            Console.Write("Input 1st number: ");
            string inputed = Console.ReadLine();
            //// Convert the inputted value to number - integer
            int number1 = Convert.ToInt32(inputed);

            Console.Write("Input 2nd number: ");
            inputed = Console.ReadLine();
            //// Convert the inputted value to number - integer
            int number2 = Convert.ToInt32(inputed);

            //// Call Modulo functon to get modulo of 2 nhumbers
            int modulo = Modulo(number1, number2);

            //// Call Sum function to get sum of 2 numbers
            int sum = Sum(number1, number2);

            //// Call Compare function to compare 2 numbers
            bool compare = Compare(number1, number2);

            //// Call BitwiseXor function to get XOR of 2 numbers
            int xor = BitwiseXor(number1, number2);

            //// Build a result message with format of mathematic
            string result1 = string.Format("{0} + {1} = {2}", number1, number2, sum);
            string result2 = string.Format("{0} % {1} = {2}", number1, number2, modulo);
            string result3 = string.Format("{0} == {1} = {2}", number1, number2, compare);
            string result4 = string.Format("{0} ^ {1} = {2}", number1, number2, xor);
            Console.WriteLine(result1);
            Console.WriteLine(result2);
            Console.WriteLine(result3);
            Console.WriteLine(result4);

            //// Keep the console window open in debug mode.
            Console.WriteLine("Press any key to exit.");
            Console.ReadKey();

        }
        /// <summary>
        /// Sum the two numbers
        /// </summary>
        /// <param name="number1"></param>
        /// <param name="number2"></param>
        /// <returns></returns>
        static int Sum(int number1, int number2)
        {
            //// Get sum of 2 numbers
            int sum = number1 + number2;

            //// Return value
            return sum;
        }
        /// <summary>
        /// Modulo the two number
        /// </summary>
        /// <param name="number1"></param>
        /// <param name="number2"></param>
        /// <returns></returns>
        static int Modulo(int number1, int number2)
        {
            //// Get modulo of 2 numbers
            int modulo = number1 % number2;
            //// Return value
            return modulo;
        }

        /// <summary>
        /// Compare to 2 numbers
        /// </summary>
        /// <param name="number1"></param>
        /// <param name="number2"></param>
        /// <returns></returns>
        static bool Compare(int number1, int number2)
        {
            //// Get Compare by of 2 numbers
            bool result = number1 == number2;
            //// Return value
            return result;
        }
        /// <summary>
        /// Takes two numbers as operands and does XOR on every bit of two numbers
        /// </summary>
        /// <param name="number1"></param>
        /// <param name="number2"></param>
        /// <returns></returns>
        static int BitwiseXor(int number1, int number2)
        {
            //// Get XOR on every bit of two numbers.
            int result = number1 ^ number2;
            //// Return value
            return result;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A005.Excercise3
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Update your comment
            Console.WriteLine("Net.M.A005.Excercise3");
            Console.Write("Enter integer number: ");

            //// Update your comment
            int input = Convert.ToInt32(Console.ReadLine());

            //// Update your comment
            bool isPrimeNumber = CheckPrimeNumber(input);

            //// Update your comment
            if (isPrimeNumber)
            {
                //// Update your comment
                Console.WriteLine("{0} is prime number", input);
            }
            else
            {
                //// Update your comment
                Console.WriteLine("{0} is NOT prime number", input);
            }

            //// Update your comment
            Console.ReadLine();
        }

        //// Update your comment
        private static bool CheckPrimeNumber(int input)
        {
            //// Your code here
            return false;
        }
    }
}

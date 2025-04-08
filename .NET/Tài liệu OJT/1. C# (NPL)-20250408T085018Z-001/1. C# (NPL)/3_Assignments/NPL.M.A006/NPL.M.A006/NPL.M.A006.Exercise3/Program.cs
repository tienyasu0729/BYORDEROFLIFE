using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A006.Exercise3
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Starting application
            Console.WriteLine("Net.M.A006.Exercise3");

            int[] array = InitialArray();
            int greatestCommonDivisor = GetGreatestCommonDivisor(array);

            Console.WriteLine("The greatest common divisor of array is: {0}", greatestCommonDivisor);
            Console.ReadLine();
        }

        private static int[] InitialArray()
        {
            //// Write code to init an array by get values from user
            return new int[0];
        }

        private static int GetGreatestCommonDivisor(int[] array)
        {
            //// Your code here
            return 0;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A006.Exercise1
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Starting application
            Console.WriteLine("Net.M.A006.Exercise1");

            int[] array = InitialArray();
            int maximum = GetMaximum(array);
            int minmum = GetMinimum(array);

            Console.WriteLine("Maximum is: {0}", maximum);
            Console.WriteLine("Minimum is: {0}", minmum);
            Console.ReadLine();
        }

        private static int[] InitialArray()
        {
            //// Write code to init an array by get values from user
            return new int[0];
        }

        private static int GetMaximum(int[] array)
        {
            //// Write code to get maximum value of the array
            return 0;
        }

        private static int GetMinimum(int[] array)
        {
            //// Write code to get minimum value of the array
            return 0;
        }
    }
}

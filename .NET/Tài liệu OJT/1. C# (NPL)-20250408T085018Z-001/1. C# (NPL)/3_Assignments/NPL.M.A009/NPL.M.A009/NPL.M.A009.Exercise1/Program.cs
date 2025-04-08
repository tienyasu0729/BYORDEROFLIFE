using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A009.Exercise1
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Starting application
            Console.WriteLine("Net.M.A009.Exercise1");

            //// This message to guide user to enter name
            Console.Write("Enter name: ");
            string name = Console.ReadLine();

            string formattedName = FormatName(name);

            //// Print the result
            Console.WriteLine(formattedName);

            //// Pause console window to see result
            Console.ReadLine();
        }

        private static string FormatName(string name)
        {
            //// Your code to format name
            return "";
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A009.Exercise2
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Starting application
            Console.WriteLine("Net.M.A009.Exercise2");

            //// This message to guide user to enter name
            Console.Write("Enter email address: ");
            string email = Console.ReadLine();

            bool isValid = ValidateEmail(email);

            //// Print the result
            if (isValid)
            {
                Console.WriteLine("{0} is valid.", email);
            }
            else
            {
                Console.WriteLine("{0} is invalid.", email);
            }

            //// Pause console window to see result
            Console.ReadLine();
        }

        private static bool ValidateEmail(string email)
        {
            //// Validate email
            return false;
        }
    }
}

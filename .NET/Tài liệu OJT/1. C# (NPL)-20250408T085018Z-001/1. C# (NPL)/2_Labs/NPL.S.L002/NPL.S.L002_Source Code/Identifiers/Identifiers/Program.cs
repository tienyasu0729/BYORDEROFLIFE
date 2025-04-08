using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Identifiers
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Welcome message
            Console.WriteLine("Hello!");

            //// User guide message
            Console.Write("Enter your name: ");

            //// Read a name entered by user then store the name
            string name = Console.ReadLine();

            //// User guide message
            Console.Write("Enter your gender: ");

            //// Read a gender entered by user then store the value
            string gender = Console.ReadLine();

            if (gender == "Male")
            {
                //// Print message to say hello Mister
                string gettingMessage = string.Format("Hello {0} {1}!","Mr.", name);
                Console.WriteLine(gettingMessage);
            }
            else if(gender == "Female")
            {
                //// Print message to say hello Miss
                string gettingMessage = string.Format("Hello {0} {1}!","Ms.", name);
                Console.WriteLine(gettingMessage);
            }
            else
            {
                //// Print message to say hello 
                string gettingMessage = string.Format("Hello {0}!", name);
                Console.WriteLine(gettingMessage);
            }

            // Keep the console window open in debug mode.
            Console.WriteLine("Press any key to exit.");
            Console.ReadKey();

        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Strings
{
    class Program
    {
        static void Main(string[] args)
        {

            string name = "My name is Tony Stack!";
            Console.WriteLine(name);
            Console.WriteLine("Index of Tony is: {0}", name.IndexOf("Tony"));

            //// To include double-quote (") in string, use \"
            Console.WriteLine("Substring of \"{0}\" from 11 is: {1}", name, name.Substring(11));

            //// Divide the string by a space.
            string[] strArray = name.Split(' ');

            //// Show all element of strArray.
            for (int i = 0; i < strArray.Length; i++)
            {
                Console.WriteLine($"Value at Index position [{i}] is {strArray[i]}");
            }

            //// Using double slash "\\"
            string stream1 = "X:\\SourceCode\\Strings\\program.cs";
            Console.WriteLine(stream1);

            //// Using "@".
            string stream2 = @"X:\SourceCode\Strings\program.cs";
            Console.WriteLine(stream2);

            //// Using concatenation operator 
            Console.WriteLine("Full name is: {0}", strArray[3] + " " + strArray[4]);

            //// Using string.Format.
            DateTime dateAndTime = new DateTime(2019, 8, 26, 12, 32, 0);
            double temperature = 28.6;
            string result = String.Format("At {0:t} on {0:D}, the temperature was {1:F1} degrees C.",
                                          dateAndTime, temperature);
            Console.WriteLine(result);

            //// Keep the console window open in debug mode.
            Console.WriteLine();
            Console.WriteLine("Press any key to exit.");
            Console.ReadKey();

        }
    }
}

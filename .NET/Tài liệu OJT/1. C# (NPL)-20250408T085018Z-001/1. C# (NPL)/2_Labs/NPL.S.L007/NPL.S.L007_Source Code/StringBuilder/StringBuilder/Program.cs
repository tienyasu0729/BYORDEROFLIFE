using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringBuilder
{
    class Program
    {
        static void Main(string[] args)
        {
            System.Text.StringBuilder sb = new System.Text.StringBuilder();

            string[] spellings = { "Recieve", "Receeve", "Receive", "Reiceever" };
            sb.AppendLine("Which of the following spellings is true?");

            for (int ctr = 0; ctr <= spellings.GetUpperBound(0); ctr++)
            {
                sb.AppendFormat("   {0}. {1}", ctr + 1, spellings[ctr]);
                sb.AppendLine();
            }
            sb.AppendLine();
            Console.WriteLine(sb.ToString());

            //// Keep the console window open in debug mode.
            Console.WriteLine();
            Console.WriteLine("Press any key to exit.");
            Console.ReadKey();

        }
    }
}

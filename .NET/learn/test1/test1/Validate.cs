    using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace test1
{
    class Validate
    {
        public static string CheckInput (string stringRegex, string againText)
        {
            string input = Console.ReadLine(); 
            while ( 1 == 1)
            {
                if (Regex.IsMatch(input, stringRegex))
                {
                    return input;
                }
                else
                {
                    Console.WriteLine(againText);
                    input = Console.ReadLine();
                }
            }
        }
    }
}

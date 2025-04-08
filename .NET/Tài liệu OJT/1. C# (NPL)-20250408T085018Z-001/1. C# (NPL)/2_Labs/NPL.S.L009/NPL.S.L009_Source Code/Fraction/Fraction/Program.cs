using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fraction
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Init fraction: 1/2");
            Fraction fraction = new Fraction(1, 2);

            Console.WriteLine("Add new value 1/3");
            Console.Write("The fraction value is: ");
            fraction.Add(new Fraction(1, 3));
            fraction.Print();

            Console.WriteLine("Subtract value 1/4");
            Console.Write("The fraction value is: ");
            fraction.Subtract(new Fraction(1, 4));
            fraction.Print();

            Console.ReadKey();
        }
    }
}

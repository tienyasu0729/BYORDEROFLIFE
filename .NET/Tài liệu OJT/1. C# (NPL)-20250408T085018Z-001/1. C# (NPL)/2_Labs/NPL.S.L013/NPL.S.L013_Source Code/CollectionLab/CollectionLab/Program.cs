using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CollectionLab
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Declare new list of string
            List<string> listProduct = new List<string>();

            //// Add values into the list
            listProduct.Add("Dell Latitude E6440");
            listProduct.Add("HP Elitebook");
            listProduct.Add("Asus X541UA-XX272T");
            listProduct.Add("Lenovo Thinkpad X220");
            listProduct.Add("Apple Macbook");

            //// Gets the number of elements actually contained in the list
            Console.WriteLine("List have {0} product(s)", listProduct.Count);
            //// Print current list
            PrintList(listProduct);

            //// Get value by index. 
            //// Remember that, start posision is rezo (0):
            //// First element at position 0
            //// Second element at position 1, ....
            Console.Write("The third product in the list is: ");
            Console.WriteLine(listProduct[2]);

            //// Remove an element from the list by passing value
            Console.WriteLine("Remove one product Asus X541UA-XX272T from list");
            listProduct.Remove("Asus X541UA-XX272T");
            PrintList(listProduct);

            //// Remove an element from the list by passing possition
            Console.WriteLine("Remove product at position 3");
            listProduct.RemoveAt(2);
            PrintList(listProduct);

            //// Sort the list is very simple
            Console.WriteLine("Sort the list");
            listProduct.Sort();
            PrintList(listProduct);

            Console.ReadKey();
        }

        static void PrintList(List<string> listProduct)
        {
            //// Change color text to Magenta
            Console.ForegroundColor = ConsoleColor.Magenta;
            Console.Write("List product is: ");
            //// Print all products in the list
            foreach (string product in listProduct)
            {
                Console.Write("{0}, ", product);
            }
            Console.WriteLine();

            //// Reset color text to default (black)
            Console.ResetColor();
        }
    }
}

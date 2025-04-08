using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Net.M.A009.Exercise3
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Starting application
            Console.WriteLine("Net.M.A009.Exercise3");

            //// This message to guide user to enter name
            Console.Write("Enter list users: ");
            string listUsers = Console.ReadLine();

            listUsers = SortByName(listUsers);

            Console.WriteLine(listUsers);

            //// Pause console window to see result
            Console.ReadLine();
        }

        private static string SortByName(string listUser)
        {
            //// Sort users
            return listUser;
        }
    }
}

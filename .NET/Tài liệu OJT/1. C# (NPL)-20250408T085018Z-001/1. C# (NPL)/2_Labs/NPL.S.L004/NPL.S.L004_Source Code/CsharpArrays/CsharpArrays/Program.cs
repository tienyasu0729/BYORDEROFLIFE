using System;

namespace CsharpArrays
{
    class Program
    {
        static void Main(string[] args)
        {
            /// Defind array fibonacci and assigning values at the same time.
            int[] fibonacci = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };

            /// Defining array even with size 5. But not assigns values.
            int[] even = new int[5];

            /// Assign the value 10 in even array on its index 0
            even[0] = 10;

            /// Assign the value 20 in even array on its index 1
            even[1] = 20;

            /// Assign the value 30 in even array on its index 2
            even[2] = 30;

            /// Assign the value 40 in even array on its index 3
            even[3] = 40;

            /// Assign the value 60 in even array on its index 4
            even[4] = 60;


            /// Declares an 1D Array of string. 
            string[] weekDays;

            /// Allocating memory for days. 
            weekDays = new string[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

            Console.WriteLine("The first 10 numbers of Fibonacci array!");

            /// Print array by using index
            for (int index = 0; index < fibonacci.Length; index++)
            {
                Console.WriteLine(string.Format("array[{0}] = {1}", index, fibonacci[index]));
            }

            /// Search the first 2 digits number in array
            foreach (int number in fibonacci)
            {
                if (number >= 10)
                {
                    Console.WriteLine("The first 2 digits number in array is: {0}", number);
                    break;
                }
            }

            Console.WriteLine("All numbers of weekDays array!");

            /// Displaying all Elements of weekDays array.
            foreach (string day in weekDays)
            {
                Console.Write(day + " ");
            }

            /// Find the last number divided by 3 equal 0 of even array.
            /// Count length of even array.
            
            int length = even.Length;
            for (int i = length - 1; i >= 0; i--)
            {
                if (even[i] % 3 == 0)
                {
                    Console.WriteLine($"\nThe last number divided by 3 equal 0 of even array is: {even[i]}");
                    break;
                }
            }

            Console.WriteLine("All numbers of even array!");
            /// Using do-while loop to displays all element of even array.
            int j = 0;
            do
            {
                Console.Write(even[j]+ " ");
                j++;
            } while (j < even.Length);

            /// Keep the console window open in debug mode.
            Console.WriteLine("\nPress any key to exit.");
            Console.ReadKey();

        }

    }
}

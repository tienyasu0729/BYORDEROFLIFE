using System;

namespace test_delegate
{
    internal class Program
    {
        public delegate void MyDelegate(string message);

        public static void DisplayMessage(string message)
        {
            Console.WriteLine("Message: " + message);
        }

        public static void DisplayUpperCaseMessage(string message)
        {
            Console.WriteLine("Uppercase Message: " + message.ToUpper());
        }

        public static void Main()
        {
            MyDelegate del = new MyDelegate(DisplayMessage);
            del += DisplayUpperCaseMessage; // Thêm phương thức thứ hai vào delegate

            // Gọi tất cả các phương thức được tham chiếu bởi delegate
            del("Hello, World!");
            // Output:
            // Message: Hello, World!
            // Uppercase Message: HELLO, WORLD!
        }
    }
}

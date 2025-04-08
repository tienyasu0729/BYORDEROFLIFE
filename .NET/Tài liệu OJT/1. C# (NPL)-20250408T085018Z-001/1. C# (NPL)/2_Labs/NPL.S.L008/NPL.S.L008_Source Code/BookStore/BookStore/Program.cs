using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookStore
{
    class Program
    {
        static void Main(string[] args)
        {
            //// Init book1 by use default contructor and assign value for each property
            Book book1 = new Book();
            book1.Name = "In Search of Lost Time";
            book1.ISBN = "9971-5-0210-0";
            book1.AuthorName = "Marcel Proust";
            book1.Publisher = "World Scientific";
            book1.PublishedDate = new DateTime(2018, 12, 07);
            book1.Price = 54m;

            //// Init book2 by use contructor and pass value
            Book book2 = new Book(
                "Don Quixote", 
                "9971-5-0210-0", 
                "Miguel de Cervantes", 
                "World Scientific", 
                new DateTime(2018, 04, 12), 
                30m);

            //// Init book3 by use object initial
            
            Book book3 = new Book()
            {
                Name = "Hamlet",
                ISBN = "9971-5-0210-0",
                AuthorName = "William Shakespeare",
                Publisher = "World Scientific",
                PublishedDate = new DateTime(2018, 12, 07),
                Price = 98m
            };

            Console.WriteLine("===== Book store management! =====");
            Console.WriteLine("==================================");
            Console.WriteLine(book1.GetBookInformation());
            Console.WriteLine(book2.GetBookInformation());
            Console.WriteLine(book3.GetBookInformation());
            Console.ReadKey();
        }
    }
}

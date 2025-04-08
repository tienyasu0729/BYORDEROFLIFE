using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookStore
{
    public class Book
    {
        /// <summary>
        /// This is default contructor 
        /// </summary>
        public Book()
        {
        }

        /// <summary>
        /// The Book's contructor to initial object with assigned values
        /// In this contructor, we use this keywork to point to the current object
        /// </summary>
        public Book(string name, string isbn, string authorName, string publisher, DateTime publishedDate, decimal price)
        {
            this.Name = name;
            this.ISBN = isbn;
            this.AuthorName = authorName;
            this.Publisher = publisher;
            this.PublishedDate = publishedDate;
            this.Price = price;
        }

        public string Name { get; set; }
        public string ISBN { get; set; }
        public string AuthorName { get; set; }
        public string Publisher { get; set; }
        public DateTime PublishedDate { get; set; }
        public decimal Price { get; set; }

        public string GetBookInformation()
        {
            //// Use StringBuilder to build book's information
            StringBuilder bookInformatinBuilder = new StringBuilder();

            //// Append each information with name and value. Each property is in one line
            bookInformatinBuilder.AppendFormat("Name: {0}", this.Name);
            bookInformatinBuilder.AppendLine();
            bookInformatinBuilder.AppendFormat("ISBN: {0}", this.ISBN);
            bookInformatinBuilder.AppendLine();
            bookInformatinBuilder.AppendFormat("AuthorName: {0}", this.AuthorName);
            bookInformatinBuilder.AppendLine();
            bookInformatinBuilder.AppendFormat("Publisher: {0}", this.Publisher);
            bookInformatinBuilder.AppendLine();
            bookInformatinBuilder.AppendFormat("PublishedDate: {0}", this.PublishedDate.ToShortDateString());
            bookInformatinBuilder.AppendLine();
            bookInformatinBuilder.AppendFormat("Price: {0}", this.Price.ToString("C"));
            bookInformatinBuilder.AppendLine();


            //// Return book's information
            return bookInformatinBuilder.ToString();
        }
    }


}

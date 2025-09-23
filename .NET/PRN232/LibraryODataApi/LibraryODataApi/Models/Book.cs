using System;
using System.Collections.Generic;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace LibraryODataApi.Models
{
    public class Book
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string ISBN { get; set; }
        public decimal Price { get; set; }
        public int Pages { get; set; }
        public DateTime PublishedDate { get; set; }
        public bool IsAvailable { get; set; }
        public double Rating { get; set; }

        public int AuthorId { get; set; }
        public int CategoryId { get; set; }

        public Author Author { get; set; }
        public Category Category { get; set; }
        public ICollection<BookLoan> BookLoans { get; set; } = new List<BookLoan>();
    }
}
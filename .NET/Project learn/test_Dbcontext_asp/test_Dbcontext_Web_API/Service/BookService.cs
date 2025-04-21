using System;
using test_Dbcontext_asp.Data;
using test_Dbcontext_asp.Models;
using test_Dbcontext_Web_API.Models;

namespace test_Dbcontext_Web_API.Service
{
    public class BookService
    {
        private readonly AppDbContext _context;
        public BookService(AppDbContext context)
        {
            _context = context;
        }
        public void AddBook(BookVm book)
        {
            _context.Books.Add(new Book()
            {
                Title = book.Title,
                Description = book.Description,
                Rate = book.Rate,
                Genre = book.Genre,
                Author = book.Author,
            });
            _context.SaveChanges();
        }
    }
}

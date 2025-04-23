using test_2_ASP_Dbcontext.Models;
using test_2_ASP_Dbcontext_Web_API.Data;
using test_2_ASP_Dbcontext_Web_API.Models;

namespace test_2_ASP_Dbcontext_Web_API.Service
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

        public List<Book> GetBook()
        {
            return _context.Books.ToList();
        }
    }
}

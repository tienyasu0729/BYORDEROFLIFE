using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using test_Dbcontext_Web_API.Models;
using test_Dbcontext_Web_API.Service;

namespace test_Dbcontext_Web_API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class BooksController : ControllerBase
    {
        private readonly BookService _bookService;
        public BooksController(BookService bookService)
        {
            _bookService = bookService;
        }
        [HttpPost("add-book")]
        public IActionResult AddBook([FromBody] BookVm book)
        {
            _bookService.AddBook(book);
            return Ok();
        }
    }
}

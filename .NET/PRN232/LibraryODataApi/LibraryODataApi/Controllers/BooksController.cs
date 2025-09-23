using LibraryODataApi.Data;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.OData.Query;
using Microsoft.AspNetCore.OData.Routing.Controllers;

namespace LibraryODataApi.Controllers
{
    public class BooksController : ODataController
    {
        private readonly ApplicationDbContext _db;

        public BooksController(ApplicationDbContext db)
        {
            _db = db;
        }

        [EnableQuery]
        public IActionResult Get()
        {
            return Ok(_db.Books);
        }

        [EnableQuery]
        public IActionResult Get(int key)
        {
            var book = _db.Books.FirstOrDefault(b => b.Id == key);
            if (book == null)
            {
                return NotFound();
            }
            return Ok(book);
        }
    }
}
using LibraryODataApi.Data;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.OData.Query;
using Microsoft.AspNetCore.OData.Routing.Controllers;

namespace LibraryODataApi.Controllers
{
    public class BookLoansController : ODataController
    {
        private readonly ApplicationDbContext _db;

        public BookLoansController(ApplicationDbContext db)
        {
            _db = db;
        }

        [EnableQuery]
        public IActionResult Get()
        {
            return Ok(_db.BookLoans);
        }
    }
}
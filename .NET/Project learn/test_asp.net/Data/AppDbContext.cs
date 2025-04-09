using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;
using test_asp.net.Models;

namespace test_asp.net.Data
{
    public class AppDbContext : DbContext
    {
        public DbSet<Book> Books { get; set; }
        public AppDbContext(DbContextOptions options) : base(options)
        {

        }
    }


}

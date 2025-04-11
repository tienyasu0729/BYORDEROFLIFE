using Microsoft.EntityFrameworkCore;
using test_asp.net.Models;

namespace test_asp.net.Context
{
    public class AppDbContext : DbContext
    {
        public DbSet<Book> Books { get; set; }
        public AppDbContext(DbContextOptions options) : base(options)
        {

        }

        public DbSet<Product> Products { get; set; }
    }
}


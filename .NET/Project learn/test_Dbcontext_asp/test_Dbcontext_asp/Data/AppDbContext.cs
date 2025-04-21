using Microsoft.EntityFrameworkCore;
using test_Dbcontext_asp.Models;

namespace test_Dbcontext_asp.Data
{
    public class AppDbContext : DbContext
    {
        public DbSet<Book> Books { get; set; }
        public AppDbContext(DbContextOptions options) : base(options)
        {
        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            // ✅ Bỏ qua cảnh báo PendingModelChangesWarning
            optionsBuilder.ConfigureWarnings(warnings =>
                warnings.Ignore(Microsoft.EntityFrameworkCore.Diagnostics.RelationalEventId.PendingModelChangesWarning));
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Book>().HasData(new Book()
            {
                Id = 1,
                Title = "1st book title",
                Description = "1st book description",
                Rate = 5,
                Genre = "Biography",
                Author = "First Author",
                DateAdded = DateTime.Now,
            });
            modelBuilder.Entity<Book>().HasData(new Book()
            {
                Id = 2,
                Title = "2nd book title",
                Description = "2nd book description",
                Rate = 4,
                Genre = "Biography",
                Author = "Second Author",
                DateAdded = DateTime.Now,
            });
        }
    }
}

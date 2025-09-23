using LibraryODataApi.Models;
using Microsoft.EntityFrameworkCore;

namespace LibraryODataApi.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options)
        {
        }

        public DbSet<Author> Authors { get; set; }
        public DbSet<Category> Categories { get; set; }
        public DbSet<Book> Books { get; set; }
        public DbSet<BookLoan> BookLoans { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<Author>().HasData(
                new Author { Id = 1, Name = "Nguyen Van A", Email = "nva@email.com", DateOfBirth = new DateTime(1980, 5, 15), Nationality = "Vietnam", IsActive = true },
                new Author { Id = 2, Name = "Tran Thi B", Email = "ttb@email.com", DateOfBirth = new DateTime(1975, 8, 20), Nationality = "Vietnam", IsActive = true },
                new Author { Id = 3, Name = "John Smith", Email = "js@email.com", DateOfBirth = new DateTime(1970, 3, 10), Nationality = "USA", IsActive = true }
            );

            modelBuilder.Entity<Category>().HasData(
                new Category { Id = 1, Name = "Technology", Description = "Technology books", DisplayOrder = 1, IsActive = true },
                new Category { Id = 2, Name = "Literature", Description = "Literature books", DisplayOrder = 2, IsActive = true },
                new Category { Id = 3, Name = "Science", Description = "Science books", DisplayOrder = 3, IsActive = true }
            );

            modelBuilder.Entity<Book>().HasData(
                new Book { Id = 1, Title = "ASP.NET Core Guide", ISBN = "978-1234567890", Price = 25.99m, Pages = 300, PublishedDate = new DateTime(2021, 1, 15), IsAvailable = true, Rating = 4.5, AuthorId = 1, CategoryId = 1 },
                new Book { Id = 2, Title = "Vietnam History", ISBN = "978-0987654321", Price = 18.50m, Pages = 250, PublishedDate = new DateTime(2020, 6, 10), IsAvailable = false, Rating = 4.2, AuthorId = 2, CategoryId = 2 }
            );

            modelBuilder.Entity<BookLoan>().HasData(
                new BookLoan { Id = 1, MemberName = "Le Van C", MemberEmail = "lvc@email.com", LoanDate = new DateTime(2024, 1, 10), DueDate = new DateTime(2024, 2, 10), IsReturned = false, Fine = 0, BookId = 1 },
                new BookLoan { Id = 2, MemberName = "Pham Thi D", MemberEmail = "ptd@email.com", LoanDate = new DateTime(2024, 1, 5), DueDate = new DateTime(2024, 2, 5), ReturnDate = new DateTime(2024, 1, 25), IsReturned = true, Fine = 0, BookId = 2 }
            );
        }
    }
}
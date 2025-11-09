using FPTShopLaptopAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace FPTShopLaptopAPI.Data
{
    public class AppDbContext : DbContext
    {
        public DbSet<User> Users { get; set; }
        public DbSet<Laptop> Laptops { get; set; }
        public DbSet<Order> Orders { get; set; }

        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<User>()
                .HasIndex(u => u.Email)
                .IsUnique();

            // Cấu hình quan hệ Order → User với DeleteBehavior.Restrict
            modelBuilder.Entity<Order>()
                .HasOne(o => o.User)
                .WithMany(u => u.Orders)
                .HasForeignKey(o => o.UserId)
                .OnDelete(DeleteBehavior.Restrict);

            // Cấu hình quan hệ Laptop → User với DeleteBehavior.Restrict
            modelBuilder.Entity<Laptop>()
                .HasOne(l => l.User)
                .WithMany() // Không cần navigation ngược
                .HasForeignKey(l => l.UserId)
                .OnDelete(DeleteBehavior.Restrict);
        }

    }
}

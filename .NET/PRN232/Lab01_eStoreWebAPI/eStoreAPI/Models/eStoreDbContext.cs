using eStoreAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace eStoreAPI.Data
{
    public class eStoreDbContext : DbContext
    {
        // Constructor này cần thiết để Dependency Injection hoạt động trong ASP.NET Core
        public eStoreDbContext(DbContextOptions<eStoreDbContext> options) : base(options)
        {
        }

        // Khai báo các bảng sẽ được tạo trong cơ sở dữ liệu
        public DbSet<Product> Products { get; set; }
        public DbSet<Category> Categories { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Cấu hình mối quan hệ (tùy chọn nhưng nên có để rõ ràng)
            modelBuilder.Entity<Product>()
                .HasOne(p => p.Category)         // Mỗi Product có một Category
                .WithMany(c => c.Products)      // Mỗi Category có nhiều Product
                .HasForeignKey(p => p.CategoryId); // Thông qua khóa ngoại CategoryId
        }
    }
}
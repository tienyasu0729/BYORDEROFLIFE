using DataAccess.Models;
using Microsoft.EntityFrameworkCore;
using DataAccess.Models;

namespace DataAccess
{
    public class FA25BearDBContext : DbContext
    {
        public FA25BearDBContext(DbContextOptions<FA25BearDBContext> options) : base(options)
        {
        }

        public virtual DbSet<BearAccount> BearAccounts { get; set; }
        public virtual DbSet<BearType> BearTypes { get; set; }
        public virtual DbSet<BearProfile> BearProfiles { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // Định nghĩa quan hệ 1-N giữa BearType và BearProfile
            modelBuilder.Entity<BearProfile>(entity =>
            {
                entity.HasOne(d => d.BearType)
                    .WithMany(p => p.BearProfiles)
                    .HasForeignKey(d => d.BearTypeId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK_BearProfile_BearType");
            });

            // Seed data (tạo dữ liệu mẫu) cho BearAccount để có thể login
            // Mật khẩu là "123" cho dễ kiểm tra
            modelBuilder.Entity<BearAccount>().HasData(
                new BearAccount
                {
                    AccountId = 1,
                    UserName = "manager@email.com", // Dùng email làm username
                    Password = "123",
                    FullName = "Manager Bear",
                    Email = "manager@email.com",
                    Phone = "0900000002",
                    RoleId = 2 // Manager
                },
                new BearAccount
                {
                    AccountId = 2,
                    UserName = "staff@email.com",
                    Password = "123",
                    FullName = "Staff Bear",
                    Email = "staff@email.com",
                    Phone = "0900000003",
                    RoleId = 3 // Staff
                },
                new BearAccount
                {
                    AccountId = 3,
                    UserName = "member@email.com",
                    Password = "123",
                    FullName = "Member Bear",
                    Email = "member@email.com",
                    Phone = "0900000004",
                    RoleId = 4 // Member
                },
                 new BearAccount
                 {
                     AccountId = 4,
                     UserName = "admin@email.com",
                     Password = "123",
                     FullName = "Admin Bear",
                     Email = "admin@email.com",
                     Phone = "0900000001",
                     RoleId = 1 // Admin
                 }
            );

            // Seed data cho BearType
            modelBuilder.Entity<BearType>().HasData(
                new BearType { BearTypeId = 1, BearTypeName = "Grizzly Bear", Origin = "North America" },
                new BearType { BearTypeId = 2, BearTypeName = "Polar Bear", Origin = "Arctic" },
                new BearType { BearTypeId = 3, BearTypeName = "Panda Bear", Origin = "China" }
            );
        }
    }
}
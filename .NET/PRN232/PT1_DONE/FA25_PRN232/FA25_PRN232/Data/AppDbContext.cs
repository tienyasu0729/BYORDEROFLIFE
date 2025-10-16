using FA25_PRN232.Models;
using Microsoft.EntityFrameworkCore;

namespace FA25_PRN232.Data
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }

        public DbSet<User> Users { get; set; }
        public DbSet<Course> Courses { get; set; }
        public DbSet<Category> Categories { get; set; }
        public DbSet<Enrollment> Enrollments { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            #region Configurations
            // Configure unique constraint for User's email
            modelBuilder.Entity<User>()
                .HasIndex(u => u.Email)
                .IsUnique();

            // Explicitly configure the decimal type for the Price property
            modelBuilder.Entity<Course>()
                .Property(c => c.Price)
                .HasColumnType("decimal(18, 2)");

            // Configure relationships to prevent cascade delete issues
            modelBuilder.Entity<Course>()
                .HasOne(c => c.User)
                .WithMany(u => u.Courses)
                .HasForeignKey(c => c.UserId)
                .OnDelete(DeleteBehavior.Restrict);

            modelBuilder.Entity<Enrollment>()
                .HasOne(e => e.User)
                .WithMany(u => u.Enrollments)
                .HasForeignKey(e => e.UserId)
                .OnDelete(DeleteBehavior.Restrict);
            #endregion

            #region Seed Data
            // Seed Users
            modelBuilder.Entity<User>().HasData(
                new User { UserId = 1, Email = "teacher@fpt.edu.vn", Password = "HashedPassword1" }, // Giảng viên
                new User { UserId = 2, Email = "student1@fpt.edu.vn", Password = "HashedPassword2" }, // Sinh viên 1
                new User { UserId = 3, Email = "student2@fpt.edu.vn", Password = "HashedPassword3" }  // Sinh viên 2
            );

            // Seed Categories
            modelBuilder.Entity<Category>().HasData(
                new Category { CategoryId = 1, CategoryName = "Technology" },
                new Category { CategoryId = 2, CategoryName = "Business" },
                new Category { CategoryId = 3, CategoryName = "Personal Development" },
                new Category { CategoryId = 4, CategoryName = "Creative Arts" }
            );

            // Seed Courses - data is based on the provided screenshot and expanded
            modelBuilder.Entity<Course>().HasData(
                new Course
                {
                    CourseId = 1,
                    Title = "ASP.NET Core Basics",
                    Description = "Learn ASP.NET Core from scratch",
                    Price = 120.00m,
                    CreatedAt = new DateTime(2025, 9, 14, 0, 0, 0, DateTimeKind.Utc),
                    CategoryId = 1, // Technology
                    UserId = 1 // teacher@fpt.edu.vn
                },
                new Course
                {
                    CourseId = 2,
                    Title = "Blockchain Fundamentals",
                    Description = "Introduction to Blockchain technology",
                    Price = 250.50m,
                    CreatedAt = new DateTime(2025, 9, 19, 0, 0, 0, DateTimeKind.Utc),
                    CategoryId = 1, // Technology
                    UserId = 1
                },
                new Course
                {
                    CourseId = 3,
                    Title = "Advanced C# Programming",
                    Description = "Master C# with advanced topics",
                    Price = 180.00m,
                    CreatedAt = new DateTime(2025, 9, 24, 0, 0, 0, DateTimeKind.Utc),
                    CategoryId = 1, // Technology
                    UserId = 1
                },
                new Course
                {
                    CourseId = 4,
                    Title = "Microservices Architecture",
                    Description = "Learn how to design scalable microservices",
                    Price = 220.75m,
                    CreatedAt = new DateTime(2025, 9, 26, 0, 0, 0, DateTimeKind.Utc),
                    CategoryId = 2, // Business
                    UserId = 1
                },
                new Course
                {
                    CourseId = 5,
                    Title = "AI for Business",
                    Description = "Implement AI solutions in business scenarios",
                    Price = 300.00m,
                    CreatedAt = new DateTime(2025, 9, 29, 0, 0, 0, DateTimeKind.Utc),
                    CategoryId = 2, // Business
                    UserId = 1
                },
                new Course
                {
                    CourseId = 6,
                    Title = "Time Management Skills",
                    Description = "Enhance productivity with better time management",
                    Price = 90.00m,
                    CreatedAt = new DateTime(2025, 10, 2, 0, 0, 0, DateTimeKind.Utc),
                    CategoryId = 3, // Personal Development
                    UserId = 1
                },
                new Course
                {
                    CourseId = 7,
                    Title = "Public Speaking Mastery",
                    Description = "Improve your public speaking confidence",
                    Price = 110.00m,
                    CreatedAt = new DateTime(2025, 10, 4, 0, 0, 0, DateTimeKind.Utc),
                    CategoryId = 3, // Personal Development
                    UserId = 1
                },
                new Course
                {
                    CourseId = 8,
                    Title = "Introduction to Digital Painting",
                    Description = "Learn the basics of digital art and illustration.",
                    Price = 150.00m,
                    CreatedAt = new DateTime(2025, 10, 9, 0, 0, 0, DateTimeKind.Utc),
                    CategoryId = 4, // Creative Arts
                    UserId = 1
                }
            );

            // Seed Enrollments
            modelBuilder.Entity<Enrollment>().HasData(
                // Student 1 (UserId = 2) enrolls in 3 courses
                new Enrollment { EnrollmentId = 1, UserId = 2, CourseId = 1, EnrollmentDate = new DateTime(2025, 10, 4, 0, 0, 0, DateTimeKind.Utc) },
                new Enrollment { EnrollmentId = 2, UserId = 2, CourseId = 6, EnrollmentDate = new DateTime(2025, 10, 6, 0, 0, 0, DateTimeKind.Utc) },
                new Enrollment { EnrollmentId = 3, UserId = 2, CourseId = 8, EnrollmentDate = new DateTime(2025, 10, 12, 0, 0, 0, DateTimeKind.Utc) },

                // Student 2 (UserId = 3) enrolls in 2 courses
                new Enrollment { EnrollmentId = 4, UserId = 3, CourseId = 1, EnrollmentDate = new DateTime(2025, 10, 5, 0, 0, 0, DateTimeKind.Utc) },
                new Enrollment { EnrollmentId = 5, UserId = 3, CourseId = 4, EnrollmentDate = new DateTime(2025, 10, 9, 0, 0, 0, DateTimeKind.Utc) }
            );
            #endregion
        }
    }
}

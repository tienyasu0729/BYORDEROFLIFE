using Microsoft.EntityFrameworkCore;
using Prn232PracticeExam.Models; // Phải using Model

namespace Prn232PracticeExam.Data
{
    public class PracticeExamContext : DbContext
    {
        public PracticeExamContext(DbContextOptions<PracticeExamContext> options)
            : base(options)
        {
        }

        // Khai báo bảng
        public DbSet<LeopardProfile> LeopardProfiles { get; set; }

        // BẠN HÃY THÊM PHƯƠNG THỨC NÀY VÀO
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Cấu hình "seeding data" cho bảng LeopardProfile
            modelBuilder.Entity<LeopardProfile>().HasData(
                // Data 1 (Dựa trên mô tả của đề)
                new LeopardProfile
                {
                    Id = 1, // Bắt buộc phải có Id
                    LeopardName = "Panthera Pardus",
                    DateOfBirth = new DateTime(2018, 5, 15),
                    Weight = 75.5,
                    Description = "A large male leopard known for its stealth. Tawny and rusty yellow coat.",
                    LastSeen = new DateTime(2025, 10, 30, 10, 0, 0),
                    LastSeenLocation = "Serengeti, Sector 5",
                    ModifiedDate = new DateTime(2025, 11, 1, 12, 0, 0)
                },
                // Data 2 (Dựa trên JSON mẫu của đề)
                new LeopardProfile
                {
                    Id = 2,
                    LeopardName = "Leopardo",
                    DateOfBirth = new DateTime(2019, 1, 20),
                    Weight = 68.0,
                    Description = "Young male, very agile.",
                    LastSeen = new DateTime(2025, 11, 5, 8, 30, 0),
                    LastSeenLocation = "Waterhole B",
                    ModifiedDate = null // Cho phép null
                },
                // Data 3 (Dựa trên JSON mẫu của đề)
                new LeopardProfile
                {
                    Id = 3,
                    LeopardName = "Chestar",
                    DateOfBirth = new DateTime(2020, 3, 10),
                    Weight = 55.2,
                    Description = "Female, distinctive spot pattern on right flank.",
                    LastSeen = new DateTime(2025, 11, 8, 14, 15, 0),
                    LastSeenLocation = "Ridge Top",
                    ModifiedDate = new DateTime(2025, 11, 8, 16, 0, 0)
                },
                // Data 4
                new LeopardProfile
                {
                    Id = 4,
                    LeopardName = "Shiva",
                    DateOfBirth = new DateTime(2017, 7, 22),
                    Weight = 62.1,
                    Description = "Older female, known as a successful hunter.",
                    LastSeen = new DateTime(2025, 11, 2, 18, 5, 0),
                    LastSeenLocation = "Riverbend",
                    ModifiedDate = null
                },
                // Data 5
                new LeopardProfile
                {
                    Id = 5,
                    LeopardName = "Bagheera",
                    DateOfBirth = new DateTime(2021, 2, 5),
                    Weight = 70.3,
                    Description = "Large male, melanistic (black panther). Very rare.",
                    LastSeen = new DateTime(2025, 11, 9, 1, 0, 0),
                    LastSeenLocation = "Deep Jungle",
                    ModifiedDate = null
                },
                // Data 6
                new LeopardProfile
                {
                    Id = 6,
                    LeopardName = "Nala",
                    DateOfBirth = new DateTime(2019, 11, 30),
                    Weight = 58.0,
                    Description = "Female, mother of two cubs.",
                    LastSeen = new DateTime(2025, 11, 7, 11, 20, 0),
                    LastSeenLocation = "Savannah Plains",
                    ModifiedDate = new DateTime(2025, 11, 7, 11, 30, 0)
                },
                // Data 7 (Tên 2 từ để test regex)
                new LeopardProfile
                {
                    Id = 7,
                    LeopardName = "Amur Leopard",
                    DateOfBirth = new DateTime(2016, 4, 12),
                    Weight = 45.0,
                    Description = "Critically endangered subspecies. Thick fur.",
                    LastSeen = new DateTime(2025, 10, 15, 6, 0, 0),
                    LastSeenLocation = "Amur Region, Russia",
                    ModifiedDate = null
                },
                // Data 8
                new LeopardProfile
                {
                    Id = 8,
                    LeopardName = "Javan Leopard",
                    DateOfBirth = new DateTime(2020, 8, 1),
                    Weight = 51.5,
                    Description = "Endemic to Java island.",
                    LastSeen = new DateTime(2025, 11, 4, 15, 45, 0),
                    LastSeenLocation = "Ujung Kulon National Park",
                    ModifiedDate = null
                },
                // Data 9
                new LeopardProfile
                {
                    Id = 9,
                    LeopardName = "Indochinese Leopard",
                    DateOfBirth = new DateTime(2018, 9, 9),
                    Weight = 63.8,
                    Description = "Native to mainland Southeast Asia.",
                    LastSeen = new DateTime(2025, 11, 1, 12, 10, 0),
                    LastSeenLocation = "Cambodia Forests",
                    ModifiedDate = new DateTime(2025, 11, 1, 13, 0, 0)
                },
                // Data 10
                new LeopardProfile
                {
                    Id = 10,
                    LeopardName = "Sri Lankan Leopard",
                    DateOfBirth = new DateTime(2017, 12, 25),
                    Weight = 80.1, // Nặng để test filter
                    Description = "A large male, apex predator in Yala.",
                    LastSeen = new DateTime(2025, 11, 6, 17, 30, 0),
                    LastSeenLocation = "Yala National Park",
                    ModifiedDate = null
                },
                // Data 11
                new LeopardProfile
                {
                    Id = 11,
                    LeopardName = "Rajah",
                    DateOfBirth = new DateTime(2022, 1, 18),
                    Weight = 40.0, // Nhẹ để test filter
                    Description = "Juvenile male, very playful.",
                    LastSeen = new DateTime(2025, 11, 8, 9, 5, 0),
                    LastSeenLocation = "Near Base Camp",
                    ModifiedDate = null
                }
            );
        }
    }
}
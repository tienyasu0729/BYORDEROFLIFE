using Microsoft.EntityFrameworkCore;
using BusinessObjects;

namespace DataAccess;

public class ApplicationDbContext : DbContext
{
    public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options)
    {
    }

    public DbSet<User> Users { get; set; }
    public DbSet<Patient> Patients { get; set; }
    public DbSet<Appointment> Appointments { get; set; }
    public DbSet<DoctorLeaf> DoctorLeaves { get; set; }
    public DbSet<DoctorSpecialty> DoctorSpecialties { get; set; }
    public DbSet<ExamMethod> ExamMethods { get; set; }
    public DbSet<TimeSlot> TimeSlots { get; set; }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        base.OnModelCreating(modelBuilder);

        // --- Cấu hình mối quan hệ (Fluent API) ---
        #region Relationship Configuration
        modelBuilder.Entity<User>(entity =>
        {
            entity.HasMany(u => u.Appointments).WithOne(a => a.Doctor).HasForeignKey(a => a.DoctorId).OnDelete(DeleteBehavior.ClientSetNull);
            entity.HasMany(u => u.DoctorLeaves).WithOne(dl => dl.Doctor).HasForeignKey(dl => dl.DoctorId).OnDelete(DeleteBehavior.ClientSetNull);
            entity.HasMany(u => u.Patients).WithOne(p => p.RegisteredByNavigation).HasForeignKey(p => p.RegisteredBy).OnDelete(DeleteBehavior.ClientSetNull);
        });

        modelBuilder.Entity<Appointment>(entity =>
        {
            entity.HasKey(a => a.AppointmentId);
        });

        modelBuilder.Entity<Patient>(entity =>
        {
            entity.HasMany(p => p.Appointments).WithOne(a => a.Patient).HasForeignKey(a => a.PatientId).OnDelete(DeleteBehavior.Cascade);
        });

        modelBuilder.Entity<DoctorSpecialty>(entity =>
        {
            entity.HasMany(ds => ds.Users).WithMany(u => u.Specialties);
            entity.HasMany(ds => ds.ExamMethods).WithOne(em => em.Specialty).HasForeignKey(em => em.SpecialtyId).OnDelete(DeleteBehavior.SetNull);
        });

        modelBuilder.Entity<ExamMethod>(entity =>
        {
            entity.HasMany(em => em.Appointments).WithOne(a => a.Method).HasForeignKey(a => a.MethodId).OnDelete(DeleteBehavior.ClientSetNull);
        });

        modelBuilder.Entity<TimeSlot>(entity =>
        {
            entity.HasMany(ts => ts.Appointments).WithOne(a => a.Slot).HasForeignKey(a => a.SlotId).OnDelete(DeleteBehavior.ClientSetNull);
        });
        #endregion

        // --- Thêm dữ liệu cứng (Data Seeding) ---
        #region Data Seeding

        // Seed DoctorSpecialty
        modelBuilder.Entity<DoctorSpecialty>().HasData(
            new DoctorSpecialty { SpecialtyId = 1, Name = "Tim mạch" },
            new DoctorSpecialty { SpecialtyId = 2, Name = "Da liễu" },
            new DoctorSpecialty { SpecialtyId = 3, Name = "Nhi khoa" },
            new DoctorSpecialty { SpecialtyId = 4, Name = "Cơ xương khớp" }
        );

        // Seed ExamMethod
        modelBuilder.Entity<ExamMethod>().HasData(
            new ExamMethod { MethodId = 1, Name = "Điện tâm đồ (ECG)", SpecialtyId = 1 },
            new ExamMethod { MethodId = 2, Name = "Siêu âm tim", SpecialtyId = 1 },
            new ExamMethod { MethodId = 3, Name = "Soi da", SpecialtyId = 2 },
            new ExamMethod { MethodId = 4, Name = "Xét nghiệm máu tổng quát", SpecialtyId = 3 },
            new ExamMethod { MethodId = 5, Name = "Chụp X-quang khớp", SpecialtyId = 4 }
        );

        // Seed TimeSlot
        modelBuilder.Entity<TimeSlot>().HasData(
            new TimeSlot { SlotId = 1, StartTime = new TimeOnly(8, 0, 0), EndTime = new TimeOnly(8, 30, 0) },
            new TimeSlot { SlotId = 2, StartTime = new TimeOnly(8, 30, 0), EndTime = new TimeOnly(9, 0, 0) },
            new TimeSlot { SlotId = 3, StartTime = new TimeOnly(9, 0, 0), EndTime = new TimeOnly(9, 30, 0) },
            new TimeSlot { SlotId = 4, StartTime = new TimeOnly(9, 30, 0), EndTime = new TimeOnly(10, 0, 0) },
            new TimeSlot { SlotId = 5, StartTime = new TimeOnly(10, 0, 0), EndTime = new TimeOnly(10, 30, 0) },
            new TimeSlot { SlotId = 6, StartTime = new TimeOnly(10, 30, 0), EndTime = new TimeOnly(11, 0, 0) },
            new TimeSlot { SlotId = 7, StartTime = new TimeOnly(14, 0, 0), EndTime = new TimeOnly(14, 30, 0) },
            new TimeSlot { SlotId = 8, StartTime = new TimeOnly(14, 30, 0), EndTime = new TimeOnly(15, 0, 0) }
        );

        // Seed User (Admin, Staff, Doctors)
        // LƯU Ý: Trong thực tế bạn nên hash mật khẩu. Ở đây dùng text thường để minh họa.
        modelBuilder.Entity<User>().HasData(
            new User { UserId = 1, FullName = "Admin", PhoneNumber = "0987654321", Email = "admin@clinic.com", Password = "123", Gender = true, Birthday = new DateTime(1990, 1, 1), Role = "Admin", IsActive = true, CreatedAt = DateTime.Now },
            new User { UserId = 2, FullName = "Lê Thị Hoa (Nhân viên)", PhoneNumber = "0987111222", Email = "staff.hoa.lt@clinic.com", Password = "123", Gender = false, Birthday = new DateTime(1995, 2, 20), Role = "Staff", IsActive = true, CreatedAt = DateTime.Now },
            new User { UserId = 3, FullName = "Dr. Nguyễn Văn An", PhoneNumber = "0123456789", Email = "dr.an.nv@clinic.com", Password = "123", Gender = true, Birthday = new DateTime(1985, 5, 10), Role = "Doctor", IsActive = true, CreatedAt = DateTime.Now },
            new User { UserId = 4, FullName = "Dr. Trần Ngọc Mai", PhoneNumber = "0123987654", Email = "dr.mai.tn@clinic.com", Password = "123", Gender = false, Birthday = new DateTime(1988, 9, 15), Role = "Doctor", IsActive = true, CreatedAt = DateTime.Now },
            new User { UserId = 5, FullName = "Dr. Phạm Hùng", PhoneNumber = "0555123456", Email = "dr.hung.p@clinic.com", Password = "123", Gender = true, Birthday = new DateTime(1982, 11, 30), Role = "Doctor", IsActive = true, CreatedAt = DateTime.Now }
        );

        // Seed Patient
        modelBuilder.Entity<Patient>().HasData(
            new Patient { PatientId = 1, FullName = "Trần Thị Bích", Age = 25, Gender = false, Note = "Bệnh nhân cũ", RegisteredBy = 1 }, // Admin đăng ký
            new Patient { PatientId = 2, FullName = "Lý Minh Khang", Age = 45, Gender = true, Note = "Huyết áp cao", RegisteredBy = 2 }, // Staff Hoa đăng ký
            new Patient { PatientId = 3, FullName = "Đỗ Bảo Châu", Age = 8, Gender = false, Note = "Ho, sốt nhẹ", RegisteredBy = 2 }, // Staff Hoa đăng ký
            new Patient { PatientId = 4, FullName = "Vũ Anh Tuấn", Age = 33, Gender = true, Note = "Đau đầu gối", RegisteredBy = 1 } // Admin đăng ký
        );

        // Seed quan hệ nhiều-nhiều User <-> DoctorSpecialty
        modelBuilder.Entity<User>()
            .HasMany(u => u.Specialties)
            .WithMany(s => s.Users)
            .UsingEntity(j => j.ToTable("DoctorSpecialtyUser").HasData(
                new { UsersUserId = 3, SpecialtiesSpecialtyId = 1 }, // Dr. An - Tim mạch
                new { UsersUserId = 4, SpecialtiesSpecialtyId = 2 }, // Dr. Mai - Da liễu
                new { UsersUserId = 4, SpecialtiesSpecialtyId = 3 }, // Dr. Mai cũng làm Nhi khoa
                new { UsersUserId = 5, SpecialtiesSpecialtyId = 4 }  // Dr. Hùng - Cơ xương khớp
            ));

        // Seed DoctorLeave
        modelBuilder.Entity<DoctorLeaf>().HasData(
            new DoctorLeaf
            {
                LeaveId = 1,
                DoctorId = 5, // Dr. Hùng
                LeaveDate = DateOnly.FromDateTime(DateTime.Now.AddDays(10)), // Nghỉ vào 10 ngày tới
                Reason = "Tham dự hội thảo y khoa",
                IsActive = true,
                CreatedAt = DateTime.Now
            }
        );

        // Seed Appointment
        modelBuilder.Entity<Appointment>().HasData(
            new Appointment
            {
                AppointmentId = 1,
                PatientId = 2, // Bệnh nhân Lý Minh Khang
                DoctorId = 3, // Dr. An
                SpecialtyId = 1, // Khoa Tim mạch
                MethodId = 2, // Siêu âm tim
                AppointmentDate = DateOnly.FromDateTime(DateTime.Now.AddDays(3)), // 3 ngày tới
                SlotId = 3, // 9:00 - 9:30
                Status = "Scheduled",
                CreatedAt = DateTime.Now
            },
            new Appointment
            {
                AppointmentId = 2,
                PatientId = 3, // Bệnh nhân Đỗ Bảo Châu
                DoctorId = 4, // Dr. Mai
                SpecialtyId = 3, // Khoa Nhi
                MethodId = 4, // Xét nghiệm máu
                AppointmentDate = DateOnly.FromDateTime(DateTime.Now.AddDays(4)), // 4 ngày tới
                SlotId = 5, // 10:00 - 10:30
                Status = "Scheduled",
                CreatedAt = DateTime.Now
            }
        );

        #endregion
    }
}
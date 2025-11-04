using Microsoft.EntityFrameworkCore;
using PRN232_MEDICAL.Models;

namespace PRN232_MEDICAL.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options)
        {
        }

        public DbSet<User> Users { get; set; } // [cite: 17]
        public DbSet<Doctor> Doctors { get; set; } // [cite: 17]
        public DbSet<Appointment> Appointments { get; set; } // [cite: 17]

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<User>()
                .HasIndex(u => u.Email)
                .IsUnique();

            modelBuilder.Entity<Appointment>()
                .HasOne(a => a.Doctor)
                .WithMany(d => d.Appointments)
                .HasForeignKey(a => a.DoctorId)
                .OnDelete(DeleteBehavior.Cascade); // Hoặc NoAction tùy yêu cầu

            modelBuilder.Entity<Appointment>()
                .HasOne(a => a.User)
                .WithMany(u => u.Appointments)
                .HasForeignKey(a => a.UserId)
                .OnDelete(DeleteBehavior.Cascade); // Hoặc NoAction tùy yêu cầu
        }
    }
}

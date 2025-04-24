using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace test_DBFirst_ASP.Models;

public partial class TestDbfirstAspContext : DbContext
{
    public TestDbfirstAspContext()
    {
    }

    public TestDbfirstAspContext(DbContextOptions<TestDbfirstAspContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Car> Cars { get; set; }

    public virtual DbSet<Colord> Colords { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Data Source=DESKTOP-J1P01U8\\SQLEXPRESS;Database=test_DBFirst_ASP;TrustServerCertificate=true;Trusted_Connection=SSPI;Encrypt=false;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Car>(entity =>
        {
            entity.HasKey(e => e.IdCar).HasName("PK__car__D54686DC5864FF6E");

            entity.ToTable("car");

            entity.HasIndex(e => e.NameCar, "UQ__car__30D6AB00F8A18FAA").IsUnique();

            entity.Property(e => e.IdCar).HasColumnName("id_car");
            entity.Property(e => e.IdColor).HasColumnName("id_color");
            entity.Property(e => e.NameCar)
                .HasMaxLength(200)
                .HasColumnName("name_car");

            entity.HasOne(d => d.IdColorNavigation).WithMany(p => p.Cars)
                .HasForeignKey(d => d.IdColor)
                .HasConstraintName("FK__car__id_color__3B75D760");
        });

        modelBuilder.Entity<Colord>(entity =>
        {
            entity.HasKey(e => e.IdColor).HasName("PK__colord__7CF2AF0373B0D14A");

            entity.ToTable("colord");

            entity.HasIndex(e => e.Color, "UQ__colord__900DC6E9662FC63D").IsUnique();

            entity.Property(e => e.IdColor).HasColumnName("id_color");
            entity.Property(e => e.Color)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("color");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}

using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace GroupProjectBusiness.Models;

public partial class InnoCodeDbContext : DbContext
{
    public InnoCodeDbContext()
    {
    }

    public InnoCodeDbContext(DbContextOptions<InnoCodeDbContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Project> Projects { get; set; }

    public virtual DbSet<Score> Scores { get; set; }

    public virtual DbSet<Team> Teams { get; set; }

    public virtual DbSet<User> Users { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Server=DESKTOP-0M36I5V\\SQLEXPRESS;Database=InnoCodeCamp2025;User Id=tien;Password=123456;TrustServerCertificate=True;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Project>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PK__Projects__3214EC27823783D2");

            entity.Property(e => e.Id).HasColumnName("ID");
            entity.Property(e => e.Summary).HasMaxLength(200);
            entity.Property(e => e.TeamId).HasColumnName("TeamID");
            entity.Property(e => e.Title).HasMaxLength(100);

            entity.HasOne(d => d.Team).WithMany(p => p.Projects)
                .HasForeignKey(d => d.TeamId)
                .HasConstraintName("FK__Projects__TeamID__2C3393D0");
        });

        modelBuilder.Entity<Score>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PK__Scores__3214EC272776FEC0");

            entity.Property(e => e.Id).HasColumnName("ID");
            entity.Property(e => e.Comment).HasMaxLength(500);
            entity.Property(e => e.LecturerId).HasColumnName("LecturerID");
            entity.Property(e => e.ProjectId).HasColumnName("ProjectID");
            entity.Property(e => e.Score1).HasColumnName("Score");

            entity.HasOne(d => d.Lecturer).WithMany(p => p.Scores)
                .HasForeignKey(d => d.LecturerId)
                .HasConstraintName("FK__Scores__Lecturer__30F848ED");

            entity.HasOne(d => d.Project).WithMany(p => p.Scores)
                .HasForeignKey(d => d.ProjectId)
                .HasConstraintName("FK__Scores__ProjectI__300424B4");
        });

        modelBuilder.Entity<Team>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PK__Teams__3214EC274502738A");

            entity.Property(e => e.Id).HasColumnName("ID");
            entity.Property(e => e.Description).HasMaxLength(200);
            entity.Property(e => e.LeaderId).HasColumnName("LeaderID");
            entity.Property(e => e.TeamName).HasMaxLength(100);

            entity.HasOne(d => d.Leader).WithMany(p => p.Teams)
                .HasForeignKey(d => d.LeaderId)
                .HasConstraintName("FK__Teams__LeaderID__29572725");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PK__users__3214EC27C20B8040");

            entity.ToTable("users");

            entity.HasIndex(e => e.Email, "UQ__users__A9D105341800FF1E").IsUnique();

            entity.Property(e => e.Id).HasColumnName("ID");
            entity.Property(e => e.CreatedAt)
                .HasDefaultValueSql("(getdate())")
                .HasColumnType("datetime");
            entity.Property(e => e.Email).HasMaxLength(100);
            entity.Property(e => e.FullName).HasMaxLength(100);
            entity.Property(e => e.Passwork).HasMaxLength(100);
            entity.Property(e => e.Role).HasMaxLength(20);
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}

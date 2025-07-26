using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace GameProjectBusiness.Models;

public partial class Su25Prn222Context : DbContext
{
    public Su25Prn222Context()
    {
    }

    public Su25Prn222Context(DbContextOptions<Su25Prn222Context> options)
        : base(options)
    {
    }

    public virtual DbSet<Evaluation> Evaluations { get; set; }

    public virtual DbSet<GameProject> GameProjects { get; set; }

    public virtual DbSet<Team> Teams { get; set; }

    public virtual DbSet<User> Users { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Server=DESKTOP-0M36I5V\\SQLEXPRESS;Database=SU25_PRN222;User Id=tien;Password=123456;TrustServerCertificate=True;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Evaluation>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PK__Evaluati__3214EC278C9A5448");

            entity.Property(e => e.Id).HasColumnName("ID");
            entity.Property(e => e.Comment).HasMaxLength(500);
            entity.Property(e => e.GameProjectId).HasColumnName("GameProjectID");
            entity.Property(e => e.LecturerId).HasColumnName("LecturerID");

            entity.HasOne(d => d.GameProject).WithMany(p => p.Evaluations)
                .HasForeignKey(d => d.GameProjectId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Evaluatio__GameP__2E1BDC42");

            entity.HasOne(d => d.Lecturer).WithMany(p => p.Evaluations)
                .HasForeignKey(d => d.LecturerId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Evaluatio__Lectu__2F10007B");
        });

        modelBuilder.Entity<GameProject>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PK__GameProj__3214EC27FC1F910A");

            entity.HasIndex(e => e.Title, "UQ_GameTitle").IsUnique();

            entity.Property(e => e.Id).HasColumnName("ID");
            entity.Property(e => e.IsApproved).HasDefaultValue(false);
            entity.Property(e => e.Summary).HasMaxLength(200);
            entity.Property(e => e.TeamId).HasColumnName("TeamID");
            entity.Property(e => e.Title).HasMaxLength(100);

            entity.HasOne(d => d.Team).WithMany(p => p.GameProjects)
                .HasForeignKey(d => d.TeamId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__GameProje__TeamI__300424B4");
        });

        modelBuilder.Entity<Team>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PK__Teams__3214EC27BCEDC428");

            entity.Property(e => e.Id).HasColumnName("ID");
            entity.Property(e => e.Description).HasMaxLength(200);
            entity.Property(e => e.LeaderId).HasColumnName("LeaderID");
            entity.Property(e => e.TeamName).HasMaxLength(100);

            entity.HasOne(d => d.Leader).WithMany(p => p.Teams)
                .HasForeignKey(d => d.LeaderId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Teams__LeaderID__30F848ED");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PK__Users__3214EC275720F4BF");

            entity.HasIndex(e => e.Email, "UQ__Users__A9D105345FE8AE0F").IsUnique();

            entity.Property(e => e.Id).HasColumnName("ID");
            entity.Property(e => e.CreatedAt)
                .HasDefaultValueSql("(getdate())")
                .HasColumnType("datetime");
            entity.Property(e => e.Email)
                .HasMaxLength(100)
                .IsUnicode(false);
            entity.Property(e => e.FullName).HasMaxLength(100);
            entity.Property(e => e.Password).HasMaxLength(100);
            entity.Property(e => e.Role).HasMaxLength(20);
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}

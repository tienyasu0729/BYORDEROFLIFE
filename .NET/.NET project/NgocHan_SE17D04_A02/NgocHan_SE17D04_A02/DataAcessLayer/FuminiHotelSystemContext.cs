using System;
using System.Collections.Generic;
using BusinessObjects;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;

namespace DataAcessLayer;

public partial class FuminiHotelSystemContext : DbContext
{
    public FuminiHotelSystemContext()
    {
    }

    public FuminiHotelSystemContext(DbContextOptions<FuminiHotelSystemContext> options)
        : base(options)
    {
    }

    public virtual DbSet<BookingDetail> BookingDetails { get; set; }

    public virtual DbSet<BookingReservation> BookingReservations { get; set; }

    public virtual DbSet<Customer> Customers { get; set; }

    public virtual DbSet<RoomInfomation> RoomInfomations { get; set; }

    public virtual DbSet<RoomType> RoomTypes { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder) { 
        if (!optionsBuilder.IsConfigured)
        {
         #warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
            => optionsBuilder.UseSqlServer(GetConnectionString());
        }
    }


    string GetConnectionString()
    {
        IConfiguration config = new ConfigurationBuilder()
            .SetBasePath(Directory.GetCurrentDirectory())
            .AddJsonFile("appsettings.json").Build();
        return config["ConnectionStrings:DefaultConnection"];
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<BookingDetail>(entity =>
        {
            entity.HasKey(e => new { e.BookingReservationId, e.RoomId });

            entity.ToTable("BookingDetail");

            entity.HasIndex(e => e.BookingReservationId, "IX_BookingDetail").IsUnique();

            entity.Property(e => e.BookingReservationId).HasColumnName("BookingReservationID");
            entity.Property(e => e.RoomId).HasColumnName("RoomID");
            entity.Property(e => e.ActualPrice).HasColumnType("money");

            entity.HasOne(d => d.BookingReservation).WithOne(p => p.BookingDetail)
                .HasForeignKey<BookingDetail>(d => d.BookingReservationId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_BookingDetail_BookingReservation");

            entity.HasOne(d => d.Room).WithMany(p => p.BookingDetails)
                .HasForeignKey(d => d.RoomId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_BookingDetail_RoomInfomation");
        });

        modelBuilder.Entity<BookingReservation>(entity =>
        {
            entity.ToTable("BookingReservation");

            entity.Property(e => e.BookingReservationId).HasColumnName("BookingReservationID");
            entity.Property(e => e.CustomerId).HasColumnName("CustomerID");
            entity.Property(e => e.TotalPrice).HasColumnType("money");

            entity.HasOne(d => d.Customer).WithMany(p => p.BookingReservations)
                .HasForeignKey(d => d.CustomerId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_BookingReservation_Customer");
        });

        modelBuilder.Entity<Customer>(entity =>
        {
            entity.ToTable("Customer");

            entity.Property(e => e.CustomerId).HasColumnName("CustomerID");
            entity.Property(e => e.CustomerFullName).HasMaxLength(100);
            entity.Property(e => e.EmailAddress).HasMaxLength(50);
            entity.Property(e => e.Password).HasMaxLength(50);
            entity.Property(e => e.TelePhone).HasMaxLength(10);
        });

        modelBuilder.Entity<RoomInfomation>(entity =>
        {
            entity.HasKey(e => e.RoomId);

            entity.ToTable("RoomInfomation");

            entity.Property(e => e.RoomId).HasColumnName("RoomID");
            entity.Property(e => e.RoomDetailDescription).HasMaxLength(50);
            entity.Property(e => e.RoomMaxCapacity)
                .HasMaxLength(10)
                .IsFixedLength();
            entity.Property(e => e.RoomPricePerDay).HasColumnType("money");
            entity.Property(e => e.RoomTypeId).HasColumnName("RoomTypeID");

            entity.HasOne(d => d.RoomType).WithMany(p => p.RoomInfomations)
                .HasForeignKey(d => d.RoomTypeId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK_RoomInfomation_RoomType");
        });

        modelBuilder.Entity<RoomType>(entity =>
        {
            entity.ToTable("RoomType");

            entity.Property(e => e.RoomTypeId).HasColumnName("RoomTypeID");
            entity.Property(e => e.RoomTypeName).HasMaxLength(50);
            entity.Property(e => e.TypeDescription).HasMaxLength(100);
            entity.Property(e => e.TypeNote).HasMaxLength(50);
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}

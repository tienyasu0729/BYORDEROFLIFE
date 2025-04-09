using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace Chill_Computer.Models;

public partial class ChillComputerContext : DbContext
{
    public ChillComputerContext()
    {
    }

    public ChillComputerContext(DbContextOptions<ChillComputerContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Account> Accounts { get; set; }

    public virtual DbSet<Attribute> Attributes { get; set; }

    public virtual DbSet<Blog> Blogs { get; set; }

    public virtual DbSet<Brand> Brands { get; set; }

    public virtual DbSet<CartItem> CartItems { get; set; }

    public virtual DbSet<Discount> Discounts { get; set; }

    public virtual DbSet<FilterCategory> FilterCategories { get; set; }

    public virtual DbSet<Order> Orders { get; set; }

    public virtual DbSet<OrderItem> OrderItems { get; set; }

    public virtual DbSet<Payment> Payments { get; set; }

    public virtual DbSet<Pc> Pcs { get; set; }

    public virtual DbSet<PcComponent> PcComponents { get; set; }

    public virtual DbSet<Product> Products { get; set; }

    public virtual DbSet<ProductAttribute> ProductAttributes { get; set; }

    public virtual DbSet<ProductType> ProductTypes { get; set; }

    public virtual DbSet<ProductTypeFilter> ProductTypeFilters { get; set; }

    public virtual DbSet<Role> Roles { get; set; }

    public virtual DbSet<Series> Series { get; set; }

    public virtual DbSet<ShoppingCart> ShoppingCarts { get; set; }

    public virtual DbSet<User> Users { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Data Source=ACER;Database=Chill_Computer;User Id=sa;Password=123;TrustServerCertificate=true;Trusted_Connection=SSPI;Encrypt=false;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Account>(entity =>
        {
            entity.HasKey(e => e.UserName).HasName("PK__Account__C9F2845707F5348F");

            entity.ToTable("Account");

            entity.Property(e => e.UserName)
                .HasMaxLength(20)
                .IsUnicode(false);
            entity.Property(e => e.Password)
                .HasMaxLength(20)
                .IsUnicode(false)
                .HasColumnName("_Password");
            entity.Property(e => e.RoleId).HasColumnName("Role_Id");

            entity.HasOne(d => d.Role).WithMany(p => p.Accounts)
                .HasForeignKey(d => d.RoleId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Account__Role_Id__398D8EEE");
        });

        modelBuilder.Entity<Attribute>(entity =>
        {
            entity.HasKey(e => e.AttributeId).HasName("PK__Attribut__6DC45AB7A22A2648");

            entity.ToTable("Attribute");

            entity.Property(e => e.AttributeId).HasColumnName("Attribute_Id");
            entity.Property(e => e.AttributeName)
                .HasMaxLength(100)
                .HasColumnName("Attribute_Name");
            entity.Property(e => e.ParentId).HasColumnName("Parent_Id");
            entity.Property(e => e.TypeId).HasColumnName("Type_Id_");

            entity.HasOne(d => d.Parent).WithMany(p => p.InverseParent)
                .HasForeignKey(d => d.ParentId)
                .HasConstraintName("FK__Attribute__Paren__4E88ABD4");

            entity.HasOne(d => d.Type).WithMany(p => p.Attributes)
                .HasForeignKey(d => d.TypeId)
                .HasConstraintName("FK__Attribute__Type___4D94879B");
        });

        modelBuilder.Entity<Blog>(entity =>
        {
            entity.HasKey(e => e.BlogId).HasName("PK__Blog__C164D038927940FC");

            entity.ToTable("Blog");

            entity.Property(e => e.BlogId).HasColumnName("Blog_Id");
            entity.Property(e => e.BlogContent)
                .HasMaxLength(500)
                .HasColumnName("Blog_Content");
            entity.Property(e => e.DatePublish).HasColumnName("Date_Publish");
            entity.Property(e => e.Publisher).HasMaxLength(20);
        });

        modelBuilder.Entity<Brand>(entity =>
        {
            entity.HasKey(e => e.BrandId).HasName("PK__Brand__AAB3214F0881DFBC");

            entity.ToTable("Brand");

            entity.HasIndex(e => e.BrandName, "UQ__Brand__0C45B1A9327494B4").IsUnique();

            entity.Property(e => e.BrandId).HasColumnName("Brand_Id");
            entity.Property(e => e.BrandName)
                .HasMaxLength(50)
                .HasColumnName("Brand_Name");
        });

        modelBuilder.Entity<CartItem>(entity =>
        {
            entity.HasKey(e => e.CartItemId).HasName("PK__CartItem__3C0F265CC325F9E3");

            entity.ToTable("CartItem");

            entity.Property(e => e.CartItemId).HasColumnName("Cart_Item_Id");
            entity.Property(e => e.CartId).HasColumnName("Cart_Id");
            entity.Property(e => e.ItemQuantity).HasColumnName("Item_Quantity");
            entity.Property(e => e.PcId).HasColumnName("PC_Id");
            entity.Property(e => e.ProductId).HasColumnName("Product_Id");

            entity.HasOne(d => d.Cart).WithMany(p => p.CartItems)
                .HasForeignKey(d => d.CartId)
                .HasConstraintName("FK__CartItem__Cart_I__6383C8BA");

            entity.HasOne(d => d.Pc).WithMany(p => p.CartItems)
                .HasForeignKey(d => d.PcId)
                .HasConstraintName("FK__CartItem__PC_Id__6477ECF3");

            entity.HasOne(d => d.Product).WithMany(p => p.CartItems)
                .HasForeignKey(d => d.ProductId)
                .HasConstraintName("FK__CartItem__Produc__628FA481");
        });

        modelBuilder.Entity<Discount>(entity =>
        {
            entity.HasKey(e => e.DiscountId).HasName("PK__Discount__6C137204E92DCC1B");

            entity.ToTable("Discount");

            entity.HasIndex(e => e.DiscountCode, "UQ__Discount__799769065CE74E2C").IsUnique();

            entity.Property(e => e.DiscountId).HasColumnName("Discount_Id");
            entity.Property(e => e.DiscountAmount)
                .HasColumnType("money")
                .HasColumnName("Discount_Amount");
            entity.Property(e => e.DiscountCode)
                .HasMaxLength(20)
                .HasColumnName("Discount_Code");
            entity.Property(e => e.EndDate).HasColumnName("End_Date");
            entity.Property(e => e.IsActive)
                .HasDefaultValue(true)
                .HasColumnName("Is_Active");
            entity.Property(e => e.StartDate).HasColumnName("Start_Date");
        });

        modelBuilder.Entity<FilterCategory>(entity =>
        {
            entity.HasKey(e => e.CategoryId).HasName("PK__Filter_C__6DB38D6E3683BD95");

            entity.ToTable("Filter_Category");

            entity.Property(e => e.CategoryId).HasColumnName("Category_Id");
            entity.Property(e => e.CategoryName)
                .HasMaxLength(50)
                .HasColumnName("Category_Name");
            entity.Property(e => e.FilterId).HasColumnName("Filter_Id");
            entity.Property(e => e.ParentId).HasColumnName("Parent_Id");

            entity.HasOne(d => d.Filter).WithMany(p => p.FilterCategories)
                .HasForeignKey(d => d.FilterId)
                .HasConstraintName("FK__Filter_Ca__Filte__5812160E");

            entity.HasOne(d => d.Parent).WithMany(p => p.InverseParent)
                .HasForeignKey(d => d.ParentId)
                .HasConstraintName("FK__Filter_Ca__Paren__571DF1D5");
        });

        modelBuilder.Entity<Order>(entity =>
        {
            entity.HasKey(e => e.OrderId).HasName("PK__Order___F1E4607BF460CA3F");

            entity.ToTable("Order_");

            entity.Property(e => e.OrderId).HasColumnName("Order_Id");
            entity.Property(e => e.OrderDate).HasColumnName("Order_Date");
            entity.Property(e => e.OrderStatus)
                .HasMaxLength(50)
                .HasColumnName("Order_Status");
            entity.Property(e => e.TotalPrice)
                .HasColumnType("money")
                .HasColumnName("Total_Price");

            entity.HasOne(d => d.User).WithMany(p => p.Orders)
                .HasForeignKey(d => d.UserId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Order___UserId__6754599E");
        });

        modelBuilder.Entity<OrderItem>(entity =>
        {
            entity
                .HasNoKey()
                .ToTable("OrderItem");

            entity.Property(e => e.OrderId).HasColumnName("Order_Id");
            entity.Property(e => e.PcId).HasColumnName("PC_Id");
            entity.Property(e => e.ProductId).HasColumnName("Product_Id");

            entity.HasOne(d => d.Order).WithMany()
                .HasForeignKey(d => d.OrderId)
                .HasConstraintName("FK__OrderItem__Order__693CA210");

            entity.HasOne(d => d.Pc).WithMany()
                .HasForeignKey(d => d.PcId)
                .HasConstraintName("FK__OrderItem__PC_Id__6B24EA82");

            entity.HasOne(d => d.Product).WithMany()
                .HasForeignKey(d => d.ProductId)
                .HasConstraintName("FK__OrderItem__Produ__6A30C649");
        });

        modelBuilder.Entity<Payment>(entity =>
        {
            entity.HasKey(e => e.PaymentId).HasName("PK__Payment__DA6C7FC11A2F22E3");

            entity.ToTable("Payment");

            entity.Property(e => e.PaymentId).HasColumnName("Payment_Id");
            entity.Property(e => e.CartId).HasColumnName("Cart_Id");
            entity.Property(e => e.PaymentDate).HasColumnName("Payment_Date");

            entity.HasOne(d => d.Cart).WithMany(p => p.Payments)
                .HasForeignKey(d => d.CartId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Payment__Cart_Id__6FE99F9F");

            entity.HasOne(d => d.User).WithMany(p => p.Payments)
                .HasForeignKey(d => d.UserId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Payment__UserId__70DDC3D8");
        });

        modelBuilder.Entity<Pc>(entity =>
        {
            entity.HasKey(e => e.PcId).HasName("PK__PC__B9EB738DD92F74D7");

            entity.ToTable("PC");

            entity.Property(e => e.PcId).HasColumnName("PC_Id");
            entity.Property(e => e.Price).HasColumnType("money");
        });

        modelBuilder.Entity<PcComponent>(entity =>
        {
            entity
                .HasNoKey()
                .ToTable("PcComponent");

            entity.Property(e => e.PcId).HasColumnName("PC_Id");
            entity.Property(e => e.ProductId).HasColumnName("Product_Id");

            entity.HasOne(d => d.Pc).WithMany()
                .HasForeignKey(d => d.PcId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__PcCompone__PC_Id__5CD6CB2B");

            entity.HasOne(d => d.Product).WithMany()
                .HasForeignKey(d => d.ProductId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__PcCompone__Produ__5BE2A6F2");
        });

        modelBuilder.Entity<Product>(entity =>
        {
            entity.HasKey(e => e.ProductId).HasName("PK__Product__9834FBBAF35E5854");

            entity.ToTable("Product");

            entity.Property(e => e.ProductId).HasColumnName("Product_Id");
            entity.Property(e => e.BrandId).HasColumnName("Brand_Id");
            entity.Property(e => e.Color).HasMaxLength(50);
            entity.Property(e => e.FormattedPrice)
                .HasMaxLength(4000)
                .HasComputedColumnSql("(replace(format([Price],'#,##0.##','vi-VN'),'.',','))", false);
            entity.Property(e => e.Img1)
                .HasMaxLength(200)
                .IsUnicode(false)
                .HasColumnName("img1");
            entity.Property(e => e.Img2)
                .HasMaxLength(200)
                .IsUnicode(false)
                .HasColumnName("img2");
            entity.Property(e => e.Img3)
                .HasMaxLength(200)
                .IsUnicode(false)
                .HasColumnName("img3");
            entity.Property(e => e.ProductName)
                .HasMaxLength(100)
                .HasColumnName("Product_Name");
            entity.Property(e => e.SeriesId).HasColumnName("Series_Id");
            entity.Property(e => e.Stock).HasColumnName("STOCK");
            entity.Property(e => e.TypeId).HasColumnName("Type_Id_");
            entity.Property(e => e.Version)
                .HasMaxLength(100)
                .HasColumnName("Version_");

            entity.HasOne(d => d.Brand).WithMany(p => p.Products)
                .HasForeignKey(d => d.BrandId)
                .HasConstraintName("FK__Product__Brand_I__49C3F6B7");

            entity.HasOne(d => d.Series).WithMany(p => p.Products)
                .HasForeignKey(d => d.SeriesId)
                .HasConstraintName("FK__Product__Series___4AB81AF0");

            entity.HasOne(d => d.Type).WithMany(p => p.Products)
                .HasForeignKey(d => d.TypeId)
                .HasConstraintName("FK__Product__Type_Id__48CFD27E");
        });

        modelBuilder.Entity<ProductAttribute>(entity =>
        {
            entity
                .HasNoKey()
                .ToTable("Product_Attribute");

            entity.Property(e => e.AttributeId).HasColumnName("Attribute_Id");
            entity.Property(e => e.AttributeValue).HasColumnName("Attribute_Value");
            entity.Property(e => e.ProductId).HasColumnName("Product_Id");

            entity.HasOne(d => d.Attribute).WithMany()
                .HasForeignKey(d => d.AttributeId)
                .HasConstraintName("FK__Product_A__Attri__5165187F");

            entity.HasOne(d => d.Product).WithMany()
                .HasForeignKey(d => d.ProductId)
                .HasConstraintName("FK__Product_A__Produ__5070F446");
        });

        modelBuilder.Entity<ProductType>(entity =>
        {
            entity.HasKey(e => e.TypeId).HasName("PK__Product___663C3E38C43695BF");

            entity.ToTable("Product_Type");

            entity.Property(e => e.TypeId).HasColumnName("Type_Id_");
            entity.Property(e => e.TypeImgs)
                .HasMaxLength(100)
                .HasColumnName("Type_Imgs");
            entity.Property(e => e.TypeName)
                .HasMaxLength(30)
                .HasColumnName("Type_Name_");
        });

        modelBuilder.Entity<ProductTypeFilter>(entity =>
        {
            entity.HasKey(e => e.FilterId).HasName("PK__Product___CD5DA45C9E9E9298");

            entity.ToTable("Product_Type_Filter");

            entity.Property(e => e.FilterId).HasColumnName("Filter_Id");
            entity.Property(e => e.FilterName)
                .HasMaxLength(50)
                .HasColumnName("Filter_Name");
            entity.Property(e => e.TypeId).HasColumnName("Type_Id_");

            entity.HasOne(d => d.Type).WithMany(p => p.ProductTypeFilters)
                .HasForeignKey(d => d.TypeId)
                .HasConstraintName("FK__Product_T__Type___5441852A");
        });

        modelBuilder.Entity<Role>(entity =>
        {
            entity.HasKey(e => e.RoleId).HasName("PK__Role___D80AB4BBAFBAF77A");

            entity.ToTable("Role_");

            entity.Property(e => e.RoleId)
                .ValueGeneratedNever()
                .HasColumnName("Role_Id");
            entity.Property(e => e.RolePosition)
                .HasMaxLength(20)
                .HasColumnName("Role_Position");
        });

        modelBuilder.Entity<Series>(entity =>
        {
            entity.HasKey(e => e.SeriesId).HasName("PK__Series__3705FE8AF310F140");

            entity.Property(e => e.SeriesId).HasColumnName("Series_Id");
            entity.Property(e => e.BrandId).HasColumnName("Brand_Id");
            entity.Property(e => e.SeriesName)
                .HasMaxLength(50)
                .HasColumnName("Series_Name");

            entity.HasOne(d => d.Brand).WithMany(p => p.Series)
                .HasForeignKey(d => d.BrandId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Series__Brand_Id__45F365D3");
        });

        modelBuilder.Entity<ShoppingCart>(entity =>
        {
            entity.HasKey(e => e.CartId).HasName("PK__Shopping__D6AB47597EE58C45");

            entity.ToTable("ShoppingCart");

            entity.Property(e => e.CartId).HasColumnName("Cart_Id");

            entity.HasOne(d => d.User).WithMany(p => p.ShoppingCarts)
                .HasForeignKey(d => d.UserId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__ShoppingC__UserI__5FB337D6");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.UserId).HasName("PK__User___1788CC4C2EE450C6");

            entity.ToTable("User_");

            entity.HasIndex(e => e.Phone, "UQ__User___5C7E359EBAFAB952").IsUnique();

            entity.HasIndex(e => e.Email, "UQ__User___A9D1053475A58C3B").IsUnique();

            entity.Property(e => e.Address)
                .HasMaxLength(50)
                .HasColumnName("Address_");
            entity.Property(e => e.Email)
                .HasMaxLength(30)
                .IsUnicode(false);
            entity.Property(e => e.FullName).HasMaxLength(100);
            entity.Property(e => e.Phone)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.UserName)
                .HasMaxLength(20)
                .IsUnicode(false);

            entity.HasOne(d => d.UserNameNavigation).WithMany(p => p.Users)
                .HasForeignKey(d => d.UserName)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__User___UserName__3E52440B");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}

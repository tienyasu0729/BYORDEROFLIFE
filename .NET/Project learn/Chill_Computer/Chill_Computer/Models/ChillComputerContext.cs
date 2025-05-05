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

    public virtual DbSet<News> News { get; set; }

    public virtual DbSet<NewsCategory> NewsCategories { get; set; }

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
        => optionsBuilder.UseSqlServer("Data Source=DESKTOP-J1P01U8\\SQLEXPRESS;Database=Chill_Computer;TrustServerCertificate=true;Trusted_Connection=SSPI;Encrypt=false;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Account>(entity =>
        {
            entity.HasKey(e => e.UserName).HasName("PK__Account__C9F28457EB540FD0");

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
                .HasConstraintName("FK__Account__Role_Id__1273C1CD");
        });

        modelBuilder.Entity<Attribute>(entity =>
        {
            entity.HasKey(e => e.AttributeId).HasName("PK__Attribut__6DC45AB75155B75F");

            entity.ToTable("Attribute");

            entity.Property(e => e.AttributeId).HasColumnName("Attribute_Id");
            entity.Property(e => e.AttributeName)
                .HasMaxLength(100)
                .HasColumnName("Attribute_Name");
            entity.Property(e => e.ParentId).HasColumnName("Parent_Id");
            entity.Property(e => e.TypeId).HasColumnName("Type_Id_");

            entity.HasOne(d => d.Parent).WithMany(p => p.InverseParent)
                .HasForeignKey(d => d.ParentId)
                .HasConstraintName("FK__Attribute__Paren__276EDEB3");

            entity.HasOne(d => d.Type).WithMany(p => p.Attributes)
                .HasForeignKey(d => d.TypeId)
                .HasConstraintName("FK__Attribute__Type___267ABA7A");
        });

        modelBuilder.Entity<Blog>(entity =>
        {
            entity.HasKey(e => e.BlogId).HasName("PK__Blog__C164D038249AB8E7");

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
            entity.HasKey(e => e.BrandId).HasName("PK__Brand__AAB3214FEA60F542");

            entity.ToTable("Brand");

            entity.HasIndex(e => e.BrandName, "UQ__Brand__0C45B1A9885691D3").IsUnique();

            entity.Property(e => e.BrandId).HasColumnName("Brand_Id");
            entity.Property(e => e.BrandName)
                .HasMaxLength(50)
                .HasColumnName("Brand_Name");
        });

        modelBuilder.Entity<CartItem>(entity =>
        {
            entity.HasKey(e => e.CartItemId).HasName("PK__CartItem__3C0F265C6DECCDCF");

            entity.ToTable("CartItem");

            entity.Property(e => e.CartItemId).HasColumnName("Cart_Item_Id");
            entity.Property(e => e.CartId).HasColumnName("Cart_Id");
            entity.Property(e => e.ItemQuantity).HasColumnName("Item_Quantity");
            entity.Property(e => e.PcId).HasColumnName("PC_Id");
            entity.Property(e => e.ProductId).HasColumnName("Product_Id");

            entity.HasOne(d => d.Cart).WithMany(p => p.CartItems)
                .HasForeignKey(d => d.CartId)
                .HasConstraintName("FK__CartItem__Cart_I__3C69FB99");

            entity.HasOne(d => d.Pc).WithMany(p => p.CartItems)
                .HasForeignKey(d => d.PcId)
                .HasConstraintName("FK__CartItem__PC_Id__3D5E1FD2");

            entity.HasOne(d => d.Product).WithMany(p => p.CartItems)
                .HasForeignKey(d => d.ProductId)
                .HasConstraintName("FK__CartItem__Produc__3B75D760");
        });

        modelBuilder.Entity<Discount>(entity =>
        {
            entity.HasKey(e => e.DiscountId).HasName("PK__Discount__6C137204350B0A64");

            entity.ToTable("Discount");

            entity.HasIndex(e => e.DiscountCode, "UQ__Discount__7997690682BDFA1B").IsUnique();

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
            entity.HasKey(e => e.CategoryId).HasName("PK__Filter_C__6DB38D6EA7FDA211");

            entity.ToTable("Filter_Category");

            entity.Property(e => e.CategoryId).HasColumnName("Category_Id");
            entity.Property(e => e.CategoryName)
                .HasMaxLength(50)
                .HasColumnName("Category_Name");
            entity.Property(e => e.FilterId).HasColumnName("Filter_Id");
            entity.Property(e => e.ParentId).HasColumnName("Parent_Id");

            entity.HasOne(d => d.Filter).WithMany(p => p.FilterCategories)
                .HasForeignKey(d => d.FilterId)
                .HasConstraintName("FK__Filter_Ca__Filte__30F848ED");

            entity.HasOne(d => d.Parent).WithMany(p => p.InverseParent)
                .HasForeignKey(d => d.ParentId)
                .HasConstraintName("FK__Filter_Ca__Paren__300424B4");
        });

        modelBuilder.Entity<News>(entity =>
        {
            entity.HasKey(e => e.NewsId).HasName("PK__News__DC8860AB72ED13F0");

            entity.HasIndex(e => e.Slug, "UQ__News__BC7B5FB6D731E58A").IsUnique();

            entity.Property(e => e.NewsId).HasColumnName("News_Id");
            entity.Property(e => e.ApprovalDate).HasColumnType("datetime");
            entity.Property(e => e.ApprovalStatus)
                .HasMaxLength(20)
                .HasDefaultValue("Pending");
            entity.Property(e => e.ApprovedBy)
                .HasMaxLength(20)
                .IsUnicode(false);
            entity.Property(e => e.AuthorUserName)
                .HasMaxLength(20)
                .IsUnicode(false)
                .HasColumnName("Author_UserName");
            entity.Property(e => e.CategoryId).HasColumnName("Category_Id");
            entity.Property(e => e.DatePublish)
                .HasDefaultValueSql("(getdate())")
                .HasColumnType("datetime")
                .HasColumnName("Date_Publish");
            entity.Property(e => e.IsVisible)
                .HasDefaultValue(true)
                .HasColumnName("Is_Visible");
            entity.Property(e => e.Slug).HasMaxLength(200);
            entity.Property(e => e.Summary).HasMaxLength(500);
            entity.Property(e => e.Thumbnail).HasMaxLength(255);
            entity.Property(e => e.Title).HasMaxLength(200);

            entity.HasOne(d => d.ApprovedByNavigation).WithMany(p => p.NewsApprovedByNavigations)
                .HasForeignKey(d => d.ApprovedBy)
                .HasConstraintName("FK__News__ApprovedBy__5812160E");

            entity.HasOne(d => d.AuthorUserNameNavigation).WithMany(p => p.NewsAuthorUserNameNavigations)
                .HasForeignKey(d => d.AuthorUserName)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__News__Author_Use__571DF1D5");

            entity.HasOne(d => d.Category).WithMany(p => p.News)
                .HasForeignKey(d => d.CategoryId)
                .HasConstraintName("FK__News__Category_I__59063A47");
        });

        modelBuilder.Entity<NewsCategory>(entity =>
        {
            entity.HasKey(e => e.CategoryId).HasName("PK__NewsCate__6DB38D6E5F9CAA3B");

            entity.ToTable("NewsCategory");

            entity.Property(e => e.CategoryId).HasColumnName("Category_Id");
            entity.Property(e => e.CategoryName)
                .HasMaxLength(100)
                .HasColumnName("Category_Name");
            entity.Property(e => e.ParentId).HasColumnName("Parent_Id");

            entity.HasOne(d => d.Parent).WithMany(p => p.InverseParent)
                .HasForeignKey(d => d.ParentId)
                .HasConstraintName("FK__NewsCateg__Paren__5070F446");
        });

        modelBuilder.Entity<Order>(entity =>
        {
            entity.HasKey(e => e.OrderId).HasName("PK__Order___F1E4607B37D85A46");

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
                .HasConstraintName("FK__Order___UserId__403A8C7D");
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
                .HasConstraintName("FK__OrderItem__Order__4222D4EF");

            entity.HasOne(d => d.Pc).WithMany()
                .HasForeignKey(d => d.PcId)
                .HasConstraintName("FK__OrderItem__PC_Id__440B1D61");

            entity.HasOne(d => d.Product).WithMany()
                .HasForeignKey(d => d.ProductId)
                .HasConstraintName("FK__OrderItem__Produ__4316F928");
        });

        modelBuilder.Entity<Payment>(entity =>
        {
            entity.HasKey(e => e.PaymentId).HasName("PK__Payment__DA6C7FC1638E7EC4");

            entity.ToTable("Payment");

            entity.Property(e => e.PaymentId).HasColumnName("Payment_Id");
            entity.Property(e => e.CartId).HasColumnName("Cart_Id");
            entity.Property(e => e.PaymentDate).HasColumnName("Payment_Date");

            entity.HasOne(d => d.Cart).WithMany(p => p.Payments)
                .HasForeignKey(d => d.CartId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Payment__Cart_Id__48CFD27E");

            entity.HasOne(d => d.User).WithMany(p => p.Payments)
                .HasForeignKey(d => d.UserId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Payment__UserId__49C3F6B7");
        });

        modelBuilder.Entity<Pc>(entity =>
        {
            entity.HasKey(e => e.PcId).HasName("PK__PC__B9EB738DAE1B7249");

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
                .HasConstraintName("FK__PcCompone__PC_Id__35BCFE0A");

            entity.HasOne(d => d.Product).WithMany()
                .HasForeignKey(d => d.ProductId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__PcCompone__Produ__34C8D9D1");
        });

        modelBuilder.Entity<Product>(entity =>
        {
            entity.HasKey(e => e.ProductId).HasName("PK__Product__9834FBBA672AFD78");

            entity.ToTable("Product");

            entity.Property(e => e.ProductId).HasColumnName("Product_Id");
            entity.Property(e => e.BrandId).HasColumnName("Brand_Id");
            entity.Property(e => e.Color).HasMaxLength(50);
            entity.Property(e => e.FormattedPrice)
                .HasMaxLength(4000)
                .HasComputedColumnSql("(replace(format([Price],'#,##0.##','vi-VN'),'.',','))", false);
            entity.Property(e => e.Img1)
                .IsUnicode(false)
                .HasColumnName("img1");
            entity.Property(e => e.Img2)
                .IsUnicode(false)
                .HasColumnName("img2");
            entity.Property(e => e.Img3)
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
                .HasConstraintName("FK__Product__Brand_I__22AA2996");

            entity.HasOne(d => d.Series).WithMany(p => p.Products)
                .HasForeignKey(d => d.SeriesId)
                .HasConstraintName("FK__Product__Series___239E4DCF");

            entity.HasOne(d => d.Type).WithMany(p => p.Products)
                .HasForeignKey(d => d.TypeId)
                .HasConstraintName("FK__Product__Type_Id__21B6055D");
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
                .HasConstraintName("FK__Product_A__Attri__2A4B4B5E");

            entity.HasOne(d => d.Product).WithMany()
                .HasForeignKey(d => d.ProductId)
                .HasConstraintName("FK__Product_A__Produ__29572725");
        });

        modelBuilder.Entity<ProductType>(entity =>
        {
            entity.HasKey(e => e.TypeId).HasName("PK__Product___663C3E383B6FB769");

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
            entity.HasKey(e => e.FilterId).HasName("PK__Product___CD5DA45C958B7A94");

            entity.ToTable("Product_Type_Filter");

            entity.Property(e => e.FilterId).HasColumnName("Filter_Id");
            entity.Property(e => e.FilterName)
                .HasMaxLength(50)
                .HasColumnName("Filter_Name");
            entity.Property(e => e.FilterTag)
                .HasMaxLength(50)
                .HasColumnName("Filter_Tag");
            entity.Property(e => e.TypeId).HasColumnName("Type_Id_");

            entity.HasOne(d => d.Type).WithMany(p => p.ProductTypeFilters)
                .HasForeignKey(d => d.TypeId)
                .HasConstraintName("FK__Product_T__Type___2D27B809");
        });

        modelBuilder.Entity<Role>(entity =>
        {
            entity.HasKey(e => e.RoleId).HasName("PK__Role___D80AB4BBAC2BD0F5");

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
            entity.HasKey(e => e.SeriesId).HasName("PK__Series__3705FE8AC74B9F52");

            entity.Property(e => e.SeriesId).HasColumnName("Series_Id");
            entity.Property(e => e.BrandId).HasColumnName("Brand_Id");
            entity.Property(e => e.SeriesName)
                .HasMaxLength(50)
                .HasColumnName("Series_Name");

            entity.HasOne(d => d.Brand).WithMany(p => p.Series)
                .HasForeignKey(d => d.BrandId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Series__Brand_Id__1ED998B2");
        });

        modelBuilder.Entity<ShoppingCart>(entity =>
        {
            entity.HasKey(e => e.CartId).HasName("PK__Shopping__D6AB475992DD14C5");

            entity.ToTable("ShoppingCart");

            entity.Property(e => e.CartId).HasColumnName("Cart_Id");

            entity.HasOne(d => d.User).WithMany(p => p.ShoppingCarts)
                .HasForeignKey(d => d.UserId)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__ShoppingC__UserI__38996AB5");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.UserId).HasName("PK__User___1788CC4C4CC78A08");

            entity.ToTable("User_");

            entity.HasIndex(e => e.Phone, "UQ__User___5C7E359ED9E33BD2").IsUnique();

            entity.HasIndex(e => e.Email, "UQ__User___A9D1053470412EF8").IsUnique();

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
                .HasConstraintName("FK__User___UserName__173876EA");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}

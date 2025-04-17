using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class ShopeeContext : DbContext
{
    public ShopeeContext()
    {
    }

    public ShopeeContext(DbContextOptions<ShopeeContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Area> Areas { get; set; }

    public virtual DbSet<BlockedUser> BlockedUsers { get; set; }

    public virtual DbSet<BusinessInformation> BusinessInformations { get; set; }

    public virtual DbSet<Category> Categories { get; set; }

    public virtual DbSet<CategoryAttribute> CategoryAttributes { get; set; }

    public virtual DbSet<CategoryValue> CategoryValues { get; set; }

    public virtual DbSet<ChatSetting> ChatSettings { get; set; }

    public virtual DbSet<Classification> Classifications { get; set; }

    public virtual DbSet<ClassificationValue> ClassificationValues { get; set; }

    public virtual DbSet<CoinHistory> CoinHistories { get; set; }

    public virtual DbSet<DeliveryVoucher> DeliveryVouchers { get; set; }

    public virtual DbSet<FormOfIdentification> FormOfIdentifications { get; set; }

    public virtual DbSet<IdentificationShop> IdentificationShops { get; set; }

    public virtual DbSet<ImageAndShortVideoProduct> ImageAndShortVideoProducts { get; set; }

    public virtual DbSet<ListEmailToReceiveElectronicInvoice> ListEmailToReceiveElectronicInvoices { get; set; }

    public virtual DbSet<ListItemInOrderCancelled> ListItemInOrderCancelleds { get; set; }

    public virtual DbSet<ListItemInOrderCompleted> ListItemInOrderCompleteds { get; set; }

    public virtual DbSet<ListItemInOrderInTransit> ListItemInOrderInTransits { get; set; }

    public virtual DbSet<ListItemInOrderPendingPayment> ListItemInOrderPendingPayments { get; set; }

    public virtual DbSet<ListItemInOrderPendingShipment> ListItemInOrderPendingShipments { get; set; }

    public virtual DbSet<ListItemInOrderReturned> ListItemInOrderReturneds { get; set; }

    public virtual DbSet<MainAccount> MainAccounts { get; set; }

    public virtual DbSet<NotificationSetting> NotificationSettings { get; set; }

    public virtual DbSet<PartnerPlatform> PartnerPlatforms { get; set; }

    public virtual DbSet<PaymentMethod> PaymentMethods { get; set; }

    public virtual DbSet<PaymentSetting> PaymentSettings { get; set; }

    public virtual DbSet<Product> Products { get; set; }

    public virtual DbSet<ProductGroup> ProductGroups { get; set; }

    public virtual DbSet<ProductReview> ProductReviews { get; set; }

    public virtual DbSet<ProductShippingMethod> ProductShippingMethods { get; set; }

    public virtual DbSet<ShippingMethod> ShippingMethods { get; set; }

    public virtual DbSet<Shop> Shops { get; set; }

    public virtual DbSet<ShopShippingMethod> ShopShippingMethods { get; set; }

    public virtual DbSet<ShopVoucher> ShopVouchers { get; set; }

    public virtual DbSet<User> Users { get; set; }

    public virtual DbSet<UserAddress> UserAddresses { get; set; }

    public virtual DbSet<UserIdentificationInformation> UserIdentificationInformations { get; set; }

    public virtual DbSet<UserNotification> UserNotifications { get; set; }

    public virtual DbSet<UserOrderCancelled> UserOrderCancelleds { get; set; }

    public virtual DbSet<UserOrderCompleted> UserOrderCompleteds { get; set; }

    public virtual DbSet<UserOrderInTransit> UserOrderInTransits { get; set; }

    public virtual DbSet<UserOrderPendingPayment> UserOrderPendingPayments { get; set; }

    public virtual DbSet<UserOrderPendingShipment> UserOrderPendingShipments { get; set; }

    public virtual DbSet<UserOrderReturned> UserOrderReturneds { get; set; }

    public virtual DbSet<UserSpending> UserSpendings { get; set; }

    public virtual DbSet<UserWallet> UserWallets { get; set; }

    public virtual DbSet<WebVoucher> WebVouchers { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Data Source=DESKTOP-J1P01U8\\SQLEXPRESS;Database=shopee;TrustServerCertificate=true;Trusted_Connection=SSPI;Encrypt=false;");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Area>(entity =>
        {
            entity.HasKey(e => e.AreaId).HasName("PK__area__985D6D6BDD76120F");

            entity.ToTable("area");

            entity.HasIndex(e => e.NameArea, "UQ__area__E93001892C6900C4").IsUnique();

            entity.Property(e => e.AreaId).HasColumnName("area_id");
            entity.Property(e => e.NameArea)
                .HasMaxLength(200)
                .HasColumnName("name_area");
        });

        modelBuilder.Entity<BlockedUser>(entity =>
        {
            entity.HasKey(e => new { e.IdShop, e.IdUser }).HasName("PK__blocked___2AFFDEFF109B554E");

            entity.ToTable("blocked_user");

            entity.Property(e => e.IdShop).HasColumnName("id_shop");
            entity.Property(e => e.IdUser).HasColumnName("id_user");
            entity.Property(e => e.BlockDateTime)
                .HasDefaultValueSql("(getdate())")
                .HasColumnType("datetime")
                .HasColumnName("block_dateTime");

            entity.HasOne(d => d.IdShopNavigation).WithMany(p => p.BlockedUsers)
                .HasForeignKey(d => d.IdShop)
                .HasConstraintName("FK__blocked_u__id_sh__534D60F1");

            entity.HasOne(d => d.IdUserNavigation).WithMany(p => p.BlockedUsers)
                .HasForeignKey(d => d.IdUser)
                .HasConstraintName("FK__blocked_u__id_us__5441852A");
        });

        modelBuilder.Entity<BusinessInformation>(entity =>
        {
            entity.HasKey(e => e.IdShop).HasName("PK__business__47D2CA9CDCB7591A");

            entity.ToTable("business_information");

            entity.Property(e => e.IdShop)
                .ValueGeneratedNever()
                .HasColumnName("id_shop");
            entity.Property(e => e.AddressToTakeProduct)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("address_to_take_product");
            entity.Property(e => e.BusinessType)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("business_type");
            entity.Property(e => e.RegisteredBusinessAddress)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("registered_business_address");
            entity.Property(e => e.TaxIdentificationNumber)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("tax_identification_number");

            entity.HasOne(d => d.IdShopNavigation).WithOne(p => p.BusinessInformation)
                .HasForeignKey<BusinessInformation>(d => d.IdShop)
                .HasConstraintName("FK__business___id_sh__6FE99F9F");
        });

        modelBuilder.Entity<Category>(entity =>
        {
            entity.HasKey(e => e.IdCategory).HasName("PK__category__E548B673294E64AB");

            entity.ToTable("category");

            entity.Property(e => e.IdCategory).HasColumnName("id_category");
            entity.Property(e => e.IdParent).HasColumnName("id_parent");
            entity.Property(e => e.NameCategory)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("name_category");

            entity.HasOne(d => d.IdParentNavigation).WithMany(p => p.InverseIdParentNavigation)
                .HasForeignKey(d => d.IdParent)
                .HasConstraintName("FK__category__id_par__7F2BE32F");
        });

        modelBuilder.Entity<CategoryAttribute>(entity =>
        {
            entity.HasKey(e => e.IdCategoryAttribute).HasName("PK__category__526DC8450A3BFDC4");

            entity.ToTable("category_attribute");

            entity.Property(e => e.IdCategoryAttribute).HasColumnName("id_category_attribute");
            entity.Property(e => e.IdCategory).HasColumnName("id_category");
            entity.Property(e => e.NameAttribute)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("name_attribute");

            entity.HasOne(d => d.IdCategoryNavigation).WithMany(p => p.CategoryAttributes)
                .HasForeignKey(d => d.IdCategory)
                .HasConstraintName("FK__category___id_ca__02084FDA");
        });

        modelBuilder.Entity<CategoryValue>(entity =>
        {
            entity.HasKey(e => new { e.IdProduct, e.IdCategoryAttribute }).HasName("PK__category__FF1F34CB2E68388B");

            entity.ToTable("category_value");

            entity.Property(e => e.IdProduct).HasColumnName("id_product");
            entity.Property(e => e.IdCategoryAttribute).HasColumnName("id_category_attribute");
            entity.Property(e => e.AttributeValue)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("attribute_value");

            entity.HasOne(d => d.IdCategoryAttributeNavigation).WithMany(p => p.CategoryValues)
                .HasForeignKey(d => d.IdCategoryAttribute)
                .HasConstraintName("FK__category___id_ca__0D7A0286");

            entity.HasOne(d => d.IdProductNavigation).WithMany(p => p.CategoryValues)
                .HasForeignKey(d => d.IdProduct)
                .HasConstraintName("FK__category___id_pr__0C85DE4D");
        });

        modelBuilder.Entity<ChatSetting>(entity =>
        {
            entity.HasKey(e => e.IdShop).HasName("PK__chat_set__47D2CA9CA65D2DA0");

            entity.ToTable("chat_settings");

            entity.Property(e => e.IdShop)
                .ValueGeneratedNever()
                .HasColumnName("id_shop");
            entity.Property(e => e.PlaySoundNotificationForNewMessages).HasColumnName("Play_sound_notification_for_new_messages");
            entity.Property(e => e.PushNewPopupMessage).HasColumnName("Push_new_popup_message");
            entity.Property(e => e.ReceiveMessagesFromPersonalPage).HasColumnName("Receive_messages_from_Personal_Page");
            entity.Property(e => e.ReceiveMessagesFromShopeeRewards).HasColumnName("Receive_messages_from_Shopee_Rewards");

            entity.HasOne(d => d.IdShopNavigation).WithOne(p => p.ChatSetting)
                .HasForeignKey<ChatSetting>(d => d.IdShop)
                .HasConstraintName("FK__chat_sett__id_sh__656C112C");
        });

        modelBuilder.Entity<Classification>(entity =>
        {
            entity.HasKey(e => e.IdClassification).HasName("PK__classifi__065BF75F7227A90D");

            entity.ToTable("classification");

            entity.Property(e => e.IdClassification).HasColumnName("id_classification");
            entity.Property(e => e.ClassificationName)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("classification_name");
            entity.Property(e => e.IdProduct).HasColumnName("id_product");

            entity.HasOne(d => d.IdProductNavigation).WithMany(p => p.Classifications)
                .HasForeignKey(d => d.IdProduct)
                .HasConstraintName("FK__classific__id_pr__10566F31");
        });

        modelBuilder.Entity<ClassificationValue>(entity =>
        {
            entity.HasKey(e => e.IdClassificationValue).HasName("PK__classifi__07E56D94D687ADD8");

            entity.ToTable("classification_value");

            entity.Property(e => e.IdClassificationValue).HasColumnName("id_classification_value");
            entity.Property(e => e.AllowedPackageInspection)
                .HasDefaultValue(false)
                .HasColumnName("allowed_package_inspection");
            entity.Property(e => e.ClassificationValue1)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("classification_value");
            entity.Property(e => e.IdClassification).HasColumnName("id_classification");
            entity.Property(e => e.InventoryQuantity)
                .HasDefaultValue(0)
                .HasColumnName("inventory_quantity");
            entity.Property(e => e.PackagedHeight)
                .HasColumnType("decimal(10, 2)")
                .HasColumnName("packaged_height");
            entity.Property(e => e.PackagedLength)
                .HasColumnType("decimal(10, 2)")
                .HasColumnName("packaged_length");
            entity.Property(e => e.PackagedWeight)
                .HasColumnType("decimal(10, 2)")
                .HasColumnName("packaged_weight");
            entity.Property(e => e.PackagedWidth)
                .HasColumnType("decimal(10, 2)")
                .HasColumnName("packaged_width");
            entity.Property(e => e.Price).HasColumnName("price");
            entity.Property(e => e.SkuClassification)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("SKU_classification");
            entity.Property(e => e.Status).HasColumnName("status");

            entity.HasOne(d => d.IdClassificationNavigation).WithMany(p => p.ClassificationValues)
                .HasForeignKey(d => d.IdClassification)
                .HasConstraintName("FK__classific__id_cl__151B244E");
        });

        modelBuilder.Entity<CoinHistory>(entity =>
        {
            entity.HasKey(e => e.IdCoinHistory).HasName("PK__coin_his__E0D2B799068EE709");

            entity.ToTable("coin_history");

            entity.Property(e => e.IdCoinHistory).HasColumnName("id_coin_history");
            entity.Property(e => e.NotificationReceiptDate)
                .HasDefaultValueSql("(CONVERT([date],getdate()))")
                .HasColumnName("notification_receipt_date");
            entity.Property(e => e.NotificationSubject)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("notification_subject");
            entity.Property(e => e.NumberCoin)
                .HasDefaultValue(0)
                .HasColumnName("number_coin");
        });

        modelBuilder.Entity<DeliveryVoucher>(entity =>
        {
            entity.HasKey(e => e.IdDeliveryVoucher).HasName("PK__delivery__BD8F62905EA3E091");

            entity.ToTable("delivery_voucher");

            entity.Property(e => e.IdDeliveryVoucher).HasColumnName("id_delivery_voucher");
            entity.Property(e => e.DiscountEndDate).HasColumnName("discount_end_date");
            entity.Property(e => e.DiscountPercentage).HasColumnName("discount_percentage");
            entity.Property(e => e.DiscountStartDate).HasColumnName("discount_start_date");
            entity.Property(e => e.MaximumDiscountAmount).HasColumnName("maximum_discount_amount");
            entity.Property(e => e.OfferDescription)
                .HasColumnType("text")
                .HasColumnName("offer_description");
            entity.Property(e => e.ThiếtBị)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("thiết_bị");
            entity.Property(e => e.ĐơnVịVậnChuyển)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("đơn_vị_vận_chuyển");
        });

        modelBuilder.Entity<FormOfIdentification>(entity =>
        {
            entity.HasKey(e => e.FormId).HasName("PK__form_of___190E16C928008471");

            entity.ToTable("form_of_identification");

            entity.Property(e => e.FormId).HasColumnName("form_id");
            entity.Property(e => e.NameForm)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("name_form");
        });

        modelBuilder.Entity<IdentificationShop>(entity =>
        {
            entity.HasKey(e => e.IdShop).HasName("PK__identifi__47D2CA9C6573696E");

            entity.ToTable("identification_shop");

            entity.Property(e => e.IdShop)
                .ValueGeneratedNever()
                .HasColumnName("id_shop");
            entity.Property(e => e.FormOfIdentification).HasColumnName("form_of_identification");
            entity.Property(e => e.IdentificationName)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("identification_name");
            entity.Property(e => e.IdentificationNumber)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("identification_number");
            entity.Property(e => e.ImageIdentificationBack)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("image_identification_back");
            entity.Property(e => e.ImageIdentificationFront)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("image_identification_front");

            entity.HasOne(d => d.FormOfIdentificationNavigation).WithMany(p => p.IdentificationShops)
                .HasForeignKey(d => d.FormOfIdentification)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__identific__form___75A278F5");

            entity.HasOne(d => d.IdShopNavigation).WithOne(p => p.IdentificationShop)
                .HasForeignKey<IdentificationShop>(d => d.IdShop)
                .HasConstraintName("FK__identific__id_sh__76969D2E");
        });

        modelBuilder.Entity<ImageAndShortVideoProduct>(entity =>
        {
            entity.HasKey(e => e.IdProduct).HasName("PK__image_an__BA39E84F21F171AA");

            entity.ToTable("image_and_short_video_product");

            entity.Property(e => e.IdProduct)
                .ValueGeneratedNever()
                .HasColumnName("id_product");
            entity.Property(e => e.FolderImage)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("folder_image");
            entity.Property(e => e.Video)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("video");

            entity.HasOne(d => d.IdProductNavigation).WithOne(p => p.ImageAndShortVideoProduct)
                .HasForeignKey<ImageAndShortVideoProduct>(d => d.IdProduct)
                .HasConstraintName("FK__image_and__id_pr__09A971A2");
        });

        modelBuilder.Entity<ListEmailToReceiveElectronicInvoice>(entity =>
        {
            entity.HasKey(e => e.IdEmailReceiveElectronic).HasName("PK__list_ema__D541B839547CD668");

            entity.ToTable("list_email_to_receive_electronic_invoices");

            entity.HasIndex(e => e.EmailAddress, "UQ__list_ema__20C6DFF5DD7C240D").IsUnique();

            entity.Property(e => e.IdEmailReceiveElectronic).HasColumnName("id_email_receive_electronic");
            entity.Property(e => e.EmailAddress)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("email_address");
            entity.Property(e => e.IdShop).HasColumnName("id_shop");

            entity.HasOne(d => d.IdShopNavigation).WithMany(p => p.ListEmailToReceiveElectronicInvoices)
                .HasForeignKey(d => d.IdShop)
                .HasConstraintName("FK__list_emai__id_sh__5812160E");
        });

        modelBuilder.Entity<ListItemInOrderCancelled>(entity =>
        {
            entity.HasKey(e => e.IdListOrderCancelled).HasName("PK__list_ite__3DFD866764BE31C5");

            entity.ToTable("list_item_in_order_cancelled");

            entity.Property(e => e.IdListOrderCancelled).HasColumnName("id_list_order_cancelled");
            entity.Property(e => e.IdClassificationValue).HasColumnName("id_classification_value");
            entity.Property(e => e.IdOrderCancelled).HasColumnName("id_order_cancelled");
            entity.Property(e => e.ProductDetailsDeleted).HasColumnName("product_details_deleted");
            entity.Property(e => e.ProductQuantity).HasColumnName("product_quantity");

            entity.HasOne(d => d.IdClassificationValueNavigation).WithMany(p => p.ListItemInOrderCancelleds)
                .HasForeignKey(d => d.IdClassificationValue)
                .HasConstraintName("FK__list_item__id_cl__7849DB76");

            entity.HasOne(d => d.IdOrderCancelledNavigation).WithMany(p => p.ListItemInOrderCancelleds)
                .HasForeignKey(d => d.IdOrderCancelled)
                .HasConstraintName("FK__list_item__id_or__7755B73D");
        });

        modelBuilder.Entity<ListItemInOrderCompleted>(entity =>
        {
            entity.HasKey(e => e.IdListOrderCompleted).HasName("PK__list_ite__16D7602C9B0C25DA");

            entity.ToTable("list_item_in_order_completed");

            entity.Property(e => e.IdListOrderCompleted).HasColumnName("id_list_order_completed");
            entity.Property(e => e.IdClassificationValue).HasColumnName("id_classification_value");
            entity.Property(e => e.IdOrderCompleted).HasColumnName("id_order_completed");
            entity.Property(e => e.ProductDetailsDeleted).HasColumnName("product_details_deleted");
            entity.Property(e => e.ProductQuantity).HasColumnName("product_quantity");

            entity.HasOne(d => d.IdClassificationValueNavigation).WithMany(p => p.ListItemInOrderCompleteds)
                .HasForeignKey(d => d.IdClassificationValue)
                .HasConstraintName("FK__list_item__id_cl__6CD828CA");

            entity.HasOne(d => d.IdOrderCompletedNavigation).WithMany(p => p.ListItemInOrderCompleteds)
                .HasForeignKey(d => d.IdOrderCompleted)
                .HasConstraintName("FK__list_item__id_or__6BE40491");
        });

        modelBuilder.Entity<ListItemInOrderInTransit>(entity =>
        {
            entity.HasKey(e => new { e.IdOrderInTransit, e.IdClassificationValue }).HasName("PK__list_ite__C74D049C4A03FA2F");

            entity.ToTable("list_item_in_order_in_transit");

            entity.Property(e => e.IdOrderInTransit).HasColumnName("id_order_in_transit");
            entity.Property(e => e.IdClassificationValue).HasColumnName("id_classification_value");
            entity.Property(e => e.ProductQuantity).HasColumnName("product_quantity");

            entity.HasOne(d => d.IdClassificationValueNavigation).WithMany(p => p.ListItemInOrderInTransits)
                .HasForeignKey(d => d.IdClassificationValue)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__list_item__id_cl__55F4C372");

            entity.HasOne(d => d.IdOrderInTransitNavigation).WithMany(p => p.ListItemInOrderInTransits)
                .HasForeignKey(d => d.IdOrderInTransit)
                .HasConstraintName("FK__list_item__id_or__55009F39");
        });

        modelBuilder.Entity<ListItemInOrderPendingPayment>(entity =>
        {
            entity.HasKey(e => new { e.IdOrderPendingPayment, e.IdClassificationValue }).HasName("PK__list_ite__0CF77EDE9CFF004B");

            entity.ToTable("list_item_in_order_pending_payment");

            entity.Property(e => e.IdOrderPendingPayment).HasColumnName("id_order_pending_payment");
            entity.Property(e => e.IdClassificationValue).HasColumnName("id_classification_value");
            entity.Property(e => e.ProductQuantity).HasColumnName("product_quantity");

            entity.HasOne(d => d.IdClassificationValueNavigation).WithMany(p => p.ListItemInOrderPendingPayments)
                .HasForeignKey(d => d.IdClassificationValue)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__list_item__id_cl__4A8310C6");

            entity.HasOne(d => d.IdOrderPendingPaymentNavigation).WithMany(p => p.ListItemInOrderPendingPayments)
                .HasForeignKey(d => d.IdOrderPendingPayment)
                .HasConstraintName("FK__list_item__id_or__498EEC8D");
        });

        modelBuilder.Entity<ListItemInOrderPendingShipment>(entity =>
        {
            entity.HasKey(e => e.IdListPendingShipment).HasName("PK__list_ite__E7F8C2F6D67D9F79");

            entity.ToTable("list_item_in_order_pending_shipment");

            entity.Property(e => e.IdListPendingShipment).HasColumnName("id_list_pending_shipment");
            entity.Property(e => e.IdClassificationValue).HasColumnName("id_classification_value");
            entity.Property(e => e.IdOrderPendingShipment).HasColumnName("id_order_pending_shipment");
            entity.Property(e => e.ProductDetailsDeleted).HasColumnName("product_details_deleted");
            entity.Property(e => e.ProductQuantity).HasColumnName("product_quantity");

            entity.HasOne(d => d.IdClassificationValueNavigation).WithMany(p => p.ListItemInOrderPendingShipments)
                .HasForeignKey(d => d.IdClassificationValue)
                .HasConstraintName("FK__list_item__id_cl__6166761E");

            entity.HasOne(d => d.IdOrderPendingShipmentNavigation).WithMany(p => p.ListItemInOrderPendingShipments)
                .HasForeignKey(d => d.IdOrderPendingShipment)
                .HasConstraintName("FK__list_item__id_or__607251E5");
        });

        modelBuilder.Entity<ListItemInOrderReturned>(entity =>
        {
            entity.HasKey(e => e.IdListOrderReturned).HasName("PK__list_ite__3E430CCC54FA858F");

            entity.ToTable("list_item_in_order_returned");

            entity.Property(e => e.IdListOrderReturned).HasColumnName("id_list_order_returned");
            entity.Property(e => e.IdClassificationValue).HasColumnName("id_classification_value");
            entity.Property(e => e.IdOrderReturned).HasColumnName("id_order_returned");
            entity.Property(e => e.ProductDetailsDeleted).HasColumnName("product_details_deleted");
            entity.Property(e => e.ProductQuantity).HasColumnName("product_quantity");

            entity.HasOne(d => d.IdClassificationValueNavigation).WithMany(p => p.ListItemInOrderReturneds)
                .HasForeignKey(d => d.IdClassificationValue)
                .HasConstraintName("FK__list_item__id_cl__03BB8E22");

            entity.HasOne(d => d.IdOrderReturnedNavigation).WithMany(p => p.ListItemInOrderReturneds)
                .HasForeignKey(d => d.IdOrderReturned)
                .HasConstraintName("FK__list_item__id_or__02C769E9");
        });

        modelBuilder.Entity<MainAccount>(entity =>
        {
            entity.HasKey(e => e.IdMainAccount).HasName("PK__main_acc__7F19CAE63919D6BB");

            entity.ToTable("main_account");

            entity.HasIndex(e => e.PhoneNumber, "UQ__main_acc__A1936A6BD93DA3A1").IsUnique();

            entity.HasIndex(e => e.Email, "UQ__main_acc__AB6E61642F4254D3").IsUnique();

            entity.HasIndex(e => e.BusinessId, "UQ__main_acc__DC0CC5578B83AA72").IsUnique();

            entity.Property(e => e.IdMainAccount).HasColumnName("id_main_account");
            entity.Property(e => e.AccountArea).HasColumnName("account_area");
            entity.Property(e => e.BusinessId)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("business_ID");
            entity.Property(e => e.Email)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("email");
            entity.Property(e => e.Password)
                .HasMaxLength(99)
                .IsUnicode(false)
                .HasColumnName("password");
            entity.Property(e => e.PhoneNumber)
                .HasMaxLength(14)
                .IsUnicode(false)
                .HasColumnName("phone_number");

            entity.HasOne(d => d.AccountAreaNavigation).WithMany(p => p.MainAccounts)
                .HasForeignKey(d => d.AccountArea)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__main_acco__accou__4222D4EF");
        });

        modelBuilder.Entity<NotificationSetting>(entity =>
        {
            entity.HasKey(e => e.IdShop).HasName("PK__notifica__47D2CA9C94D49CF7");

            entity.ToTable("notification_settings");

            entity.Property(e => e.IdShop)
                .ValueGeneratedNever()
                .HasColumnName("id_shop");
            entity.Property(e => e.ChatMessagesReminder).HasColumnName("Chat_Messages_Reminder");
            entity.Property(e => e.NewsletterNotification).HasColumnName("Newsletter_notification");
            entity.Property(e => e.OrderUpdateNotification).HasColumnName("order_update_notification");
            entity.Property(e => e.PersonalContentNotification).HasColumnName("Personal_Content_Notification");
            entity.Property(e => e.ProductUpdateNotification).HasColumnName("Product_Update_Notification");

            entity.HasOne(d => d.IdShopNavigation).WithOne(p => p.NotificationSetting)
                .HasForeignKey<NotificationSetting>(d => d.IdShop)
                .HasConstraintName("FK__notificat__id_sh__6D0D32F4");
        });

        modelBuilder.Entity<PartnerPlatform>(entity =>
        {
            entity.HasKey(e => e.IdPlatform).HasName("PK__partner___4B55E5B2D9858C8B");

            entity.ToTable("partner_platform");

            entity.Property(e => e.IdPlatform).HasColumnName("id_platform");
            entity.Property(e => e.IdShop).HasColumnName("id_shop");

            entity.HasOne(d => d.IdShopNavigation).WithMany(p => p.PartnerPlatforms)
                .HasForeignKey(d => d.IdShop)
                .HasConstraintName("FK__partner_p__id_sh__5AEE82B9");
        });

        modelBuilder.Entity<PaymentMethod>(entity =>
        {
            entity.HasKey(e => e.IdPaymentMetod).HasName("PK__payment___BEB84E27487C8501");

            entity.ToTable("payment_method");

            entity.Property(e => e.IdPaymentMetod).HasColumnName("id_payment_metod");
            entity.Property(e => e.PaymentMethodName)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("payment_method_name");
        });

        modelBuilder.Entity<PaymentSetting>(entity =>
        {
            entity.HasKey(e => e.IdShop).HasName("PK__payment___47D2CA9C26793875");

            entity.ToTable("payment_settings");

            entity.Property(e => e.IdShop)
                .ValueGeneratedNever()
                .HasColumnName("id_shop");
            entity.Property(e => e.AutomaticWithdrawal).HasColumnName("automatic_withdrawal");
            entity.Property(e => e.PinCode)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("pin_code");

            entity.HasOne(d => d.IdShopNavigation).WithOne(p => p.PaymentSetting)
                .HasForeignKey<PaymentSetting>(d => d.IdShop)
                .HasConstraintName("FK__payment_s__id_sh__5EBF139D");
        });

        modelBuilder.Entity<Product>(entity =>
        {
            entity.HasKey(e => e.IdProduct).HasName("PK__product__BA39E84FC2154122");

            entity.ToTable("product");

            entity.Property(e => e.IdProduct).HasColumnName("id_product");
            entity.Property(e => e.ConditionProduct)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("condition_product");
            entity.Property(e => e.IdCategory).HasColumnName("id_category");
            entity.Property(e => e.IdShop).HasColumnName("id_shop");
            entity.Property(e => e.NameProduct)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("name_product");
            entity.Property(e => e.PreOrder)
                .HasDefaultValue(0)
                .HasColumnName("pre_order");
            entity.Property(e => e.ProductDescription)
                .HasColumnType("text")
                .HasColumnName("product_description");
            entity.Property(e => e.SkuProduct)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("SKU_product");

            entity.HasOne(d => d.IdCategoryNavigation).WithMany(p => p.Products)
                .HasForeignKey(d => d.IdCategory)
                .HasConstraintName("FK__product__id_cate__06CD04F7");

            entity.HasOne(d => d.IdShopNavigation).WithMany(p => p.Products)
                .HasForeignKey(d => d.IdShop)
                .HasConstraintName("FK__product__id_shop__05D8E0BE");
        });

        modelBuilder.Entity<ProductGroup>(entity =>
        {
            entity.HasKey(e => new { e.IdShop, e.IdProduct }).HasName("PK__product___AC715418B01B2B53");

            entity.ToTable("product_group");

            entity.Property(e => e.IdShop).HasColumnName("id_shop");
            entity.Property(e => e.IdProduct).HasColumnName("id_product");
            entity.Property(e => e.NameGroup)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("name_group");

            entity.HasOne(d => d.IdProductNavigation).WithMany(p => p.ProductGroups)
                .HasForeignKey(d => d.IdProduct)
                .HasConstraintName("FK__product_g__id_pr__1CBC4616");

            entity.HasOne(d => d.IdShopNavigation).WithMany(p => p.ProductGroups)
                .HasForeignKey(d => d.IdShop)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__product_g__id_sh__1BC821DD");
        });

        modelBuilder.Entity<ProductReview>(entity =>
        {
            entity.HasKey(e => new { e.IdUser, e.IdShop, e.IdClassificationValue }).HasName("PK__product___93AB8FF3D9318F31");

            entity.ToTable("product_review");

            entity.Property(e => e.IdUser).HasColumnName("id_user");
            entity.Property(e => e.IdShop).HasColumnName("id_shop");
            entity.Property(e => e.IdClassificationValue).HasColumnName("id_classification_value");
            entity.Property(e => e.ShopAnswer)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("shop_answer");
            entity.Property(e => e.Star).HasColumnName("star");
            entity.Property(e => e.UserComment)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("user_comment");

            entity.HasOne(d => d.IdClassificationValueNavigation).WithMany(p => p.ProductReviews)
                .HasForeignKey(d => d.IdClassificationValue)
                .HasConstraintName("FK__product_r__id_cl__0880433F");

            entity.HasOne(d => d.IdShopNavigation).WithMany(p => p.ProductReviews)
                .HasForeignKey(d => d.IdShop)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__product_r__id_sh__078C1F06");

            entity.HasOne(d => d.IdUserNavigation).WithMany(p => p.ProductReviews)
                .HasForeignKey(d => d.IdUser)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__product_r__id_us__0697FACD");
        });

        modelBuilder.Entity<ProductShippingMethod>(entity =>
        {
            entity.HasKey(e => e.IdProductShippingMethod).HasName("PK__product___7ACEDD3BE4606FA6");

            entity.ToTable("product_shipping_method");

            entity.Property(e => e.IdProductShippingMethod).HasColumnName("id_product_shipping_method");
            entity.Property(e => e.IdClassificationValue).HasColumnName("id_classification_value");
            entity.Property(e => e.IdShopShippingMethod).HasColumnName("id_shop_shipping_method");

            entity.HasOne(d => d.IdClassificationValueNavigation).WithMany(p => p.ProductShippingMethods)
                .HasForeignKey(d => d.IdClassificationValue)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__product_s__id_cl__17F790F9");

            entity.HasOne(d => d.IdShopShippingMethodNavigation).WithMany(p => p.ProductShippingMethods)
                .HasForeignKey(d => d.IdShopShippingMethod)
                .HasConstraintName("FK__product_s__id_sh__18EBB532");
        });

        modelBuilder.Entity<ShippingMethod>(entity =>
        {
            entity.HasKey(e => e.IdShippingMethod).HasName("PK__shipping__BC9E2A3A16272B6E");

            entity.ToTable("shipping_method");

            entity.Property(e => e.IdShippingMethod).HasColumnName("id_shipping_method");
            entity.Property(e => e.MethodName)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("method_name");
        });

        modelBuilder.Entity<Shop>(entity =>
        {
            entity.HasKey(e => e.IdShop).HasName("PK__shop__47D2CA9CD7D473D5");

            entity.ToTable("shop");

            entity.HasIndex(e => e.PhoneNumber, "UQ__shop__A1936A6BF651227D").IsUnique();

            entity.HasIndex(e => e.Email, "UQ__shop__AB6E616418278B77").IsUnique();

            entity.HasIndex(e => e.ShopName, "UQ__shop__E5A7FE103023F55D").IsUnique();

            entity.Property(e => e.IdShop).HasColumnName("id_shop");
            entity.Property(e => e.Email)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("email");
            entity.Property(e => e.IdMainAccount).HasColumnName("id_main_account");
            entity.Property(e => e.Password)
                .HasMaxLength(99)
                .IsUnicode(false)
                .HasColumnName("password");
            entity.Property(e => e.PhoneNumber)
                .HasMaxLength(14)
                .IsUnicode(false)
                .HasColumnName("phone_number");
            entity.Property(e => e.ShopAvatarImage)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("shop_avatar_image");
            entity.Property(e => e.ShopName)
                .HasMaxLength(20)
                .HasColumnName("shop_name");
            entity.Property(e => e.Status).HasColumnName("status");

            entity.HasOne(d => d.IdMainAccountNavigation).WithMany(p => p.Shops)
                .HasForeignKey(d => d.IdMainAccount)
                .OnDelete(DeleteBehavior.SetNull)
                .HasConstraintName("FK__shop__id_main_ac__4CA06362");
        });

        modelBuilder.Entity<ShopShippingMethod>(entity =>
        {
            entity.HasKey(e => e.IdShopShippingMethod).HasName("PK__shop_shi__D941E7C16FBCED96");

            entity.ToTable("shop_shipping_method");

            entity.Property(e => e.IdShopShippingMethod).HasColumnName("id_shop_shipping_method");
            entity.Property(e => e.IdShippingMethod).HasColumnName("id_shipping_method");
            entity.Property(e => e.IdShop).HasColumnName("id_shop");

            entity.HasOne(d => d.IdShippingMethodNavigation).WithMany(p => p.ShopShippingMethods)
                .HasForeignKey(d => d.IdShippingMethod)
                .HasConstraintName("FK__shop_ship__id_sh__7C4F7684");

            entity.HasOne(d => d.IdShopNavigation).WithMany(p => p.ShopShippingMethods)
                .HasForeignKey(d => d.IdShop)
                .HasConstraintName("FK__shop_ship__id_sh__7B5B524B");
        });

        modelBuilder.Entity<ShopVoucher>(entity =>
        {
            entity.HasKey(e => e.IdShopVoucher).HasName("PK__shop_vou__3D9082177D73F7A8");

            entity.ToTable("shop_voucher");

            entity.Property(e => e.IdShopVoucher).HasColumnName("id_shop_voucher");
            entity.Property(e => e.DiscountEndDate).HasColumnName("discount_end_date");
            entity.Property(e => e.DiscountPercentage).HasColumnName("discount_percentage");
            entity.Property(e => e.DiscountStartDate).HasColumnName("discount_start_date");
            entity.Property(e => e.MaximumDiscountAmount).HasColumnName("maximum_discount_amount");
            entity.Property(e => e.OfferDescription)
                .HasColumnType("text")
                .HasColumnName("offer_description");
            entity.Property(e => e.ThiếtBị)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("thiết_bị");
            entity.Property(e => e.ĐơnVịVậnChuyển)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("đơn_vị_vận_chuyển");
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.IdUser).HasName("PK__user__D2D14637EF99155F");

            entity.ToTable("user");

            entity.Property(e => e.IdUser).HasColumnName("id_user");
            entity.Property(e => e.AccountName)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("account_name");
            entity.Property(e => e.AvatarImage)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("avatar_image");
            entity.Property(e => e.DateOfBirth).HasColumnName("date_of_birth");
            entity.Property(e => e.Email)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("email");
            entity.Property(e => e.JoiningDate)
                .HasDefaultValueSql("(getdate())")
                .HasColumnName("joining_date");
            entity.Property(e => e.Password)
                .HasMaxLength(99)
                .IsUnicode(false)
                .HasColumnName("password");
            entity.Property(e => e.PhoneNumber)
                .HasMaxLength(15)
                .IsUnicode(false)
                .HasColumnName("phone_number");
            entity.Property(e => e.RealName)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("real_name");
            entity.Property(e => e.Sex)
                .HasMaxLength(1)
                .IsUnicode(false)
                .IsFixedLength()
                .HasColumnName("sex");
        });

        modelBuilder.Entity<UserAddress>(entity =>
        {
            entity.HasKey(e => e.IdUser).HasName("PK__user_add__D2D14637D5389B8F");

            entity.ToTable("user_address");

            entity.Property(e => e.IdUser).HasColumnName("id_user");
            entity.Property(e => e.ApartmentNumber)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("apartment_number");
            entity.Property(e => e.City)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("city");
            entity.Property(e => e.District)
                .HasMaxLength(255)
                .IsUnicode(false);
            entity.Property(e => e.IsDefault)
                .HasDefaultValue(false)
                .HasColumnName("is_default");
            entity.Property(e => e.NameAddress)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("name_address");
            entity.Property(e => e.PhoneNumber)
                .HasMaxLength(15)
                .IsUnicode(false)
                .HasColumnName("phone_number");
            entity.Property(e => e.StreetName)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("street_name");
            entity.Property(e => e.Ward)
                .HasMaxLength(255)
                .IsUnicode(false);
        });

        modelBuilder.Entity<UserIdentificationInformation>(entity =>
        {
            entity.HasKey(e => e.IdUser).HasName("PK__user_ide__D2D146377AE1F08E");

            entity.ToTable("user_identification_information");

            entity.Property(e => e.IdUser)
                .ValueGeneratedNever()
                .HasColumnName("id_user");
            entity.Property(e => e.Cccd)
                .HasMaxLength(12)
                .IsUnicode(false)
                .HasColumnName("cccd");
            entity.Property(e => e.ImageCccdBack)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("image_cccd_back");
            entity.Property(e => e.ImageCccdFront)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("image_cccd_front");
            entity.Property(e => e.ImageSelfie)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("image_selfie");

            entity.HasOne(d => d.IdUserNavigation).WithOne(p => p.UserIdentificationInformation)
                .HasForeignKey<UserIdentificationInformation>(d => d.IdUser)
                .HasConstraintName("FK__user_iden__id_us__236943A5");
        });

        modelBuilder.Entity<UserNotification>(entity =>
        {
            entity.HasKey(e => e.IdUser).HasName("PK__user_not__D2D14637AEAB6DD9");

            entity.ToTable("user_notifications");

            entity.Property(e => e.IdUser)
                .ValueGeneratedNever()
                .HasColumnName("id_user");
            entity.Property(e => e.EmailNotificationSwitch)
                .HasDefaultValue(false)
                .HasColumnName("email_notification_switch");
            entity.Property(e => e.OrderUpdateViaEmail)
                .HasDefaultValue(false)
                .HasColumnName("order_update_via_email");
            entity.Property(e => e.PromotionalEmailNotification)
                .HasDefaultValue(false)
                .HasColumnName("promotional_email_notification");
            entity.Property(e => e.PromotionalSmsNotification)
                .HasDefaultValue(false)
                .HasColumnName("promotional_SMS_notification");
            entity.Property(e => e.SmsNotificationSwitch)
                .HasDefaultValue(false)
                .HasColumnName("SMS_notification_switch");
            entity.Property(e => e.SurveyNotificationViaEmail)
                .HasDefaultValue(false)
                .HasColumnName("survey_notification_via_email");

            entity.HasOne(d => d.IdUserNavigation).WithOne(p => p.UserNotification)
                .HasForeignKey<UserNotification>(d => d.IdUser)
                .HasConstraintName("FK__user_noti__id_us__30C33EC3");
        });

        modelBuilder.Entity<UserOrderCancelled>(entity =>
        {
            entity.HasKey(e => e.IdOrderCancelled).HasName("PK__user_ord__5B6F32F54DE4784E");

            entity.ToTable("user_order_cancelled");

            entity.Property(e => e.IdOrderCancelled).HasColumnName("id_order_cancelled");
            entity.Property(e => e.DeliveryVoucher).HasColumnName("delivery_voucher");
            entity.Property(e => e.IdPaymentMetod).HasColumnName("id_payment_metod");
            entity.Property(e => e.IdUser).HasColumnName("id_user");
            entity.Property(e => e.NoteToSeller)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("note_to_seller");
            entity.Property(e => e.OrderDatetime)
                .HasDefaultValueSql("(getdate())")
                .HasColumnType("datetime")
                .HasColumnName("order_datetime");
            entity.Property(e => e.ShopVoucher).HasColumnName("shop_voucher");
            entity.Property(e => e.WebVoucher).HasColumnName("web_voucher");

            entity.HasOne(d => d.DeliveryVoucherNavigation).WithMany(p => p.UserOrderCancelleds)
                .HasForeignKey(d => d.DeliveryVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__deliv__74794A92");

            entity.HasOne(d => d.IdPaymentMetodNavigation).WithMany(p => p.UserOrderCancelleds)
                .HasForeignKey(d => d.IdPaymentMetod)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__id_pa__719CDDE7");

            entity.HasOne(d => d.IdUserNavigation).WithMany(p => p.UserOrderCancelleds)
                .HasForeignKey(d => d.IdUser)
                .HasConstraintName("FK__user_orde__id_us__70A8B9AE");

            entity.HasOne(d => d.ShopVoucherNavigation).WithMany(p => p.UserOrderCancelleds)
                .HasForeignKey(d => d.ShopVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__shop___72910220");

            entity.HasOne(d => d.WebVoucherNavigation).WithMany(p => p.UserOrderCancelleds)
                .HasForeignKey(d => d.WebVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__web_v__73852659");
        });

        modelBuilder.Entity<UserOrderCompleted>(entity =>
        {
            entity.HasKey(e => e.IdOrderCompleted).HasName("PK__user_ord__E21FC02EE60C7BE0");

            entity.ToTable("user_order_completed");

            entity.Property(e => e.IdOrderCompleted).HasColumnName("id_order_completed");
            entity.Property(e => e.DeliveryVoucher).HasColumnName("delivery_voucher");
            entity.Property(e => e.IdPaymentMetod).HasColumnName("id_payment_metod");
            entity.Property(e => e.IdUser).HasColumnName("id_user");
            entity.Property(e => e.NoteToSeller)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("note_to_seller");
            entity.Property(e => e.OrderDatetime)
                .HasDefaultValueSql("(getdate())")
                .HasColumnType("datetime")
                .HasColumnName("order_datetime");
            entity.Property(e => e.ShopVoucher).HasColumnName("shop_voucher");
            entity.Property(e => e.WebVoucher).HasColumnName("web_voucher");

            entity.HasOne(d => d.DeliveryVoucherNavigation).WithMany(p => p.UserOrderCompleteds)
                .HasForeignKey(d => d.DeliveryVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__deliv__690797E6");

            entity.HasOne(d => d.IdPaymentMetodNavigation).WithMany(p => p.UserOrderCompleteds)
                .HasForeignKey(d => d.IdPaymentMetod)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__id_pa__662B2B3B");

            entity.HasOne(d => d.IdUserNavigation).WithMany(p => p.UserOrderCompleteds)
                .HasForeignKey(d => d.IdUser)
                .HasConstraintName("FK__user_orde__id_us__65370702");

            entity.HasOne(d => d.ShopVoucherNavigation).WithMany(p => p.UserOrderCompleteds)
                .HasForeignKey(d => d.ShopVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__shop___671F4F74");

            entity.HasOne(d => d.WebVoucherNavigation).WithMany(p => p.UserOrderCompleteds)
                .HasForeignKey(d => d.WebVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__web_v__681373AD");
        });

        modelBuilder.Entity<UserOrderInTransit>(entity =>
        {
            entity.HasKey(e => e.IdOrderInTransit).HasName("PK__user_ord__973352450FF7BC22");

            entity.ToTable("user_order_in_transit");

            entity.Property(e => e.IdOrderInTransit).HasColumnName("id_order_in_transit");
            entity.Property(e => e.DeliveryVoucher).HasColumnName("delivery_voucher");
            entity.Property(e => e.IdPaymentMetod).HasColumnName("id_payment_metod");
            entity.Property(e => e.IdUser).HasColumnName("id_user");
            entity.Property(e => e.NoteToSeller)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("note_to_seller");
            entity.Property(e => e.OrderDatetime)
                .HasDefaultValueSql("(getdate())")
                .HasColumnType("datetime")
                .HasColumnName("order_datetime");
            entity.Property(e => e.ShopVoucher).HasColumnName("shop_voucher");
            entity.Property(e => e.WebVoucher).HasColumnName("web_voucher");

            entity.HasOne(d => d.DeliveryVoucherNavigation).WithMany(p => p.UserOrderInTransits)
                .HasForeignKey(d => d.DeliveryVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__deliv__5224328E");

            entity.HasOne(d => d.IdPaymentMetodNavigation).WithMany(p => p.UserOrderInTransits)
                .HasForeignKey(d => d.IdPaymentMetod)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__id_pa__4F47C5E3");

            entity.HasOne(d => d.IdUserNavigation).WithMany(p => p.UserOrderInTransits)
                .HasForeignKey(d => d.IdUser)
                .HasConstraintName("FK__user_orde__id_us__4E53A1AA");

            entity.HasOne(d => d.ShopVoucherNavigation).WithMany(p => p.UserOrderInTransits)
                .HasForeignKey(d => d.ShopVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__shop___503BEA1C");

            entity.HasOne(d => d.WebVoucherNavigation).WithMany(p => p.UserOrderInTransits)
                .HasForeignKey(d => d.WebVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__web_v__51300E55");
        });

        modelBuilder.Entity<UserOrderPendingPayment>(entity =>
        {
            entity.HasKey(e => e.IdOrderPendingPayment).HasName("PK__user_ord__5C89280716D697AA");

            entity.ToTable("user_order_pending_payment");

            entity.Property(e => e.IdOrderPendingPayment).HasColumnName("id_order_pending_payment");
            entity.Property(e => e.IdDeliveryVoucher).HasColumnName("id_delivery_voucher");
            entity.Property(e => e.IdPaymentMetod).HasColumnName("id_payment_metod");
            entity.Property(e => e.IdShopVoucher).HasColumnName("id_shop_voucher");
            entity.Property(e => e.IdUser).HasColumnName("id_user");
            entity.Property(e => e.IdWebVoucher).HasColumnName("id_web_voucher");
            entity.Property(e => e.NoteToSeller)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("note_to_seller");
            entity.Property(e => e.OrderDatetime)
                .HasDefaultValueSql("(getdate())")
                .HasColumnType("datetime")
                .HasColumnName("order_datetime");

            entity.HasOne(d => d.IdDeliveryVoucherNavigation).WithMany(p => p.UserOrderPendingPayments)
                .HasForeignKey(d => d.IdDeliveryVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__id_de__46B27FE2");

            entity.HasOne(d => d.IdPaymentMetodNavigation).WithMany(p => p.UserOrderPendingPayments)
                .HasForeignKey(d => d.IdPaymentMetod)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__id_pa__43D61337");

            entity.HasOne(d => d.IdShopVoucherNavigation).WithMany(p => p.UserOrderPendingPayments)
                .HasForeignKey(d => d.IdShopVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__id_sh__44CA3770");

            entity.HasOne(d => d.IdUserNavigation).WithMany(p => p.UserOrderPendingPayments)
                .HasForeignKey(d => d.IdUser)
                .HasConstraintName("FK__user_orde__id_us__42E1EEFE");

            entity.HasOne(d => d.IdWebVoucherNavigation).WithMany(p => p.UserOrderPendingPayments)
                .HasForeignKey(d => d.IdWebVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__id_we__45BE5BA9");
        });

        modelBuilder.Entity<UserOrderPendingShipment>(entity =>
        {
            entity.HasKey(e => e.IdOrderPendingShipment).HasName("PK__user_ord__683AA79A3406C7AA");

            entity.ToTable("user_order_pending_shipment");

            entity.Property(e => e.IdOrderPendingShipment).HasColumnName("id_order_pending_shipment");
            entity.Property(e => e.DeliveryVoucher).HasColumnName("delivery_voucher");
            entity.Property(e => e.IdPaymentMetod).HasColumnName("id_payment_metod");
            entity.Property(e => e.IdUser).HasColumnName("id_user");
            entity.Property(e => e.NoteToSeller)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("note_to_seller");
            entity.Property(e => e.OrderDatetime)
                .HasDefaultValueSql("(getdate())")
                .HasColumnType("datetime")
                .HasColumnName("order_datetime");
            entity.Property(e => e.ShopVoucher).HasColumnName("shop_voucher");
            entity.Property(e => e.WebVoucher).HasColumnName("web_voucher");

            entity.HasOne(d => d.DeliveryVoucherNavigation).WithMany(p => p.UserOrderPendingShipments)
                .HasForeignKey(d => d.DeliveryVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__deliv__5D95E53A");

            entity.HasOne(d => d.IdPaymentMetodNavigation).WithMany(p => p.UserOrderPendingShipments)
                .HasForeignKey(d => d.IdPaymentMetod)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__id_pa__5AB9788F");

            entity.HasOne(d => d.IdUserNavigation).WithMany(p => p.UserOrderPendingShipments)
                .HasForeignKey(d => d.IdUser)
                .HasConstraintName("FK__user_orde__id_us__59C55456");

            entity.HasOne(d => d.ShopVoucherNavigation).WithMany(p => p.UserOrderPendingShipments)
                .HasForeignKey(d => d.ShopVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__shop___5BAD9CC8");

            entity.HasOne(d => d.WebVoucherNavigation).WithMany(p => p.UserOrderPendingShipments)
                .HasForeignKey(d => d.WebVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__web_v__5CA1C101");
        });

        modelBuilder.Entity<UserOrderReturned>(entity =>
        {
            entity.HasKey(e => e.IdOrderReturned).HasName("PK__user_ord__47B9EB7108AC2CA8");

            entity.ToTable("user_order_returned");

            entity.Property(e => e.IdOrderReturned).HasColumnName("id_order_returned");
            entity.Property(e => e.DeliveryVoucher).HasColumnName("delivery_voucher");
            entity.Property(e => e.IdPaymentMetod).HasColumnName("id_payment_metod");
            entity.Property(e => e.IdUser).HasColumnName("id_user");
            entity.Property(e => e.NoteToSeller)
                .HasMaxLength(500)
                .IsUnicode(false)
                .HasColumnName("note_to_seller");
            entity.Property(e => e.OrderDatetime)
                .HasDefaultValueSql("(getdate())")
                .HasColumnType("datetime")
                .HasColumnName("order_datetime");
            entity.Property(e => e.ShopVoucher).HasColumnName("shop_voucher");
            entity.Property(e => e.WebVoucher).HasColumnName("web_voucher");

            entity.HasOne(d => d.DeliveryVoucherNavigation).WithMany(p => p.UserOrderReturneds)
                .HasForeignKey(d => d.DeliveryVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__deliv__7FEAFD3E");

            entity.HasOne(d => d.IdPaymentMetodNavigation).WithMany(p => p.UserOrderReturneds)
                .HasForeignKey(d => d.IdPaymentMetod)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__id_pa__7D0E9093");

            entity.HasOne(d => d.IdUserNavigation).WithMany(p => p.UserOrderReturneds)
                .HasForeignKey(d => d.IdUser)
                .HasConstraintName("FK__user_orde__id_us__7C1A6C5A");

            entity.HasOne(d => d.ShopVoucherNavigation).WithMany(p => p.UserOrderReturneds)
                .HasForeignKey(d => d.ShopVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__shop___7E02B4CC");

            entity.HasOne(d => d.WebVoucherNavigation).WithMany(p => p.UserOrderReturneds)
                .HasForeignKey(d => d.WebVoucher)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__user_orde__web_v__7EF6D905");
        });

        modelBuilder.Entity<UserSpending>(entity =>
        {
            entity.HasKey(e => e.IdUser).HasName("PK__user_spe__D2D14637898F7F5F");

            entity.ToTable("user_spending");

            entity.Property(e => e.IdUser)
                .ValueGeneratedNever()
                .HasColumnName("id_user");
            entity.Property(e => e.OrderNumber)
                .HasDefaultValue(0)
                .HasColumnName("order_number");
            entity.Property(e => e.Spending)
                .HasDefaultValue(0L)
                .HasColumnName("spending");

            entity.HasOne(d => d.IdUserNavigation).WithOne(p => p.UserSpending)
                .HasForeignKey<UserSpending>(d => d.IdUser)
                .HasConstraintName("FK__user_spen__id_us__282DF8C2");
        });

        modelBuilder.Entity<UserWallet>(entity =>
        {
            entity.HasKey(e => e.IdUser).HasName("PK__user_wal__D2D146373A9090CB");

            entity.ToTable("user_wallet");

            entity.Property(e => e.IdUser)
                .ValueGeneratedNever()
                .HasColumnName("id_user");
            entity.Property(e => e.UserWallet1)
                .HasDefaultValue(0)
                .HasColumnName("user_wallet");

            entity.HasOne(d => d.IdUserNavigation).WithOne(p => p.UserWallet)
                .HasForeignKey<UserWallet>(d => d.IdUser)
                .HasConstraintName("FK__user_wall__id_us__208CD6FA");
        });

        modelBuilder.Entity<WebVoucher>(entity =>
        {
            entity.HasKey(e => e.IdWebVoucher).HasName("PK__web_vouc__78D4501D2EEDDDD8");

            entity.ToTable("web_voucher");

            entity.Property(e => e.IdWebVoucher).HasColumnName("id_web_voucher");
            entity.Property(e => e.DiscountEndDate).HasColumnName("discount_end_date");
            entity.Property(e => e.DiscountPercentage).HasColumnName("discount_percentage");
            entity.Property(e => e.DiscountStartDate).HasColumnName("discount_start_date");
            entity.Property(e => e.MaximumDiscountAmount).HasColumnName("maximum_discount_amount");
            entity.Property(e => e.OfferDescription)
                .HasColumnType("text")
                .HasColumnName("offer_description");
            entity.Property(e => e.ThiếtBị)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("thiết_bị");
            entity.Property(e => e.ĐơnVịVậnChuyển)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("đơn_vị_vận_chuyển");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}

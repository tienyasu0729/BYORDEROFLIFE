using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class Shop
{
    public int IdShop { get; set; }

    public string PhoneNumber { get; set; } = null!;

    public string Password { get; set; } = null!;

    public string Email { get; set; } = null!;

    public string ShopName { get; set; } = null!;

    public string? ShopAvatarImage { get; set; }

    public bool Status { get; set; }

    public int? IdMainAccount { get; set; }

    public virtual ICollection<BlockedUser> BlockedUsers { get; set; } = new List<BlockedUser>();

    public virtual BusinessInformation? BusinessInformation { get; set; }

    public virtual ChatSetting? ChatSetting { get; set; }

    public virtual MainAccount? IdMainAccountNavigation { get; set; }

    public virtual IdentificationShop? IdentificationShop { get; set; }

    public virtual ICollection<ListEmailToReceiveElectronicInvoice> ListEmailToReceiveElectronicInvoices { get; set; } = new List<ListEmailToReceiveElectronicInvoice>();

    public virtual NotificationSetting? NotificationSetting { get; set; }

    public virtual ICollection<PartnerPlatform> PartnerPlatforms { get; set; } = new List<PartnerPlatform>();

    public virtual PaymentSetting? PaymentSetting { get; set; }

    public virtual ICollection<ProductGroup> ProductGroups { get; set; } = new List<ProductGroup>();

    public virtual ICollection<ProductReview> ProductReviews { get; set; } = new List<ProductReview>();

    public virtual ICollection<Product> Products { get; set; } = new List<Product>();

    public virtual ICollection<ShopShippingMethod> ShopShippingMethods { get; set; } = new List<ShopShippingMethod>();
}

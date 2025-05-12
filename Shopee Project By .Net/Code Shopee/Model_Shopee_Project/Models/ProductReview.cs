using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class ProductReview
{
    public int IdUser { get; set; }

    public int IdShop { get; set; }

    public int IdClassificationValue { get; set; }

    public string UserComment { get; set; } = null!;

    public string? ShopAnswer { get; set; }

    public int Star { get; set; }

    public virtual ClassificationValue IdClassificationValueNavigation { get; set; } = null!;

    public virtual Shop IdShopNavigation { get; set; } = null!;

    public virtual User IdUserNavigation { get; set; } = null!;
}

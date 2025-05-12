using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class ShopShippingMethod
{
    public int IdShopShippingMethod { get; set; }

    public int IdShop { get; set; }

    public int IdShippingMethod { get; set; }

    public virtual ShippingMethod IdShippingMethodNavigation { get; set; } = null!;

    public virtual Shop IdShopNavigation { get; set; } = null!;

    public virtual ICollection<ProductShippingMethod> ProductShippingMethods { get; set; } = new List<ProductShippingMethod>();
}

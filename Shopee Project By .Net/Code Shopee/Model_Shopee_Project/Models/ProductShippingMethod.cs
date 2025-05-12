using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class ProductShippingMethod
{
    public int IdProductShippingMethod { get; set; }

    public int IdClassificationValue { get; set; }

    public int IdShopShippingMethod { get; set; }

    public virtual ClassificationValue IdClassificationValueNavigation { get; set; } = null!;

    public virtual ShopShippingMethod IdShopShippingMethodNavigation { get; set; } = null!;
}

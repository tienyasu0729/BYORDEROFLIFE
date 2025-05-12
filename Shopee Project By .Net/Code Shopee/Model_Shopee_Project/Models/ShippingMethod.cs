using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class ShippingMethod
{
    public int IdShippingMethod { get; set; }

    public string MethodName { get; set; } = null!;

    public virtual ICollection<ShopShippingMethod> ShopShippingMethods { get; set; } = new List<ShopShippingMethod>();
}

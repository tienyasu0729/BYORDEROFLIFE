using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class PartnerPlatform
{
    public int IdPlatform { get; set; }

    public int IdShop { get; set; }

    public virtual Shop IdShopNavigation { get; set; } = null!;
}

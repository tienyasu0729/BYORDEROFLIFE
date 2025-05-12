using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class BlockedUser
{
    public int IdShop { get; set; }

    public int IdUser { get; set; }

    public DateTime? BlockDateTime { get; set; }

    public virtual Shop IdShopNavigation { get; set; } = null!;

    public virtual User IdUserNavigation { get; set; } = null!;
}

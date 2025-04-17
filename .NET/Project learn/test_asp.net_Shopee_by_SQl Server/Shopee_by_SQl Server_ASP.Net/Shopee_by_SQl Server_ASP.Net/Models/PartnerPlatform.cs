using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class PartnerPlatform
{
    public int IdPlatform { get; set; }

    public int IdShop { get; set; }

    public virtual Shop IdShopNavigation { get; set; } = null!;
}

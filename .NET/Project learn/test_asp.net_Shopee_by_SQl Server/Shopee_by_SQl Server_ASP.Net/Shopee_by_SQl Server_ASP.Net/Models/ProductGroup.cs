using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class ProductGroup
{
    public int IdShop { get; set; }

    public int IdProduct { get; set; }

    public string? NameGroup { get; set; }

    public virtual Product IdProductNavigation { get; set; } = null!;

    public virtual Shop IdShopNavigation { get; set; } = null!;
}

using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class ListItemInOrderInTransit
{
    public int IdOrderInTransit { get; set; }

    public int IdClassificationValue { get; set; }

    public int ProductQuantity { get; set; }

    public virtual ClassificationValue IdClassificationValueNavigation { get; set; } = null!;

    public virtual UserOrderInTransit IdOrderInTransitNavigation { get; set; } = null!;
}

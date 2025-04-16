using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class ListItemInOrderCancelled
{
    public int IdListOrderCancelled { get; set; }

    public int IdOrderCancelled { get; set; }

    public int? IdClassificationValue { get; set; }

    public int ProductQuantity { get; set; }

    public string? ProductDetailsDeleted { get; set; }

    public virtual ClassificationValue? IdClassificationValueNavigation { get; set; }

    public virtual UserOrderCancelled IdOrderCancelledNavigation { get; set; } = null!;
}

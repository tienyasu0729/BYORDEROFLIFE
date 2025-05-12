using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class ListItemInOrderCompleted
{
    public int IdListOrderCompleted { get; set; }

    public int IdOrderCompleted { get; set; }

    public int? IdClassificationValue { get; set; }

    public int ProductQuantity { get; set; }

    public string? ProductDetailsDeleted { get; set; }

    public virtual ClassificationValue? IdClassificationValueNavigation { get; set; }

    public virtual UserOrderCompleted IdOrderCompletedNavigation { get; set; } = null!;
}

using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class ListItemInOrderReturned
{
    public int IdListOrderReturned { get; set; }

    public int IdOrderReturned { get; set; }

    public int? IdClassificationValue { get; set; }

    public int ProductQuantity { get; set; }

    public string? ProductDetailsDeleted { get; set; }

    public virtual ClassificationValue? IdClassificationValueNavigation { get; set; }

    public virtual UserOrderReturned IdOrderReturnedNavigation { get; set; } = null!;
}

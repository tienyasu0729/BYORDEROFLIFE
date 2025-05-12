using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class ListItemInOrderPendingShipment
{
    public int IdListPendingShipment { get; set; }

    public int IdOrderPendingShipment { get; set; }

    public int? IdClassificationValue { get; set; }

    public int ProductQuantity { get; set; }

    public string? ProductDetailsDeleted { get; set; }

    public virtual ClassificationValue? IdClassificationValueNavigation { get; set; }

    public virtual UserOrderPendingShipment IdOrderPendingShipmentNavigation { get; set; } = null!;
}

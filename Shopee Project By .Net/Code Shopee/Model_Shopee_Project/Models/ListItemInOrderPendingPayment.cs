using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class ListItemInOrderPendingPayment
{
    public int IdOrderPendingPayment { get; set; }

    public int IdClassificationValue { get; set; }

    public int ProductQuantity { get; set; }

    public virtual ClassificationValue IdClassificationValueNavigation { get; set; } = null!;

    public virtual UserOrderPendingPayment IdOrderPendingPaymentNavigation { get; set; } = null!;
}

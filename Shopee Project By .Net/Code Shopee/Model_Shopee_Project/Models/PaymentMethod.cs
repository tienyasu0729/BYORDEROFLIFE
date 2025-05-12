using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class PaymentMethod
{
    public int IdPaymentMetod { get; set; }

    public string PaymentMethodName { get; set; } = null!;

    public virtual ICollection<UserOrderCancelled> UserOrderCancelleds { get; set; } = new List<UserOrderCancelled>();

    public virtual ICollection<UserOrderCompleted> UserOrderCompleteds { get; set; } = new List<UserOrderCompleted>();

    public virtual ICollection<UserOrderInTransit> UserOrderInTransits { get; set; } = new List<UserOrderInTransit>();

    public virtual ICollection<UserOrderPendingPayment> UserOrderPendingPayments { get; set; } = new List<UserOrderPendingPayment>();

    public virtual ICollection<UserOrderPendingShipment> UserOrderPendingShipments { get; set; } = new List<UserOrderPendingShipment>();

    public virtual ICollection<UserOrderReturned> UserOrderReturneds { get; set; } = new List<UserOrderReturned>();
}

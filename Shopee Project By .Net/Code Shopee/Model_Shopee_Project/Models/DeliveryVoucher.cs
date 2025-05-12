using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class DeliveryVoucher
{
    public int IdDeliveryVoucher { get; set; }

    public double DiscountPercentage { get; set; }

    public int MaximumDiscountAmount { get; set; }

    public DateOnly DiscountStartDate { get; set; }

    public DateOnly DiscountEndDate { get; set; }

    public string OfferDescription { get; set; } = null!;

    public string ĐơnVịVậnChuyển { get; set; } = null!;

    public string ThiếtBị { get; set; } = null!;

    public virtual ICollection<UserOrderCancelled> UserOrderCancelleds { get; set; } = new List<UserOrderCancelled>();

    public virtual ICollection<UserOrderCompleted> UserOrderCompleteds { get; set; } = new List<UserOrderCompleted>();

    public virtual ICollection<UserOrderInTransit> UserOrderInTransits { get; set; } = new List<UserOrderInTransit>();

    public virtual ICollection<UserOrderPendingPayment> UserOrderPendingPayments { get; set; } = new List<UserOrderPendingPayment>();

    public virtual ICollection<UserOrderPendingShipment> UserOrderPendingShipments { get; set; } = new List<UserOrderPendingShipment>();

    public virtual ICollection<UserOrderReturned> UserOrderReturneds { get; set; } = new List<UserOrderReturned>();
}

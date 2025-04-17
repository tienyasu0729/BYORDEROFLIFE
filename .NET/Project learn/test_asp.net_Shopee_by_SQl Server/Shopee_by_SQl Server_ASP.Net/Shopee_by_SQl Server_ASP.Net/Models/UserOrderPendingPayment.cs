using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class UserOrderPendingPayment
{
    public int IdOrderPendingPayment { get; set; }

    public int IdUser { get; set; }

    public int IdPaymentMetod { get; set; }

    public int IdShopVoucher { get; set; }

    public int IdWebVoucher { get; set; }

    public int IdDeliveryVoucher { get; set; }

    public string? NoteToSeller { get; set; }

    public DateTime? OrderDatetime { get; set; }

    public virtual DeliveryVoucher IdDeliveryVoucherNavigation { get; set; } = null!;

    public virtual PaymentMethod IdPaymentMetodNavigation { get; set; } = null!;

    public virtual ShopVoucher IdShopVoucherNavigation { get; set; } = null!;

    public virtual User IdUserNavigation { get; set; } = null!;

    public virtual WebVoucher IdWebVoucherNavigation { get; set; } = null!;

    public virtual ICollection<ListItemInOrderPendingPayment> ListItemInOrderPendingPayments { get; set; } = new List<ListItemInOrderPendingPayment>();
}

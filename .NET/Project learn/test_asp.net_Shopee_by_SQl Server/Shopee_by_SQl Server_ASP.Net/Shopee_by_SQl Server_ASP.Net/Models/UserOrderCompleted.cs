using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class UserOrderCompleted
{
    public int IdOrderCompleted { get; set; }

    public int IdUser { get; set; }

    public int IdPaymentMetod { get; set; }

    public int ShopVoucher { get; set; }

    public int WebVoucher { get; set; }

    public int DeliveryVoucher { get; set; }

    public string? NoteToSeller { get; set; }

    public DateTime? OrderDatetime { get; set; }

    public virtual DeliveryVoucher DeliveryVoucherNavigation { get; set; } = null!;

    public virtual PaymentMethod IdPaymentMetodNavigation { get; set; } = null!;

    public virtual User IdUserNavigation { get; set; } = null!;

    public virtual ICollection<ListItemInOrderCompleted> ListItemInOrderCompleteds { get; set; } = new List<ListItemInOrderCompleted>();

    public virtual ShopVoucher ShopVoucherNavigation { get; set; } = null!;

    public virtual WebVoucher WebVoucherNavigation { get; set; } = null!;
}

using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class CoinHistory
{
    public int IdCoinHistory { get; set; }

    public int? NumberCoin { get; set; }

    public string NotificationSubject { get; set; } = null!;

    public DateOnly? NotificationReceiptDate { get; set; }
}

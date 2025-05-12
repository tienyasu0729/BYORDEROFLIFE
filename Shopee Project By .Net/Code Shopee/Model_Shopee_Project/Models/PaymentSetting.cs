using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class PaymentSetting
{
    public int IdShop { get; set; }

    public bool AutomaticWithdrawal { get; set; }

    public string? PinCode { get; set; }

    public virtual Shop IdShopNavigation { get; set; } = null!;
}

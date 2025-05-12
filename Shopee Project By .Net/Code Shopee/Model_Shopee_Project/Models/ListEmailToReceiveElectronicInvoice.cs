using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class ListEmailToReceiveElectronicInvoice
{
    public int IdEmailReceiveElectronic { get; set; }

    public string EmailAddress { get; set; } = null!;

    public int IdShop { get; set; }

    public virtual Shop IdShopNavigation { get; set; } = null!;
}

using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class BusinessInformation
{
    public int IdShop { get; set; }

    public string BusinessType { get; set; } = null!;

    public string AddressToTakeProduct { get; set; } = null!;

    public string RegisteredBusinessAddress { get; set; } = null!;

    public string? TaxIdentificationNumber { get; set; }

    public virtual Shop IdShopNavigation { get; set; } = null!;
}

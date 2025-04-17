using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class IdentificationShop
{
    public int IdShop { get; set; }

    public int FormOfIdentification { get; set; }

    public string IdentificationNumber { get; set; } = null!;

    public string IdentificationName { get; set; } = null!;

    public string ImageIdentificationFront { get; set; } = null!;

    public string ImageIdentificationBack { get; set; } = null!;

    public virtual FormOfIdentification FormOfIdentificationNavigation { get; set; } = null!;

    public virtual Shop IdShopNavigation { get; set; } = null!;
}

using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class FormOfIdentification
{
    public int FormId { get; set; }

    public string NameForm { get; set; } = null!;

    public virtual ICollection<IdentificationShop> IdentificationShops { get; set; } = new List<IdentificationShop>();
}

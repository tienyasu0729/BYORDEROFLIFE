using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class Area
{
    public int AreaId { get; set; }

    public string NameArea { get; set; } = null!;

    public virtual ICollection<MainAccount> MainAccounts { get; set; } = new List<MainAccount>();
}

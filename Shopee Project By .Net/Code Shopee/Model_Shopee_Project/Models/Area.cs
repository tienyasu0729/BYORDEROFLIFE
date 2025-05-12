using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class Area
{
    public int AreaId { get; set; }

    public string NameArea { get; set; } = null!;

    public virtual ICollection<MainAccount> MainAccounts { get; set; } = new List<MainAccount>();
}

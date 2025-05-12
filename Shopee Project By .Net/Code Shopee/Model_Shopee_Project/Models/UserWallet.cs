using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class UserWallet
{
    public int IdUser { get; set; }

    public int? UserWallet1 { get; set; }

    public virtual User IdUserNavigation { get; set; } = null!;
}

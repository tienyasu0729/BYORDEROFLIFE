using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class UserWallet
{
    public int IdUser { get; set; }

    public int? UserWallet1 { get; set; }

    public virtual User IdUserNavigation { get; set; } = null!;
}

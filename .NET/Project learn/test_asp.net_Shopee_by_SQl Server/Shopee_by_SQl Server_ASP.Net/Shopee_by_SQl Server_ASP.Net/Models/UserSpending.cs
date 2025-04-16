using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class UserSpending
{
    public int IdUser { get; set; }

    public int? OrderNumber { get; set; }

    public long? Spending { get; set; }

    public virtual User IdUserNavigation { get; set; } = null!;
}

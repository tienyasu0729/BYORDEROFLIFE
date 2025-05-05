using System;
using System.Collections.Generic;

namespace Tien_Chill_Project.Models;

public partial class OrderItem
{
    public int? OrderId { get; set; }

    public int? ProductId { get; set; }

    public int? PcId { get; set; }

    public virtual Order? Order { get; set; }

    public virtual Pc? Pc { get; set; }

    public virtual Product? Product { get; set; }
}

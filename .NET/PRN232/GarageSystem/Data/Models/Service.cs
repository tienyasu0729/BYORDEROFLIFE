using System;
using System.Collections.Generic;

namespace Data.Models;

public partial class Service
{
    public int ServiceId { get; set; }

    public string? Description { get; set; }

    public decimal Price { get; set; }

    public virtual ICollection<ServiceOrder> ServiceOrders { get; set; } = new List<ServiceOrder>();
}

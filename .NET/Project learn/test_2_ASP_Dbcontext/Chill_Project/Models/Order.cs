using System;
using System.Collections.Generic;

namespace Chill_Project.Models;

public partial class Order
{
    public int OrderId { get; set; }

    public DateOnly OrderDate { get; set; }

    public decimal TotalPrice { get; set; }

    public string? OrderStatus { get; set; }

    public int UserId { get; set; }

    public virtual User User { get; set; } = null!;
}

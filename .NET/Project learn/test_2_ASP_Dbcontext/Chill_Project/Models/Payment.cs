using System;
using System.Collections.Generic;

namespace Chill_Project.Models;

public partial class Payment
{
    public int PaymentId { get; set; }

    public DateOnly PaymentDate { get; set; }

    public int CartId { get; set; }

    public int UserId { get; set; }

    public virtual ShoppingCart Cart { get; set; } = null!;

    public virtual User User { get; set; } = null!;
}

using System;
using System.Collections.Generic;

namespace Chill_Computer.Models;

public partial class Pc
{
    public int PcId { get; set; }

    public decimal Price { get; set; }

    public virtual ICollection<CartItem> CartItems { get; set; } = new List<CartItem>();
}

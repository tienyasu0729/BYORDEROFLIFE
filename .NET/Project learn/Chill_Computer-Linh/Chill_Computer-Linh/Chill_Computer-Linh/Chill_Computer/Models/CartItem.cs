using System;
using System.Collections.Generic;

namespace Chill_Computer.Models;

public partial class CartItem
{
    public int CartItemId { get; set; }

    public int? ProductId { get; set; }

    public int? CartId { get; set; }

    public int? PcId { get; set; }

    public int ItemQuantity { get; set; }

    public virtual ShoppingCart? Cart { get; set; }

    public virtual Pc? Pc { get; set; }

    public virtual Product? Product { get; set; }
}

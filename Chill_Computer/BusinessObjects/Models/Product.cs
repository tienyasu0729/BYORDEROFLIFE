using System;
using System.Collections.Generic;

namespace BusinessObjects.Models;

public partial class Product
{
    public int ProductId { get; set; }

    public string ProductName { get; set; } = null!;

    public int Price { get; set; }

    public string? FormattedPrice { get; set; }

    public int Stock { get; set; }

    public string? Img1 { get; set; }

    public string? Img2 { get; set; }

    public string? Img3 { get; set; }

    public string? Color { get; set; }

    public string? Version { get; set; }

    public int? TypeId { get; set; }

    public int? BrandId { get; set; }

    public int? SeriesId { get; set; }

    public virtual Brand? Brand { get; set; }

    public virtual ICollection<CartItem> CartItems { get; set; } = new List<CartItem>();

    public virtual ICollection<Review> Reviews { get; set; } = new List<Review>();

    public virtual Series? Series { get; set; }

    public virtual ProductType? Type { get; set; }
}

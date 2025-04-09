using System;
using System.Collections.Generic;

namespace Chill_Computer.Models;

public partial class Series
{
    public int SeriesId { get; set; }

    public string SeriesName { get; set; } = null!;

    public int BrandId { get; set; }

    public virtual Brand Brand { get; set; } = null!;

    public virtual ICollection<Product> Products { get; set; } = new List<Product>();
}

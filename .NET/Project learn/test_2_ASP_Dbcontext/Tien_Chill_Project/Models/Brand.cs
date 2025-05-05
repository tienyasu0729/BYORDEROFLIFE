using System;
using System.Collections.Generic;

namespace Tien_Chill_Project.Models;

public partial class Brand
{
    public int BrandId { get; set; }

    public string BrandName { get; set; } = null!;

    public virtual ICollection<Product> Products { get; set; } = new List<Product>();

    public virtual ICollection<Series> Series { get; set; } = new List<Series>();
}

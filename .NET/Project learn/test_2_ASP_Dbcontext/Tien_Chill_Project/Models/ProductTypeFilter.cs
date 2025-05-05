using System;
using System.Collections.Generic;

namespace Tien_Chill_Project.Models;

public partial class ProductTypeFilter
{
    public int FilterId { get; set; }

    public string FilterName { get; set; } = null!;

    public string? FilterTag { get; set; }

    public int? TypeId { get; set; }

    public virtual ICollection<FilterCategory> FilterCategories { get; set; } = new List<FilterCategory>();

    public virtual ProductType? Type { get; set; }
}

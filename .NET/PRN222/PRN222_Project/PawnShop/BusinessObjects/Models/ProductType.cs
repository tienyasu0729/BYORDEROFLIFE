using System;
using System.Collections.Generic;

namespace BusinessObjects.Models;

public partial class ProductType
{
    public int TypeId { get; set; }

    public string TypeName { get; set; } = null!;

    public string TypeImgs { get; set; } = null!;

    public virtual ICollection<Attribute> Attributes { get; set; } = new List<Attribute>();

    public virtual ICollection<ProductTypeFilter> ProductTypeFilters { get; set; } = new List<ProductTypeFilter>();

    public virtual ICollection<Product> Products { get; set; } = new List<Product>();
}

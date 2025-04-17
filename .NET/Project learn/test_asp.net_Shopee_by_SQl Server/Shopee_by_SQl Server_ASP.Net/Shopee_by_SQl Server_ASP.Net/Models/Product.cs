using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class Product
{
    public int IdProduct { get; set; }

    public string NameProduct { get; set; } = null!;

    public string ProductDescription { get; set; } = null!;

    public int? PreOrder { get; set; }

    public string ConditionProduct { get; set; } = null!;

    public string? SkuProduct { get; set; }

    public int? IdCategory { get; set; }

    public int IdShop { get; set; }

    public virtual ICollection<CategoryValue> CategoryValues { get; set; } = new List<CategoryValue>();

    public virtual ICollection<Classification> Classifications { get; set; } = new List<Classification>();

    public virtual Category? IdCategoryNavigation { get; set; }

    public virtual Shop IdShopNavigation { get; set; } = null!;

    public virtual ImageAndShortVideoProduct? ImageAndShortVideoProduct { get; set; }

    public virtual ICollection<ProductGroup> ProductGroups { get; set; } = new List<ProductGroup>();
}

using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class CategoryValue
{
    public int IdProduct { get; set; }

    public int IdCategoryAttribute { get; set; }

    public string? AttributeValue { get; set; }

    public virtual CategoryAttribute IdCategoryAttributeNavigation { get; set; } = null!;

    public virtual Product IdProductNavigation { get; set; } = null!;
}

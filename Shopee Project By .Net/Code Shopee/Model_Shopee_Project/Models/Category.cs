using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class Category
{
    public int IdCategory { get; set; }

    public string NameCategory { get; set; } = null!;

    public int? IdParent { get; set; }

    public virtual ICollection<CategoryAttribute> CategoryAttributes { get; set; } = new List<CategoryAttribute>();

    public virtual Category? IdParentNavigation { get; set; }

    public virtual ICollection<Category> InverseIdParentNavigation { get; set; } = new List<Category>();

    public virtual ICollection<Product> Products { get; set; } = new List<Product>();
}

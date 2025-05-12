using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class CategoryAttribute
{
    public int IdCategoryAttribute { get; set; }

    public string NameAttribute { get; set; } = null!;

    public int IdCategory { get; set; }

    public virtual ICollection<CategoryValue> CategoryValues { get; set; } = new List<CategoryValue>();

    public virtual Category IdCategoryNavigation { get; set; } = null!;
}

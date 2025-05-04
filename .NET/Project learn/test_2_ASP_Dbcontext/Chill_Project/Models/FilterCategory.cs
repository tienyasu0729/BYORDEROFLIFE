using System;
using System.Collections.Generic;

namespace Chill_Project.Models;

public partial class FilterCategory
{
    public int CategoryId { get; set; }

    public string CategoryName { get; set; } = null!;

    public int? ParentId { get; set; }

    public int? FilterId { get; set; }

    public virtual ProductTypeFilter? Filter { get; set; }

    public virtual ICollection<FilterCategory> InverseParent { get; set; } = new List<FilterCategory>();

    public virtual FilterCategory? Parent { get; set; }
}

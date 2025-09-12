using System;
using System.Collections.Generic;

namespace BusinessObjects.Models;

public partial class NewsCategory
{
    public int CategoryId { get; set; }

    public string CategoryName { get; set; } = null!;

    public int? ParentId { get; set; }

    public virtual ICollection<NewsCategory> InverseParent { get; set; } = new List<NewsCategory>();

    public virtual ICollection<News> News { get; set; } = new List<News>();

    public virtual NewsCategory? Parent { get; set; }
}

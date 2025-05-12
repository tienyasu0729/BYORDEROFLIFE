using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class Classification
{
    public int IdClassification { get; set; }

    public string ClassificationName { get; set; } = null!;

    public int IdProduct { get; set; }

    public virtual ICollection<ClassificationValue> ClassificationValues { get; set; } = new List<ClassificationValue>();

    public virtual Product IdProductNavigation { get; set; } = null!;
}

using System;
using System.Collections.Generic;

namespace Chill_Project.Models;

public partial class Attribute
{
    public int AttributeId { get; set; }

    public string AttributeName { get; set; } = null!;

    public int? TypeId { get; set; }

    public int? ParentId { get; set; }

    public virtual ICollection<Attribute> InverseParent { get; set; } = new List<Attribute>();

    public virtual Attribute? Parent { get; set; }

    public virtual ProductType? Type { get; set; }
}

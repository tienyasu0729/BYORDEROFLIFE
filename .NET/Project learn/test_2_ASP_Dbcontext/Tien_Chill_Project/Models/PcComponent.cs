using System;
using System.Collections.Generic;

namespace Tien_Chill_Project.Models;

public partial class PcComponent
{
    public int ProductId { get; set; }

    public int PcId { get; set; }

    public virtual Pc Pc { get; set; } = null!;

    public virtual Product Product { get; set; } = null!;
}

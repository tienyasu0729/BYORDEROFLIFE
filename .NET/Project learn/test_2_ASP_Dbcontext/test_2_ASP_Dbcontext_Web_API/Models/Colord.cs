using System;
using System.Collections.Generic;

namespace test_2_ASP_Dbcontext_Web_API.Models;

public partial class Colord
{
    public int IdColor { get; set; }

    public string Color { get; set; } = null!;

    public virtual ICollection<Car> Cars { get; set; } = new List<Car>();
}

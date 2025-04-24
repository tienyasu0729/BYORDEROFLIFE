using System;
using System.Collections.Generic;

namespace test_DBFirst_ASP.Models;

public partial class Car
{
    public int IdCar { get; set; }

    public string NameCar { get; set; } = null!;

    public int? IdColor { get; set; }

    public virtual Colord? IdColorNavigation { get; set; }
}

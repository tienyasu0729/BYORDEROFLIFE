using System;
using System.Collections.Generic;

namespace Tien_Chill_Project.Models;

public partial class Blog
{
    public int BlogId { get; set; }

    public string BlogContent { get; set; } = null!;

    public DateOnly DatePublish { get; set; }

    public string Publisher { get; set; } = null!;
}

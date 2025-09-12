using System;
using System.Collections.Generic;

namespace GroupProjectBusiness.Models;

public partial class Project
{
    public int Id { get; set; }

    public int? TeamId { get; set; }

    public string Title { get; set; } = null!;

    public string? Summary { get; set; }

    public virtual ICollection<Score> Scores { get; set; } = new List<Score>();

    public virtual Team? Team { get; set; }
}

using System;
using System.Collections.Generic;

namespace GroupProjectBusiness.Models;

public partial class Team
{
    public int Id { get; set; }

    public string TeamName { get; set; } = null!;

    public string? Description { get; set; }

    public int? LeaderId { get; set; }

    public virtual User? Leader { get; set; }

    public virtual ICollection<Project> Projects { get; set; } = new List<Project>();
}

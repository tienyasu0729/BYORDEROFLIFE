using System;
using System.Collections.Generic;

namespace GameProjectBusiness.Models;

public partial class Team
{
    public int Id { get; set; }

    public string TeamName { get; set; } = null!;

    public string? Description { get; set; }

    public int LeaderId { get; set; }

    public virtual ICollection<GameProject> GameProjects { get; set; } = new List<GameProject>();

    public virtual User Leader { get; set; } = null!;
}

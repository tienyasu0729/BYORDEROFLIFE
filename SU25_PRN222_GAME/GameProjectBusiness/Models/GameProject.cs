using System;
using System.Collections.Generic;

namespace GameProjectBusiness.Models;

public partial class GameProject
{
    public int Id { get; set; }

    public int TeamId { get; set; }

    public string Title { get; set; } = null!;

    public string? Summary { get; set; }

    public bool? IsApproved { get; set; }

    public virtual ICollection<Evaluation> Evaluations { get; set; } = new List<Evaluation>();

    public virtual Team Team { get; set; } = null!;
}

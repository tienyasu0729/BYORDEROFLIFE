using System;
using System.Collections.Generic;

namespace GameProjectBusiness.Models;

public partial class Evaluation
{
    public int Id { get; set; }

    public int GameProjectId { get; set; }

    public int LecturerId { get; set; }

    public int? Score { get; set; }

    public string? Comment { get; set; }

    public virtual GameProject GameProject { get; set; } = null!;

    public virtual User Lecturer { get; set; } = null!;
}

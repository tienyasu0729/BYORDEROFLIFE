using System;
using System.Collections.Generic;

namespace PRN_Sum25B5_Q1_Solution.Models;

public partial class Enrollment
{
    public int StudentId { get; set; }

    public int CourseId { get; set; }

    public DateOnly? EnrollDate { get; set; }

    public double? Grade { get; set; }

    public virtual Course Course { get; set; } = null!;

    public virtual Student Student { get; set; } = null!;
}

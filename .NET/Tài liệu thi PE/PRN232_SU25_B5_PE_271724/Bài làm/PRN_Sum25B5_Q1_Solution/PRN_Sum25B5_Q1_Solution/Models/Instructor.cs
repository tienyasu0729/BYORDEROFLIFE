using System;
using System.Collections.Generic;

namespace PRN_Sum25B5_Q1_Solution.Models;

public partial class Instructor
{
    public int InstructorId { get; set; }

    public string? FullName { get; set; }

    public string? Email { get; set; }

    public DateOnly? HireDate { get; set; }

    public virtual ICollection<Course> Courses { get; set; } = new List<Course>();
}

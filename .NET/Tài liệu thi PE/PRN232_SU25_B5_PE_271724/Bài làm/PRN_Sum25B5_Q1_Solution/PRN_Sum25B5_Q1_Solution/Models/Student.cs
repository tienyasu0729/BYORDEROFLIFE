using System;
using System.Collections.Generic;

namespace PRN_Sum25B5_Q1_Solution.Models;

public partial class Student
{
    public int StudentId { get; set; }

    public string? FullName { get; set; }

    public string? Email { get; set; }

    public DateOnly? EnrollmentDate { get; set; }

    public virtual ICollection<Enrollment> Enrollments { get; set; } = new List<Enrollment>();
}

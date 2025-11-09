using System;
using System.Collections.Generic;

namespace PRN_Sum25B5_Q1_Solution.Models;

public partial class Course
{
    public int CourseId { get; set; }

    public string? Title { get; set; }

    public string? Description { get; set; }

    public int? InstructorId { get; set; }

    public virtual ICollection<Enrollment> Enrollments { get; set; } = new List<Enrollment>();

    public virtual Instructor? Instructor { get; set; }

    public virtual ICollection<Topic> Topics { get; set; } = new List<Topic>();
}

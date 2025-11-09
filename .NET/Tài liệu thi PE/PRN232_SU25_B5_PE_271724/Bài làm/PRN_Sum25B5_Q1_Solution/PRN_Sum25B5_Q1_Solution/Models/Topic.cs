using System;
using System.Collections.Generic;

namespace PRN_Sum25B5_Q1_Solution.Models;

public partial class Topic
{
    public int TopicId { get; set; }

    public string? Name { get; set; }

    public virtual ICollection<Course> Courses { get; set; } = new List<Course>();
}

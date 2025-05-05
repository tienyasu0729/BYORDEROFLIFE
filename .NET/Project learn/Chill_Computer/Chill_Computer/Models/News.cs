using System;
using System.Collections.Generic;

namespace Chill_Computer.Models;

public partial class News
{
    public int NewsId { get; set; }

    public string Title { get; set; } = null!;

    public string Slug { get; set; } = null!;

    public string? Summary { get; set; }

    public string Content { get; set; } = null!;

    public string? Thumbnail { get; set; }

    public DateTime DatePublish { get; set; }

    public string AuthorUserName { get; set; } = null!;

    public int? CategoryId { get; set; }

    public bool IsVisible { get; set; }

    public string ApprovalStatus { get; set; } = null!;

    public string? ApprovedBy { get; set; }

    public DateTime? ApprovalDate { get; set; }

    public virtual Account? ApprovedByNavigation { get; set; }

    public virtual Account AuthorUserNameNavigation { get; set; } = null!;

    public virtual NewsCategory? Category { get; set; }
}

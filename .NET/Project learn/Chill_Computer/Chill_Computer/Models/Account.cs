using System;
using System.Collections.Generic;

namespace Chill_Computer.Models;

public partial class Account
{
    public string UserName { get; set; } = null!;

    public string Password { get; set; } = null!;

    public int RoleId { get; set; }

    public virtual ICollection<News> NewsApprovedByNavigations { get; set; } = new List<News>();

    public virtual ICollection<News> NewsAuthorUserNameNavigations { get; set; } = new List<News>();

    public virtual Role Role { get; set; } = null!;

    public virtual ICollection<User> Users { get; set; } = new List<User>();
}

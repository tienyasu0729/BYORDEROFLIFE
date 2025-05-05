using System;
using System.Collections.Generic;

namespace Tien_Chill_Project.Models;

public partial class Role
{
    public int RoleId { get; set; }

    public string RolePosition { get; set; } = null!;

    public virtual ICollection<Account> Accounts { get; set; } = new List<Account>();
}

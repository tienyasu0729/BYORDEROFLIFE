using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class MainAccount
{
    public int IdMainAccount { get; set; }

    public string BusinessId { get; set; } = null!;

    public string Password { get; set; } = null!;

    public int AccountArea { get; set; }

    public string PhoneNumber { get; set; } = null!;

    public string Email { get; set; } = null!;

    public virtual Area AccountAreaNavigation { get; set; } = null!;

    public virtual ICollection<Shop> Shops { get; set; } = new List<Shop>();
}

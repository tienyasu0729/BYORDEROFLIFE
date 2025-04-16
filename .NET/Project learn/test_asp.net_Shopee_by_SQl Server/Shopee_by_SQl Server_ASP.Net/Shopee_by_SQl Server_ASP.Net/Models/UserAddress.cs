using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class UserAddress
{
    public int IdUser { get; set; }

    public string NameAddress { get; set; } = null!;

    public string PhoneNumber { get; set; } = null!;

    public string ApartmentNumber { get; set; } = null!;

    public string StreetName { get; set; } = null!;

    public string District { get; set; } = null!;

    public string Ward { get; set; } = null!;

    public string City { get; set; } = null!;

    public bool? IsDefault { get; set; }
}

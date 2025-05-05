using System;
using System.Collections.Generic;

namespace Tien_Chill_Project.Models;

public partial class User
{
    public int UserId { get; set; }

    public string FullName { get; set; } = null!;

    public string Email { get; set; } = null!;

    public DateOnly? Dob { get; set; }

    public string Phone { get; set; } = null!;

    public string Address { get; set; } = null!;

    public string UserName { get; set; } = null!;

    public virtual ICollection<Order> Orders { get; set; } = new List<Order>();

    public virtual ICollection<Payment> Payments { get; set; } = new List<Payment>();

    public virtual ICollection<ShoppingCart> ShoppingCarts { get; set; } = new List<ShoppingCart>();

    public virtual Account UserNameNavigation { get; set; } = null!;
}

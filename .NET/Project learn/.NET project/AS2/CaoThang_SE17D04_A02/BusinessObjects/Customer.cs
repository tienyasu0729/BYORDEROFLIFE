using System;
using System.Collections.Generic;

namespace BusinessObjects;

public partial class Customer
{
    public int CustomerId { get; set; }

    public string CustomerFullName { get; set; } = null!;

    public string TelePhone { get; set; } = null!;

    public string EmailAddress { get; set; } = null!;

    public DateOnly CustomerBirthDay { get; set; }

    public bool? CustomerStatus { get; set; }

    public string? Password { get; set; } = null!;

    public virtual ICollection<BookingReservation> BookingReservations { get; set; } = new List<BookingReservation>();
}

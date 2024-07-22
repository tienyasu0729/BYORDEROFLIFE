using System;
using System.Collections.Generic;

namespace BusinessObjects;

public partial class BookingReservation
{
    public int BookingReservationId { get; set; }

    public DateOnly BookingDate { get; set; }

    public decimal TotalPrice { get; set; }

    public int CustomerId { get; set; }

    public bool BooingStatus { get; set; }

    public virtual BookingDetail? BookingDetail { get; set; }

    public virtual Customer Customer { get; set; } = null!;
}

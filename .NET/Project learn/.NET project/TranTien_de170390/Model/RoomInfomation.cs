using System;
using System.Collections.Generic;

namespace Model;

public partial class RoomInfomation
{
    public int RoomId { get; set; }

    public int RoomNumber { get; set; }

    public string? RoomDetailDescription { get; set; }

    public string RoomMaxCapacity { get; set; } = null!;

    public int RoomTypeId { get; set; }

    public bool RoomStatus { get; set; }

    public decimal RoomPricePerDay { get; set; }

    public virtual ICollection<BookingDetail> BookingDetails { get; set; } = new List<BookingDetail>();

    public virtual RoomType RoomType { get; set; } = null!;

}

using System;
using System.Collections.Generic;

namespace BusinessObjects;

public partial class RoomType
{
    public int RoomTypeId { get; set; }

    public string RoomTypeName { get; set; } = null!;

    public string? TypeDescription { get; set; }

    public string? TypeNote { get; set; }

    public virtual ICollection<RoomInfomation> RoomInfomations { get; set; } = new List<RoomInfomation>();
}

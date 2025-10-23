using System;
using System.Collections.Generic;

namespace FA25_PRN232.Models;

public partial class Vehicle
{
    public int VehicleId { get; set; }

    public string PlateNumber { get; set; } = null!;

    public string Brand { get; set; } = null!;

    public string OwnerName { get; set; } = null!;

    public int UserId { get; set; }

    public virtual ICollection<ServiceOrder> ServiceOrders { get; set; } = new List<ServiceOrder>();

    public virtual User User { get; set; } = null!;
}

using System;
using System.Collections.Generic;

namespace GarageSystem.BusinessLogic.Models;

public partial class ServiceOrder
{
    public int OrderId { get; set; }

    public int VehicleId { get; set; }

    public int ServiceId { get; set; }

    public DateTime? CreatedAt { get; set; }

    public bool? Status { get; set; }

    public virtual Service Service { get; set; } = null!;

    public virtual Vehicle Vehicle { get; set; } = null!;
}

using System;
using System.Collections.Generic;

namespace Tien_Chill_Project.Models;

public partial class Discount
{
    public int DiscountId { get; set; }

    public string DiscountCode { get; set; } = null!;

    public decimal DiscountAmount { get; set; }

    public DateOnly StartDate { get; set; }

    public DateOnly EndDate { get; set; }

    public bool IsActive { get; set; }
}

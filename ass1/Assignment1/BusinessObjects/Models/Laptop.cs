using System;
using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc.ModelBinding.Validation; // <-- Thêm dòng này

namespace BusinessObjects.Models;

public partial class Laptop
{
    public int LaptopId { get; set; }

    public string Name { get; set; } = null!;

    public string Brand { get; set; } = null!;

    public decimal Price { get; set; }

    public int StockQuantity { get; set; }

    public DateTime CreatedAt { get; set; }

    public int UserId { get; set; }

    [ValidateNever] // <-- Thêm dòng này
    public virtual ICollection<Order> Orders { get; set; } = new List<Order>();

    [ValidateNever] // <-- Thêm dòng này
    public virtual User User { get; set; } = null!;
}
using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class ClassificationValue
{
    public int IdClassificationValue { get; set; }

    public string? ClassificationValue1 { get; set; }

    public int Price { get; set; }

    public int? InventoryQuantity { get; set; }

    public string? SkuClassification { get; set; }

    public decimal PackagedLength { get; set; }

    public decimal PackagedWidth { get; set; }

    public decimal PackagedWeight { get; set; }

    public decimal PackagedHeight { get; set; }

    public bool? AllowedPackageInspection { get; set; }

    public bool? Status { get; set; }

    public int IdClassification { get; set; }

    public virtual Classification IdClassificationNavigation { get; set; } = null!;

    public virtual ICollection<ListItemInOrderCancelled> ListItemInOrderCancelleds { get; set; } = new List<ListItemInOrderCancelled>();

    public virtual ICollection<ListItemInOrderCompleted> ListItemInOrderCompleteds { get; set; } = new List<ListItemInOrderCompleted>();

    public virtual ICollection<ListItemInOrderInTransit> ListItemInOrderInTransits { get; set; } = new List<ListItemInOrderInTransit>();

    public virtual ICollection<ListItemInOrderPendingPayment> ListItemInOrderPendingPayments { get; set; } = new List<ListItemInOrderPendingPayment>();

    public virtual ICollection<ListItemInOrderPendingShipment> ListItemInOrderPendingShipments { get; set; } = new List<ListItemInOrderPendingShipment>();

    public virtual ICollection<ListItemInOrderReturned> ListItemInOrderReturneds { get; set; } = new List<ListItemInOrderReturned>();

    public virtual ICollection<ProductReview> ProductReviews { get; set; } = new List<ProductReview>();

    public virtual ICollection<ProductShippingMethod> ProductShippingMethods { get; set; } = new List<ProductShippingMethod>();
}

using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class User
{
    public int IdUser { get; set; }

    public string PhoneNumber { get; set; } = null!;

    public string Password { get; set; } = null!;

    public string? AccountName { get; set; }

    public string? RealName { get; set; }

    public string? Email { get; set; }

    public string? Sex { get; set; }

    public DateOnly? DateOfBirth { get; set; }

    public string? AvatarImage { get; set; }

    public DateOnly? JoiningDate { get; set; }

    public virtual ICollection<BlockedUser> BlockedUsers { get; set; } = new List<BlockedUser>();

    public virtual ICollection<ProductReview> ProductReviews { get; set; } = new List<ProductReview>();

    public virtual UserIdentificationInformation? UserIdentificationInformation { get; set; }

    public virtual UserNotification? UserNotification { get; set; }

    public virtual ICollection<UserOrderCancelled> UserOrderCancelleds { get; set; } = new List<UserOrderCancelled>();

    public virtual ICollection<UserOrderCompleted> UserOrderCompleteds { get; set; } = new List<UserOrderCompleted>();

    public virtual ICollection<UserOrderInTransit> UserOrderInTransits { get; set; } = new List<UserOrderInTransit>();

    public virtual ICollection<UserOrderPendingPayment> UserOrderPendingPayments { get; set; } = new List<UserOrderPendingPayment>();

    public virtual ICollection<UserOrderPendingShipment> UserOrderPendingShipments { get; set; } = new List<UserOrderPendingShipment>();

    public virtual ICollection<UserOrderReturned> UserOrderReturneds { get; set; } = new List<UserOrderReturned>();

    public virtual UserSpending? UserSpending { get; set; }

    public virtual UserWallet? UserWallet { get; set; }
}

using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class NotificationSetting
{
    public int IdShop { get; set; }

    public bool OrderUpdateNotification { get; set; }

    public bool NewsletterNotification { get; set; }

    public bool ProductUpdateNotification { get; set; }

    public bool PersonalContentNotification { get; set; }

    public bool ChatMessagesReminder { get; set; }

    public virtual Shop IdShopNavigation { get; set; } = null!;
}

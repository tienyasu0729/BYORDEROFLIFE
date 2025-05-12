using System;
using System.Collections.Generic;

namespace Model_Shopee_Project.Models;

public partial class UserNotification
{
    public int IdUser { get; set; }

    public bool? EmailNotificationSwitch { get; set; }

    public bool? OrderUpdateViaEmail { get; set; }

    public bool? PromotionalEmailNotification { get; set; }

    public bool? SurveyNotificationViaEmail { get; set; }

    public bool? SmsNotificationSwitch { get; set; }

    public bool? PromotionalSmsNotification { get; set; }

    public virtual User IdUserNavigation { get; set; } = null!;
}

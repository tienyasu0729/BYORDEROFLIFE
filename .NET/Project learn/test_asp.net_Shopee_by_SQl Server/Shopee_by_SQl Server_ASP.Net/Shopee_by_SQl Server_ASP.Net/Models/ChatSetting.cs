using System;
using System.Collections.Generic;

namespace Shopee_by_SQl_Server_ASP.Net.Models;

public partial class ChatSetting
{
    public int IdShop { get; set; }

    public bool ReceiveMessagesFromShopeeRewards { get; set; }

    public bool ReceiveMessagesFromPersonalPage { get; set; }

    public bool PlaySoundNotificationForNewMessages { get; set; }

    public bool PushNewPopupMessage { get; set; }

    public virtual Shop IdShopNavigation { get; set; } = null!;
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Chat_Settings
    {
        public bool ReceiveMessagesFromShopeeRewards { get; set; }
        public bool ReceiveMessagesFromPersonalPage { get; set; }
        public bool PlaySoundNotificationForNewMessages { get; set; }
        public bool PushNewPopupMessage { get; set; }
        public int ShopId { get; set; }
        public Shop Shop { get; set; }
    }
}

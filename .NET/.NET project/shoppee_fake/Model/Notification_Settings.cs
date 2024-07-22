using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Notification_Settings
    {
        public bool OrderUpdateNotification { get; set; }
        public bool NewsletterNotification { get; set; }
        public bool ProductUpdateNotification { get; set; }
        public bool PersonalContentNotification { get; set; }
        public bool ChatMessagesReminder { get; set; }
        public int IdShop {  get; set; }
        public Shop Shop { get; set; }
    }
}

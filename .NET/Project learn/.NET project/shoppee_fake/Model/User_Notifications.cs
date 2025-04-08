using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class User_Notifications
    {
        public bool EmailNotificationSwitch { get; set; }
        public bool OrderUpdateViaEmail { get; set; }
        public bool PromotionalEmailNotification { get; set; }
        public bool SurveyNotificationViaEmail { get; set; }
        public bool SMSNotificationSwitch { get; set; }
        public int IdUser { get; set; }
        public User User { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Coin_History
    {
        public int IdCoinHistory { get; set; }
        public int NumberCoin { get; set; }
        public string NotificationSubject { get; set; }
        public DateTime NotificationReceiptDate { get; set; }
        public int IdUser { get; set; }
        public User User { get; set; }
    }
}

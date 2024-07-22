using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Payment_Settings
    {
        public bool AutomaticWithdrawal { get; set; }
        public string PinCode { get; set; }
        public int IdShop { get; set; }
        public Shop Shop { get; set; }

    }
}

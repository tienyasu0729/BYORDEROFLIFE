using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class Business_Information
    {
        public string BusinessType { get; set; }
        public string AddressToTakeProduct { get; set; }
        public string RegisteredBusinessAddress { get; set; }
        public string TaxIdentificationNumber { get; set; }
        public int IdShop { get; set; }
        public Shop Shop { get; set; }
    }
}

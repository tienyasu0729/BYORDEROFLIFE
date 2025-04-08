using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class address
    {
        public int Id_Address { get; set; }
        public string NameAddress { get; set; }
        public string PhoneNumber { get; set; }
        public string ApartmentNumber { get; set; }
        public string StreetName { get; set; }
        public string District { get; set; }
        public string Ward { get; set; }
        public string City { get; set; }
        public bool IsDefault { get; set; }
        public int IdUser { get; set; }
        public User User { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BusinessObject
{
    public class Customer
    {
        public Customer() { }
        public Customer(int customerId, string customerName, string telephone, string email, DateTime birthday, int customerStatus, string password)
        {
            CustomerID = customerId;
            CustomerFullName = customerName;
            Telephone = telephone;
            EmailAddress = email;
            CustomerBirthday = birthday;
            CustomerStatus = customerStatus;
            Password = password;
        }
        public int CustomerID { get; set; }
        public string CustomerFullName { get; set; }
        public string Telephone { get; set; }
        public string EmailAddress { get; set; }
        public DateTime CustomerBirthday { get; set; }
        public int CustomerStatus { get; set;}
        public string Password { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BusinessObject
{
    public class Account
    {
        public Account() { }
        public Account(int accountId,string email, string password, int role)
        {
            AccountId = accountId;
            Email = email;
            Password = password;
            Role = role;
        }
        public int AccountId { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public int Role { get; set; }
    }
}

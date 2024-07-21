using BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAccessObjects
{
    public class AccountDAO
    {
        private static List<Account> listAccount;
        public AccountDAO()
        {
            Account admin1 = new Account(1, "admin", "123", 1);
            Account customer1 = new Account(2, "customer1", "123", 2);
            Account customer2 = new Account(3, "customer2", "123", 2);
            Account customer3 = new Account(4, "customer3", "123", 2);
            listAccount = new List<Account> { admin1, customer1, customer2, customer3 };
        }
        public List<Account> GetAccounts()
        {
            return listAccount;
        }
        public Account GetAccountByEmail(string email)
        {
            foreach (Account acc in listAccount.ToList())
            {
                if (acc.Email == email)
                {
                    return acc;
                }
            }
            return null;
        }
    }
}

using BusinessObject;
using DataAccessObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class AccountRepository
    {
        AccountDAO dao = new AccountDAO();
        public List<Account> GetAccounts() => dao.GetAccounts();
        public Account GetAccountByEmail(string email) => dao.GetAccountByEmail(email);
    }
}

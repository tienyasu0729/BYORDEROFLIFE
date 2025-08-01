using BusinessObjects.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services.Interface
{
    public interface IShopService
    {
        Shop GetShopByPhoneAndPassword(string phone, string password);
    }
}

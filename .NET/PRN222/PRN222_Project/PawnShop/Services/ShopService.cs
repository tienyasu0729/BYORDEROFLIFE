using BusinessObjects.Models;
using Repositories;
using Repositories.Interface;
using Services.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class ShopService : IShopService
    {
        private readonly IShopRepository _shopRepository;

        public ShopService()
        {
            _shopRepository = new ShopRepository();
        }

        public Shop GetShopByPhoneAndPassword(string phone, string password)
        {
            return _shopRepository.GetShopByPhoneAndPassword(phone, password);
        }
    }
}

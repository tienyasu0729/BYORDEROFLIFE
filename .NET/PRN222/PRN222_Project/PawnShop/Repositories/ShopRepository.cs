using BusinessObjects.Models;
using Repositories.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class ShopRepository : IShopRepository
    {
        private readonly PawnShopDbContext _context;

        public ShopRepository()
        {
            _context = new PawnShopDbContext();
        }

        public Shop GetShopByPhoneAndPassword(string phone, string password)
        {
            return _context.Shops.FirstOrDefault(s => s.PhoneNumber == phone && s.Password == password);
        }
    }
}

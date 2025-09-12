using BusinessObjects.Models;
using Repositories.Interface;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class PawnItemRepository : IPawnItemRepository
    {
        private readonly PawnShopDbContext _context;

        public PawnItemRepository()
        {
            _context = new PawnShopDbContext();
        }

        public void CreatePawnItem(PawnItem item)
        {
            _context.PawnItems.Add(item);
            _context.SaveChanges();
        }
    }

}

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
    public class PawnItemService : IPawnItemService
    {
        private readonly IPawnItemRepository _repo;

        public PawnItemService()
        {
            _repo = new PawnItemRepository();
        }

        public void CreatePawnItem(PawnItem item)
        {
            _repo.CreatePawnItem(item);
        }
    }
}

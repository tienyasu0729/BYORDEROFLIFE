using Interface_Shopee_Project;
using Model_Shopee_Project.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository_Shopee_Project
{
    public class AreaRepository : ICRUD<Area>
    {
        private readonly ShopeeContext _context;
        public AreaRepository(ShopeeContext context)
        {
            _context = context;
        }
        public void Add(Area entity)
        {
            _context.Areas.Add(entity);
            SaveChanges();
        }

        public void Delete(Area entity)
        {
            _context.Areas.Remove(entity);
            SaveChanges();
        }

        public List<Area> GetAll()
        {
            return _context.Areas.ToList();
        }

        public Area GetById(int id)
        {
            return _context.Areas.FirstOrDefault(a => a.AreaId == id);
        }

        public Area GetByName(string name)
        {
            throw new NotImplementedException();
        }

        public void SaveChanges()
        {
            throw new NotImplementedException();
        }

        public void Update(Area entity)
        {
            throw new NotImplementedException();
        }
    }
}

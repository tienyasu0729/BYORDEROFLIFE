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

        public void Add(Area entity)
        {
            throw new NotImplementedException();
        }

        public void Delete(Area entity)
        {
            throw new NotImplementedException();
        }

        public List<Area> GetAll()
        {
            throw new NotImplementedException();
        }

        public Area GetById(int id)
        {
            throw new NotImplementedException();
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

using Interface_Shopee_Project;
using Model_Shopee_Project.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static Azure.Core.HttpHeader;

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

        public void DeleteAll()
        {
            _context.Areas.RemoveRange(_context.Areas);
            SaveChanges();
        }
        
        // Có thể thay bằng câu lệnh sql thuần ( tìm hiểu lý do không nên sử dụng lắm )
        public void DeleteByID(int id)
        {
            var area = GetById(id);
            if (area != null)
            {
                Delete(area);
            }
        }

        public void DeleteByName(string name)
        {
            var area = GetByName(name);
            if (area != null)
            {
                Delete(area);
            }
        }

        public void DeleteOfChooseID(int[] ids)
        {
            var areas = _context.Areas.Where(a => ids.Contains(a.AreaId)).ToList();
            _context.Areas.RemoveRange(areas);
            SaveChanges();
        }

        public void DeleteOfChooseName(String[] names)
        {
            var areas = _context.Areas.Where(a => names.Contains(a.NameArea)).ToList();
            _context.Areas.RemoveRange(areas);
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
            return _context.Areas.FirstOrDefault(a => a.NameArea == name);
        }

        public List<Area> GetListByName(string name)
        {
            return _context.Areas
                                   .Where(a => a.NameArea.Contains(name))
                                   .ToList();
        }

        public void SaveChanges()
        {
            _context.SaveChanges();
        }

        public void Update(Area entity)
        {
            _context.Areas.Update(entity);
            SaveChanges();
        }
    }
}

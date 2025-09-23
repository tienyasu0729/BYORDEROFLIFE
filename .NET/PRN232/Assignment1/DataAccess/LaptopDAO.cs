using BusinessObjects;
using BusinessObjects.Models;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;

namespace DataAccess
{
    public class LaptopDAO
    {

        public List<Laptop> GetAll()
        {
            using var context = new FptshopDbContext();
            return context.Laptops.ToList(); // Đã xóa .Include()
        }

        public Laptop GetById(int id)
        {
            using var context = new FptshopDbContext();
            return context.Laptops.FirstOrDefault(l => l.LaptopId == id); // Đã xóa .Include()
        }

        public void Add(Laptop laptop)
        {
            using var context = new FptshopDbContext();
            context.Laptops.Add(laptop);
            context.SaveChanges();
        }

        public void Update(Laptop laptop)
        {
            using var context = new FptshopDbContext();
            context.Entry(laptop).State = EntityState.Modified;
            context.SaveChanges();
        }

        public void Delete(int id)
        {
            using var context = new FptshopDbContext();
            var laptop = context.Laptops.Find(id);
            if (laptop != null)
            {
                context.Laptops.Remove(laptop);
                context.SaveChanges();
            }
        }
    }
}
using BusinessObjects.Models;
using DataAccess;

namespace Repositories
{
    public class LaptopRepository : ILaptopRepository
    {
        private readonly LaptopDAO laptopDAO = new LaptopDAO();

        public List<Laptop> GetAll()
        {
            return laptopDAO.GetAll();
        }

        public Laptop GetById(int id)
        {
            return laptopDAO.GetById(id);
        }

        public void Add(Laptop laptop)
        {
            laptopDAO.Add(laptop);
        }

        public void Update(Laptop laptop)
        {
            laptopDAO.Update(laptop);
        }

        public void Delete(int id)
        {
            laptopDAO.Delete(id);
        }
    }
}
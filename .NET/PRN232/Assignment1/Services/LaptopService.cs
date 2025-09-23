using BusinessObjects;
using BusinessObjects.Models;
using Repositories;
using System.Collections.Generic;

namespace Services
{
    public class LaptopService : ILaptopService
    {
        private readonly ILaptopRepository _laptopRepository = new LaptopRepository();

        public List<Laptop> GetLaptops()
        {
            return _laptopRepository.GetAll();
        }

        public Laptop GetLaptopById(int id)
        {
            return _laptopRepository.GetById(id);
        }

        public void AddLaptop(Laptop laptop)
        {
            _laptopRepository.Add(laptop);
        }

        public void UpdateLaptop(Laptop laptop)
        {
            _laptopRepository.Update(laptop);
        }

        public void DeleteLaptop(int id)
        {
            _laptopRepository.Delete(id);
        }
    }
}
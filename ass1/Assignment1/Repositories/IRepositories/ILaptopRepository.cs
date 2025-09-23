using BusinessObjects;
using BusinessObjects.Models;
using System.Collections.Generic;

namespace Repositories
{
    public interface ILaptopRepository
    {
        List<Laptop> GetAll();
        Laptop GetById(int id);
        void Add(Laptop laptop);
        void Update(Laptop laptop);
        void Delete(int id);
    }
}
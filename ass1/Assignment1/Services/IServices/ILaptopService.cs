using BusinessObjects.Models;

namespace Services
{
    public interface ILaptopService
    {
        List<Laptop> GetLaptops();
        Laptop GetLaptopById(int id);
        void AddLaptop(Laptop laptop);
        void UpdateLaptop(Laptop laptop);
        void DeleteLaptop(int id);
    }
}
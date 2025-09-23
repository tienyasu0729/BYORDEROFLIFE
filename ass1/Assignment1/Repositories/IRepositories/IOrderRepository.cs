using BusinessObjects;
using BusinessObjects.Models;

namespace Repositories
{
    public interface IOrderRepository
    {
        void Add(Order order);
    }
}
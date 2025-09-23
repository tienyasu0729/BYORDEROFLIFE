using BusinessObjects;
using BusinessObjects.Models;

namespace Repositories
{
    public interface IUserRepository
    {
        User GetById(int id);
        User GetByEmailAndPassword(string email, string password);
    }
}
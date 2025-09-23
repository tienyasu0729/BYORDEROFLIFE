using BusinessObjects;
using BusinessObjects.Models;

namespace Services
{
    public interface IUserService
    {
        User GetUserById(int id);
        User Login(string email, string password);
    }
}
using System.Threading.Tasks;
using DataAccess.Models;

namespace BusinessLogic.Repositories.Interfaces
{
    public interface IAccountRepository
    {
        Task<BearAccount> LoginAsync(string email, string password);
    }
}
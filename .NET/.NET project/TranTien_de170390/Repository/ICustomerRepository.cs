using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
    public interface ICustomerRepository
    {
        List<Customer> GetAllCustomers();

        Customer GetCustomerByEmail(string email);

        void AddCustomer(Customer customer);

        void UpdateCustomer(Customer customer);

        List<Customer> GetCusByName(string name); 

        void DeleteCustomer(int customerId);
        
    }
}

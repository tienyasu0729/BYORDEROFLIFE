using BusinessObject;
using DataAccessObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositories
{
    public class CustomerRepository
    {
        CustomerDAO dao = new CustomerDAO();
        public List<Customer> GetCustomers() => dao.GetCustomers();
        public Customer GetCustomerById(int id) => dao.GetCustomerById(id);
        public void AddCustomer(Customer customer) => dao.AddCustomer(customer);
        public void UpdateCustomer(Customer customer) => dao.UpdateCustomer(customer);
        public void DeleteCustomer(Customer customer) => dao.DeleteCustomer(customer);
    }
}

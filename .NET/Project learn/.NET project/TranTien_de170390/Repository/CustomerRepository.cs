using DataAcess;
using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
    public class CustomerRepository : ICustomerRepository
    {


        public void AddCustomer(Customer customer) => CustomerDAO.AddCustomer(customer);



        public void DeleteCustomer(int customerId) => CustomerDAO.DeleteCustomer(customerId);

        public List<Customer> GetAllCustomers() => CustomerDAO.GetAllCustomers();

        public List<Customer> GetCusByName(string name)=> CustomerDAO.GetCusByName(name);
       

        public Customer GetCustomerByEmail(string email) => CustomerDAO.GetCustomerByEmail(email);


        public void UpdateCustomer(Customer customer) => CustomerDAO.UpdateCustomer(customer);

    }
}

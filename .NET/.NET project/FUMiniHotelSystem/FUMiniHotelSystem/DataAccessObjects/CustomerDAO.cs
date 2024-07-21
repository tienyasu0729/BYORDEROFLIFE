using BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;

namespace DataAccessObjects
{
    public class CustomerDAO
    {
        private static List<Customer> listCustomer;
        public CustomerDAO()
        {
            Customer customer1 = new Customer(2, "John Doe", "1234567890", "john@email.com", new DateTime(1980, 1, 10), 1, "123");
            Customer customer2 = new Customer(3, "Jane Smith", "0987654321", "jane@email.com", new DateTime(1985, 5, 20), 1, "123");
            Customer customer3 = new Customer(4, "Bob Johnson", "5555555555", "bob@email.com", new DateTime(1990, 11, 1), 1, "123");
            listCustomer = new List<Customer> { customer1, customer2, customer3 };
        }
        public List<Customer> GetCustomers()
        {
            return listCustomer;
        }
        //CRUD Customer
        public Customer GetCustomerById(int id)
        {
            foreach (Customer c in listCustomer.ToList())
            {
                if (c.CustomerID == id)
                {
                    return c;
                }
            }
            return null;
        }
        public void AddCustomer(Customer customer)
        {
            listCustomer.Add(customer);
        }
        public void DeleteCustomer(Customer customer)
        {
            foreach (Customer c in listCustomer.ToList())
            {
                if (c.CustomerID == customer.CustomerID)
                {
                    listCustomer.Remove(c);
                }
            }
        }
        public void UpdateCustomer(Customer customer)
        {
            foreach(Customer c in listCustomer.ToList())
            {
                if(c.CustomerID == customer.CustomerID)
                {
                    c.CustomerFullName = customer.CustomerFullName;
                    c.Telephone = customer.Telephone;
                    c.EmailAddress = customer.EmailAddress;
                    c.CustomerBirthday = customer.CustomerBirthday;
                    c.CustomerStatus = customer.CustomerStatus;
                    c.Password = customer.Password;
                }
            }
        }
    }
}
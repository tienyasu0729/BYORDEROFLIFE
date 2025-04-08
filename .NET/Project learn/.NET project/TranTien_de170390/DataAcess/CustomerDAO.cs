using Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataAcess
{
    public class CustomerDAO
    {
        public static List<Customer> GetAllCustomers()
        {
            using (var context = new FuminiHotelSystemContext())
            {
                return context.Customers.ToList();
            }
        }

        public static Customer GetCustomerByEmail(string email)
        {
            using(var context= new FuminiHotelSystemContext())
            {
                return context.Customers.FirstOrDefault(y=>y.EmailAddress == email);
              
            }
        }
       
        public static List<Customer> GetCusByName(string name)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                return context.Customers
                      .Where(c => c.CustomerFullName.Contains(name))
                      .ToList();

            }
        }
        public static void AddCustomer(Customer customer)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                context.Customers.Add(customer);
                context.SaveChanges();
            }
        }

        public static void UpdateCustomer(Customer customer)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                var existingCustomer = context.Customers.Find(customer.CustomerId);
                if (existingCustomer != null)
                {
                    existingCustomer.CustomerFullName = customer.CustomerFullName;
                    existingCustomer.EmailAddress = customer.EmailAddress;
                    existingCustomer.TelePhone = customer.TelePhone;
                    existingCustomer.CustomerBirthDay = customer.CustomerBirthDay;  
                    existingCustomer.CustomerStatus = customer.CustomerStatus;  
                    context.SaveChanges();
                }
            }
        }

        public static void DeleteCustomer(int customerId)
        {
            using (var context = new FuminiHotelSystemContext())
            {
                var customer = context.Customers.Find(customerId);
                if (customer != null)
                {
                    context.Customers.Remove(customer);
                    context.SaveChanges();
                }
            }
        }

    }
}

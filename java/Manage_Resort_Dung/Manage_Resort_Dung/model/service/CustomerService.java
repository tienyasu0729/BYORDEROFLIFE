package model.service;

import java.util.ArrayList;

import model.entity.Customer;
import model.entity.CustomerType;
import model.repository.CustomerRepository;
import model.repository.CustomerTypeRepository;

public class CustomerService {
    ArrayList<Customer> customers=new ArrayList<>();
    CustomerRepository customerRepository=new CustomerRepository();
    CustomerTypeRepository customerTypeRepository=new CustomerTypeRepository();

    public ArrayList<CustomerType> getAllCustomerType()throws Exception{
        return customerTypeRepository.getAllCustomerType();
    }

    public CustomerType getCustomerTypeById(int id)throws Exception{
        return customerTypeRepository.getCustomerTypeById(id);
    }

    public ArrayList<Customer> getAllCustomers() throws Exception{
        return customerRepository.getAllCustomer();
    }

    public Customer getCustomerById(int id)throws Exception{
        return customerRepository.getCustomerById(id);
    }

    public void addCustomer(Customer customer)throws Exception{
        customerRepository.add(customer);
    }

    public void editCustomer(int id, Customer customer)throws Exception{
        customerRepository.editCustomer(id, customer);
    }

    public void deleteCustomer(int id)throws Exception{
        customerRepository.deleteCustomer(id);
    }
}

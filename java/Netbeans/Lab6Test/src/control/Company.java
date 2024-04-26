package control;

import model.Customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Company {

    private List<Customer> customerList;

    public Company() {
        customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void removeCustomer(Customer cusID) {

        for (Customer customer : customerList) {
            if (customer.getCustomerID().equals(cusID.getCustomerID())) {
                customerList.remove(customer);
            }
        }
    }

    public void printCustomerList() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    public Customer findCustomerByID(String customerID) {
        for (Customer customer : customerList) {
            if (customer.getCustomerID().equals(customerID)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> searchCondition(Predicate<Customer> predicate) {
        List<Customer> matchingCustomer = new ArrayList<>();
        for (Customer cus : customerList) {
            if (predicate.test(cus)) {
                matchingCustomer.add(cus);
            }
        }
        return matchingCustomer;
    }

    public void removeCus(Customer cusID) {
        Iterator<Customer> iterator = customerList.iterator();
        while (iterator.hasNext()) {
            Customer rmCus = iterator.next();
            if (rmCus.getCustomerID().equals(cusID.getCustomerID())) {
                iterator.remove();
            }
        }
    }
}

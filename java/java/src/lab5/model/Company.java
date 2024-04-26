package lab5.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Company {
    private List<Customer> customerList;

    public Company() {
        customerList = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    // Method for searching customers by different criteria

    public List<Customer> searchCustomers(String criteria, String value) {
        List<Customer> searchResults = new ArrayList<>();

        for (Customer customer : customerList) {
            switch (criteria) {
                case "CustomerID":
                    if (String.valueOf(customer.getCustomerID()).equals(value))
                        searchResults.add(customer);
                    break;
                case "Name":
                    if (customer.getName().equalsIgnoreCase(value))
                        searchResults.add(customer);
                    break;
                case "Phone":
                    if (customer.getPhone().equals(value))
                        searchResults.add(customer);
                    break;
            }
        }

        return searchResults;
    }

    public void sortCustomerList() {
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer customer1, Customer customer2) {
                return Integer.compare(customer1.getCustomerID(), customer2.getCustomerID());
            }
        });
    }
}
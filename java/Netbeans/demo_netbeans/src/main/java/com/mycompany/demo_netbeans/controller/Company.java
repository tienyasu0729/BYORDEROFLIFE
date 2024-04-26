/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demo_netbeans.controller;

import com.mycompany.demo_netbeans.model.Customer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Tienn
 */
public class Company {
     private List<Customer> customers;

    public Company() {
        customers = new ArrayList<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer cusID) {

        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(cusID.getCustomerID())) {
                customers.remove(customer);
            }
        }
    }

    public void printCustomerList() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public Customer findCustomerByID(String customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(customerID)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> searchCondition(Predicate<Customer> predicate) {
        List<Customer> matchingCustomer = new ArrayList<>();
        for (Customer cus : customers) {
            if (predicate.test(cus)) {
                matchingCustomer.add(cus);
            }
        }
        return matchingCustomer;
    }

    public void removeCus(Customer cusID) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer rmCus = iterator.next();
            if (rmCus.getCustomerID().equals(cusID.getCustomerID())) {
                iterator.remove();
            }
        }
    }
}

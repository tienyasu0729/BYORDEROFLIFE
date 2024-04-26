package model.entity;


public class Booking {
    private Customer customer;
    private String service;
    public Booking(Customer customer, String service) {
        this.customer = customer;
        this.service = service;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }
    @Override
    public String toString() {
        return "Booking [customer=" + customer.getCustomerName() + ", service=" + service + "]";
    }
}

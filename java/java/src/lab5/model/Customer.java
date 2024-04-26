package lab5.model;

public class Customer {
    private int customerID;
    private String name;
    private String phone;

    public Customer(int customerID, String name, String phone) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
    }

    // Getters and setters

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString() method

    @Override
    public String toString() {
        return "Customer ID: " + customerID + ", Name: " + name + ", Phone: " + phone;
    }
}
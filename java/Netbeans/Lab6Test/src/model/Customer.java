
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Customer {
    private String customerID;
    private String name;
    private String phone;
    private String dateofBirth;

    public Customer() {
    }

    public Customer(String customerID, String name, String phone, String dateofBirth) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
        this.dateofBirth = dateofBirth;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
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

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    @Override
    public String toString() {
        return "Customer{customerID= " + customerID + "|name= " + name + "|phone= " + phone + "|dateofBirth= " + dateofBirth + ")\n" ;
    }
    


}

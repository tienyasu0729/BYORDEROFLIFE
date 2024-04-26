package model.entity;

public class Customer {
    private int id;
    private String customerName;
    private String birthday;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private CustomerType customerType;
    private String address;
    public Customer(int id,String customerName, String birthday, String gender, String idCard, String phoneNumber,
            CustomerType customerType, String address) {
        this.id=id;
        this.customerName = customerName;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.customerType = customerType;
        this.address = address;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public CustomerType getCustomerType() {
        return customerType;
    }
    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Customer [customerName=" + customerName + ", birthday=" + birthday + ", gender=" + gender + ", idCard="
                + idCard + ", phoneNumber=" + phoneNumber + ", customerType=" + customerType.getNameType() + ", address=" + address
                + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}

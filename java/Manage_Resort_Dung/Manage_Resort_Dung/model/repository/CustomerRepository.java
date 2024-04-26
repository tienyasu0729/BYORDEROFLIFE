package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.Customer;
import model.entity.CustomerType;

public class CustomerRepository {
    private ArrayList<Customer> Customers=new ArrayList<>();
    CustomerTypeRepository customerTypeRepository=new CustomerTypeRepository();
    public ArrayList<Customer> read() throws Exception{
        Customers.clear();
        FileReader fr= new FileReader("D://Hoc_them/resort/database/Customer.txt");
        BufferedReader br= new BufferedReader(fr);
        String result;
        while ((result=br.readLine())!=null) {
            int id=Integer.parseInt(result.split(",")[0]);
            String name=result.split(",")[1];
            String birthday=result.split(",")[2];
            String gender=result.split(",")[3];
            String idCard=result.split(",")[4];
            String phoneNumber=result.split(",")[5];
            int customerTypeId=Integer.parseInt(result.split(",")[6]);
            CustomerType customerType=customerTypeRepository.getCustomerTypeById(customerTypeId);
            String address=result.split(",")[7];
            Customer customer=new Customer(id, name, birthday, gender, idCard, phoneNumber, customerType, address);
            Customers.add(customer);
        }
        br.close();
        fr.close();
        return Customers;
    }

    public void write() throws Exception{
        FileWriter fw=new FileWriter("D://Hoc_them/resort/database/Customer.txt");
        String cusString="";
        for (Customer customer : Customers) {
            cusString += customer.getId()+","+customer.getCustomerName()+","+customer.getBirthday()+","+customer.getGender()+","+customer.getIdCard()+","+customer.getPhoneNumber()+","+customer.getCustomerType().getId()+","+customer.getAddress()+"\n";
        }
        fw.write(cusString);
        fw.close();
    }

    public void add(Customer Customer)throws Exception{
        read();
        this.Customers.add(Customer);
        write();
    }

    public ArrayList<Customer> getAllCustomer()throws Exception{
        read();
        return this.Customers;
    }

    public Customer getCustomerById(int id)throws Exception{
        for (Customer customer : Customers) {
            if(customer.getId()==id){
                return customer;
            }
        }
        return null;
    }

    public void deleteCustomer(int id)throws Exception{
        for (Customer customer : Customers) {
            if(customer.getId()==id){
                Customers.remove(customer);
            }
        }
        write();
    }

    public void editCustomer(int id,Customer customer)throws Exception{
        for (Customer customer1 : Customers) {
            if(customer.getId()==id){
                Customers.remove(customer1);
                Customers.add(customer);
            }
        }
        write();
    }
}

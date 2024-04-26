package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.entity.CustomerType;

public class CustomerTypeRepository {
    
    public ArrayList<CustomerType> getAllCustomerType() throws Exception{
        ArrayList<CustomerType> CustomerTypes=new ArrayList<>();
        FileReader fr= new FileReader("D://Hoc_them/resort/database/CustomerType.txt");
        BufferedReader br= new BufferedReader(fr);
        String result;
        while ((result=br.readLine())!=null) {
            int id=Integer.parseInt(result.split(",")[0]);
            String name = result.split(",")[1];
            CustomerType customerType=new CustomerType(id, name);
            CustomerTypes.add(customerType);
        }
        br.close();
        fr.close();
        return CustomerTypes;
    }

    public CustomerType getCustomerTypeById(int id) throws Exception{
        for (CustomerType customerType : getAllCustomerType()) {
            if(customerType.getId()==id){
                return customerType;
            }
        }
        return null;
    }
}

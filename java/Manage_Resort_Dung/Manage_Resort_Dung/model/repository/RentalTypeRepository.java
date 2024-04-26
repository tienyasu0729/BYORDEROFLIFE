package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.RentalType;

public class RentalTypeRepository {
    ArrayList<RentalType> rentalTypes=new ArrayList<>();
    public ArrayList<RentalType> read() throws Exception{
        rentalTypes.clear();
        FileReader fr= new FileReader("D://Hoc_them/resort/database/RentalType.txt");
        BufferedReader br= new BufferedReader(fr);
        String result;
        while ((result=br.readLine())!=null) {
            int id=Integer.parseInt(result.split(",")[0]);
            String RentalTypeName=result.split(",")[1];
            String time=result.split(",")[2];
            RentalType rentalType=new RentalType(id, RentalTypeName, time);
            rentalTypes.add(rentalType);
        }
        br.close();
        fr.close();
        return rentalTypes;
    }

    public void write() throws Exception{
        FileWriter fw=new FileWriter("D://Hoc_them/resort/database/Employee.txt");
        String empString="";
        for (RentalType rentalType: rentalTypes) {
            empString += rentalType.getId()+","+rentalType.getRentalTypeName()+","+rentalType.getTime()+"\n";
        }
        fw.write(empString);
        fw.close();
    }

    public void addRentalType(RentalType rentalType)throws Exception{
        read();
        rentalTypes.add(rentalType);
        write();
    }

    public ArrayList<RentalType> getAllRentalTypes()throws Exception{
        read();
        return this.rentalTypes;
    }

    public RentalType getRentalTypeById(int id) throws Exception{
        read();
        for (RentalType rentalType : rentalTypes) {
            if(rentalType.getId()==id){
                return rentalType;
            }
        }
        return null;
    }
}

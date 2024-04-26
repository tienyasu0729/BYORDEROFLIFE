package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.AccompaniedService;

public class AccompaniedServiceRepository {
    ArrayList<AccompaniedService> accompaniedServices=new ArrayList<>();
    public ArrayList<AccompaniedService> read() throws Exception{
        accompaniedServices.clear();
        FileReader fr= new FileReader("D://Hoc_them/resort/database/AccompaniedService.txt");
        BufferedReader br= new BufferedReader(fr);
        String result;
        while ((result=br.readLine())!=null) {
            int id=Integer.parseInt(result.split(",")[0]);
            String accompaniedService=result.split(",")[1];
            int unit=Integer.parseInt(result.split(",")[2]);
            double price=Double.parseDouble(result.split(",")[3]);
            AccompaniedService accompaniedService2=new AccompaniedService(id,accompaniedService, unit, price);
            accompaniedServices.add(accompaniedService2);
        }
        br.close();
        fr.close();
        return accompaniedServices;
    }

    public void write() throws Exception{
        FileWriter fw=new FileWriter("D://Hoc_them/resort/database/Employee.txt");
        String empString="";
        for (AccompaniedService accompaniedService: accompaniedServices) {
            empString += accompaniedService.getId()+","+accompaniedService.getAccompaniedService()+","+accompaniedService.getUnit()+","+accompaniedService.getPrice()+"\n";
        }
        fw.write(empString);
        fw.close();
    }

    public void addAccompaniedService(AccompaniedService accompaniedService)throws Exception{
        read();
        accompaniedServices.add(accompaniedService);
        write();
    }

    public ArrayList<AccompaniedService> getAllAccompaniedServicesRepo()throws Exception{
        read();
        return accompaniedServices;
    }

    public AccompaniedService getAccompaniedServiceById(int id) throws Exception{
        read();
        for (AccompaniedService accompaniedService : accompaniedServices) {
            if(accompaniedService.getId()==id){
                return accompaniedService;
            }
        }
        return null;
    }

    
}

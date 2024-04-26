package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.AccompaniedService;
import model.entity.RentalType;
import model.entity.Villa;

public class VillaRepository {
    ArrayList<Villa> Villas=new ArrayList<>();
    RentalTypeRepository rentalTypeRepository=new RentalTypeRepository();
    AccompaniedServiceRepository accompaniedServiceRepository=new AccompaniedServiceRepository();
    public ArrayList<Villa> read() throws Exception{
        Villas.clear();
        FileReader fr= new FileReader("D://Hoc_them/resort/database/Villa.txt");
        BufferedReader br= new BufferedReader(fr);
        String result;
        while ((result=br.readLine())!=null) {
            String serviceName=result.split(",")[0];
            String usableArea=result.split(",")[1];
            double expense=Double.parseDouble(result.split(",")[2]);
            int maxNumOfPeople=Integer.parseInt(result.split(",")[3]);
            int rentalTypeId=Integer.parseInt(result.split(",")[4]);
            RentalType rentalType=rentalTypeRepository.getRentalTypeById(rentalTypeId);
            String villaId=result.split(",")[5];
            String roomStandard=result.split(",")[6];
            String otherAdventage=result.split(",")[7];
            double poolArea=Double.parseDouble(result.split(",")[8]);
            int numberOfFloors=Integer.parseInt(result.split(",")[9]);
            int accompaniedServiceId=Integer.parseInt(result.split(",")[10]);
            AccompaniedService accompaniedService=accompaniedServiceRepository.getAccompaniedServiceById(accompaniedServiceId);
            Villa Villa=new Villa(serviceName, usableArea, expense, maxNumOfPeople, rentalType, villaId, roomStandard, otherAdventage, poolArea, numberOfFloors, accompaniedService);
            Villas.add(Villa);
        }
        br.close();
        fr.close();
        return Villas;
    }

    public void write() throws Exception{
        FileWriter fw=new FileWriter("D://Hoc_them/resort/database/Villa.txt");
        String VillaStr="";
        for (Villa Villa : Villas) {
            VillaStr += Villa.getServiceName()+","+Villa.getUsableArea()+","+Villa.getExpense()+","+Villa.getMaxNumOfPeople()+","+Villa.getRentalType().getId()+","+Villa.getVillaId()+","+Villa.getRoomStandard()+","+Villa.getOtherAdvantages()+","+Villa.getPoolArea()+","+Villa.getNumberOfFloors()+","+Villa.getAccompaniedService().getId()+"\n";
            }
        fw.write(VillaStr);
        fw.close();
    }

    public void add(Villa Villa) throws Exception{
        read();
        Villas.add(Villa);
        write();
    }

    public ArrayList<Villa> getAllVilla() throws Exception{
        return read();
    }

    public Villa getVillaById(String id)throws Exception{
        read();
        for (Villa villa : Villas) {
                if (villa.getVillaId()==id) {
                    return villa;
                }
            }
        return null;
    }
}

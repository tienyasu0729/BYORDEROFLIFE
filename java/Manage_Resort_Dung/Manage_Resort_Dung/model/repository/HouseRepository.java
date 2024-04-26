package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.AccompaniedService;
import model.entity.House;
import model.entity.RentalType;

public class HouseRepository {
    ArrayList<House> Houses=new ArrayList<>();
    RentalTypeRepository rentalTypeRepository=new RentalTypeRepository();
    AccompaniedServiceRepository accompaniedServiceRepository=new AccompaniedServiceRepository();
    public ArrayList<House> read() throws Exception{
        Houses.clear();
        FileReader fr= new FileReader("D://Hoc_them/resort/database/House.txt");
        BufferedReader br= new BufferedReader(fr);
        String result;
        while ((result=br.readLine())!=null) {
            String serviceName=result.split(",")[0];
            String usableArea=result.split(",")[1];
            double expense=Double.parseDouble(result.split(",")[2]);
            int maxNumOfPeople=Integer.parseInt(result.split(",")[3]);
            int rentalTypeId=Integer.parseInt(result.split(",")[4]);
            RentalType rentalType=rentalTypeRepository.getRentalTypeById(rentalTypeId);
            int houseId=Integer.parseInt(result.split(",")[5]);
            String roomStandard=result.split(",")[6];
            String otherAdvantages=result.split(",")[7];
            int numberOfFloors=Integer.parseInt(result.split(",")[8]);
            int id=Integer.parseInt(result.split(",")[9]);
            AccompaniedService accompaniedService=accompaniedServiceRepository.getAccompaniedServiceById(id);
            House house=new House(serviceName, usableArea, expense, maxNumOfPeople, rentalType, houseId, roomStandard, otherAdvantages, numberOfFloors, accompaniedService);
            Houses.add(house);
        }
        br.close();
        fr.close();
        return Houses;
    }

    public void write() throws Exception{
        FileWriter fw=new FileWriter("D://Hoc_them/resort/database/House.txt");
        String houseStr="";
        for (House House : Houses) {
            houseStr += House.getServiceName()+","+House.getUsableArea()+","+House.getExpense()+","+House.getMaxNumOfPeople()+","+House.getRentalType().getId()+","+House.getHouseId()+","+House.getRoomStandard()+","+House.getOtherAdvantages()+","+House.getNumberOfFloors()+","+House.getAccompaniedService().getId()+"\n";
        }
        fw.write(houseStr);
        fw.close();
    }

    public void add(House House)throws Exception{
        read();
        Houses.add(House);
        write();
    }

    public ArrayList<House> getAllHouse()throws Exception{
        return read();
    }

    public House getHouseById(int id)throws Exception{
        read();
        for (House house : Houses) {
                if (house.getHouseId()==id) {
                    return house;
                }
            }
        return null;
    }
}

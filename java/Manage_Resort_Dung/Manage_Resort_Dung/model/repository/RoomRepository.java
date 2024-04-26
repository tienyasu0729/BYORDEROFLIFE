package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.AccompaniedService;
import model.entity.RentalType;
import model.entity.Room;

public class RoomRepository {
    ArrayList<Room> Rooms=new ArrayList<>();
    RentalTypeRepository rentalTypeRepository=new RentalTypeRepository();
    AccompaniedServiceRepository accompaniedServiceRepository=new AccompaniedServiceRepository();
    public ArrayList<Room> read() throws Exception{
        Rooms.clear();
        FileReader fr= new FileReader("D://Hoc_them/resort/database/Room.txt");
        BufferedReader br= new BufferedReader(fr);
        String result;
        while ((result=br.readLine())!=null) {
            String serviceName=result.split(",")[0];
            String usableArea=result.split(",")[1];
            double expense=Double.parseDouble(result.split(",")[2]);
            int maxNumOfPeople=Integer.parseInt(result.split(",")[3]);
            int rentalTypeId=Integer.parseInt(result.split(",")[4]);
            RentalType rentalType=rentalTypeRepository.getRentalTypeById(rentalTypeId);
            int RoomId=Integer.parseInt(result.split(",")[5]);
            String bonusService=result.split(",")[6];
            int id=Integer.parseInt(result.split(",")[7]);
            AccompaniedService accompaniedService=accompaniedServiceRepository.getAccompaniedServiceById(id);
            Room room=new Room(serviceName, usableArea, expense, maxNumOfPeople, rentalType, RoomId, bonusService, accompaniedService);
            Rooms.add(room);
        }
        br.close();
        fr.close();
        return Rooms;
    }

    public void write() throws Exception{
        FileWriter fw=new FileWriter("D://Hoc_them/resort/database/Room.txt");
        String RoomStr="";
        for (Room Room : Rooms) {
            RoomStr += Room.getServiceName()+","+Room.getUsableArea()+","+Room.getExpense()+","+Room.getMaxNumOfPeople()+","+Room.getRentalType().getId()+","+Room.getRoomId()+","+Room.getBonusService()+","+Room.getAccompaniedService().getId()+"\n";
            }
        fw.write(RoomStr);
        fw.close();
    }

    public void add(Room Room) throws Exception{
        read();
        Rooms.add(Room);
        write();
    }

    public ArrayList<Room> getAllRoom() throws Exception{
        return read();
    }

    public Room getRoomById(int id)throws Exception{
        read();
        for (Room Room : Rooms) {
                if (Room.getRoomId()==id) {
                    return Room;
                }
            }
        return null;
    }
}

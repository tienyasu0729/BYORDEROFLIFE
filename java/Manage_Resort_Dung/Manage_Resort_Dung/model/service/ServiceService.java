package model.service;


import java.util.ArrayList;

import model.entity.House;
import model.entity.Room;
import model.entity.Villa;
import model.repository.HouseRepository;
import model.repository.RoomRepository;
import model.repository.VillaRepository;

public class ServiceService {
    HouseRepository houseRepository=new HouseRepository();
    RoomRepository roomRepository=new RoomRepository();
    VillaRepository villaRepository=new VillaRepository();

    public ArrayList<House> getAllHouses() throws Exception{
        return houseRepository.getAllHouse();
    }

    public House getHouseById(int id) throws Exception{
        return houseRepository.getHouseById(id);
    }

    public void addHouse(House house)throws Exception{
        houseRepository.add(house);
    }

    public ArrayList<Room> getAllRoom()throws Exception{
        return roomRepository.getAllRoom();
    }

    public Room getRoomById(int id) throws Exception{
        return roomRepository.getRoomById(id);
    }

    public void addRoom(Room room)throws Exception{
        roomRepository.add(room);
    }

    public ArrayList<Villa> getAllVillas()throws Exception{
        return villaRepository.getAllVilla();
    }

    public Villa getVillaById(String id)throws Exception{
        return villaRepository.getVillaById(id);
    }

    public void addVilla(Villa villa)throws Exception{
        villaRepository.add(villa);
    }
}

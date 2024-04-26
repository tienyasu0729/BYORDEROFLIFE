package model.service;

import java.util.ArrayList;

import model.entity.RentalType;
import model.repository.RentalTypeRepository;

public class RentalTypeService {
    RentalTypeRepository rentalTypeRepository=new RentalTypeRepository();
    public ArrayList<RentalType> getAllRentalTypes()throws Exception{
        return rentalTypeRepository.getAllRentalTypes();
    }

    public RentalType getRentalTypeById(int id) throws Exception{
        return rentalTypeRepository.getRentalTypeById(id);
    }

    public void addRentalType(RentalType rentalType) throws Exception{
        rentalTypeRepository.addRentalType(rentalType);
    }
}

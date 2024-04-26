package model.service;

import java.util.ArrayList;

import model.entity.AccompaniedService;
import model.repository.AccompaniedServiceRepository;

public class AccompaniedServiceService {
    AccompaniedServiceRepository accompaniedServiceRepository=new AccompaniedServiceRepository();
    public ArrayList<AccompaniedService> getAllAccompaniedServices() throws Exception{
        return accompaniedServiceRepository.getAllAccompaniedServicesRepo();
    }

    public AccompaniedService getAccompaniedServiceById(int id)throws Exception{
        return accompaniedServiceRepository.getAccompaniedServiceById(id);
    }

    public void addAccompaniedService(AccompaniedService accompaniedService) throws Exception{
        accompaniedServiceRepository.addAccompaniedService(accompaniedService);
    }
}

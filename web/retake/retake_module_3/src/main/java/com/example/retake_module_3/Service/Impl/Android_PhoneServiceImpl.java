package com.example.retake_module_3.Service.Impl;

import com.example.retake_module_3.Repository.Android_PhoneRepository;
import com.example.retake_module_3.Repository.Impl.Android_PhoneRepositoryImpl;
import com.example.retake_module_3.Service.IAndroid_PhoneService;
import com.example.retake_module_3.model.Android_Phone;

import java.util.List;

public class Android_PhoneServiceImpl implements IAndroid_PhoneService {
    private Android_PhoneRepositoryImpl repository = new Android_PhoneRepositoryImpl();

    @Override
    public List<Android_Phone> list() {
        return repository.list();
    }

    @Override
    public Boolean add(Android_Phone y) {
        return repository.add(y);
    }

    @Override
    public Boolean edit(Android_Phone y) {
        return repository.edit(y);
    }

    @Override
    public Boolean delete(int idNeedDelete) {
        return repository.delete(idNeedDelete);
    }

    @Override
    public List<Android_Phone> findById(int idNeedFind) {
        return repository.findById(idNeedFind);
    }

    @Override
    public List<Android_Phone> findByName(int idNeedFind) {
        return repository.findByName(idNeedFind);
    }
}

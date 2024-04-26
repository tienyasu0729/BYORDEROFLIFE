package com.example.tien_thanh.Service.Impl;

import com.example.tien_thanh.Repository.Android_PhoneRepository;
import com.example.tien_thanh.Repository.Impl.Android_PhoneRepositoryImpl;
import com.example.tien_thanh.Service.IAndroid_PhoneService;
import com.example.tien_thanh.model.Android_Phone;

import java.util.Date;
import java.util.List;

public class Android_PhoneServiceImpl implements IAndroid_PhoneService {
    private Android_PhoneRepository android_phoneRepository = new Android_PhoneRepositoryImpl();
    @Override
    public List<Android_Phone> displayAndroid_Phone() {
        return android_phoneRepository.displayAndroid_Phone();
    }

    @Override
    public void add_New_Android_Phone(Android_Phone android_phone) {
        android_phoneRepository.add_New_Android_Phone(android_phone);
    }

    @Override
    public void edit_Android_Phone(Android_Phone android_phone) {
        android_phoneRepository.edit_Android_Phone(android_phone);
    }

    @Override
    public void delete_Android_Phone(String id) {
        android_phoneRepository.delete_Android_Phone(id);
    }

    @Override
    public void interest_payment(String id, Date date) {
        android_phoneRepository.interest_payment(id, date);
    }

    @Override
    public void stored_procedure(String action) {
        android_phoneRepository.stored_procedure(action);
    }

    @Override
    public Boolean check_if_id_exist(String idToCheck) {
        return android_phoneRepository.check_if_id_exist(idToCheck);
    }

    @Override
    public List<Android_Phone> list_Find_Android_Phone_Similar_By_Id(String id) {
        return android_phoneRepository.list_Find_Android_Phone_Similar_By_Id(id);
    }


    @Override
    public List<Android_Phone> list_Find_Android_Phone_Similar_By_Name(String name) {
        return android_phoneRepository.list_Find_Android_Phone_Similar_By_Name(name);
    }

    @Override
    public List<Android_Phone> late_list_android_phone() {
        return android_phoneRepository.late_list_android_phone();
    }

    @Override
    public List<Android_Phone> near_term_list_android_phone() {
        return android_phoneRepository.near_term_list_android_phone();
    }
}

package com.tienthanh.serviceSERVLET.Impl;


import com.tienthanh.repositorySERVLET.IAndroid_PhoneRepositorySERVLET;
import com.tienthanh.repositorySERVLET.Impl.Android_PhoneRepositorySERVLETImpl;
import com.tienthanh.serviceSERVLET.IAndroid_PhoneServiceSERVLET;
import com.tienthanh.modelSERVLET.Android_PhoneSERVLET;

import java.util.Date;
import java.util.List;

public class Android_PhoneServiceSERVLETImpl implements IAndroid_PhoneServiceSERVLET {
    private IAndroid_PhoneRepositorySERVLET android_phoneRepository = new Android_PhoneRepositorySERVLETImpl();
    @Override
    public List<Android_PhoneSERVLET> displayAndroid_Phone() {
        return android_phoneRepository.displayAndroid_Phone();
    }

    @Override
    public void add_New_Android_Phone(Android_PhoneSERVLET android_phone) {
        android_phoneRepository.add_New_Android_Phone(android_phone);
    }

    @Override
    public void edit_Android_Phone(Android_PhoneSERVLET android_phone) {
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
    public List<Android_PhoneSERVLET> list_Find_Android_Phone_Similar_By_Id(String id) {
        return android_phoneRepository.list_Find_Android_Phone_Similar_By_Id(id);
    }


    @Override
    public List<Android_PhoneSERVLET> list_Find_Android_Phone_Similar_By_Name(String name) {
        return android_phoneRepository.list_Find_Android_Phone_Similar_By_Name(name);
    }

    @Override
    public List<Android_PhoneSERVLET> late_list_android_phone() {
        return android_phoneRepository.late_list_android_phone();
    }

    @Override
    public List<Android_PhoneSERVLET> near_term_list_android_phone() {
        return android_phoneRepository.near_term_list_android_phone();
    }
}

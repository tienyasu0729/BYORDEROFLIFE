package com.tienthanh.serviceJPA.Impl;

import com.tienthanh.modelJPA.Android_PhoneJPA;
import com.tienthanh.repositoryJPA.IAndroid_PhoneRepositoryJPA;
import com.tienthanh.serviceJPA.IAndroid_PhoneServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Android_PhoneServiceJPAImpl implements IAndroid_PhoneServiceJPA {
    @Autowired
    private IAndroid_PhoneRepositoryJPA androidPhoneRepositoryJPA;
    @Override
    public List<Android_PhoneJPA> displayAndroid_Phone() {
        return androidPhoneRepositoryJPA.displayAndroid_Phone();
    }

    @Override
    public Boolean add_or_edit_new_android_phone(Android_PhoneJPA androidPhoneJPA) {
        return androidPhoneRepositoryJPA.add_or_edit_new_android_phone(androidPhoneJPA);
    }

    @Override
    public Boolean check_if_id_exist(String idToCheck) {
        return androidPhoneRepositoryJPA.check_if_id_exist(idToCheck);
    }

    @Override
    public Boolean delete_Android_Phone(String idToDelete) {
        return androidPhoneRepositoryJPA.delete_Android_Phone(idToDelete);
    }

    @Override
    public Boolean extend_interest_payment(String id, Date newDate) {
        return androidPhoneRepositoryJPA.extend_interest_payment(id, newDate);
    }

    @Override
    public List<Android_PhoneJPA> list_Find_Android_Phone_Similar_By_Id(String id) {
        return androidPhoneRepositoryJPA.list_Find_Android_Phone_Similar_By_Id(id);
    }

    @Override
    public List<Android_PhoneJPA> list_Find_Android_Phone_Similar_By_Name(String name) {
        return androidPhoneRepositoryJPA.list_Find_Android_Phone_Similar_By_Name(name);
    }

    @Override
    public List<Android_PhoneJPA> late_list_android_phone() {
        return androidPhoneRepositoryJPA.late_list_android_phone();
    }

    @Override
    public List<Android_PhoneJPA> near_term_list_android_phone() {
        return androidPhoneRepositoryJPA.near_term_list_android_phone();
    }

    @Override
    public Android_PhoneJPA findById(String id) {
        return androidPhoneRepositoryJPA.findById(id);
    }
}

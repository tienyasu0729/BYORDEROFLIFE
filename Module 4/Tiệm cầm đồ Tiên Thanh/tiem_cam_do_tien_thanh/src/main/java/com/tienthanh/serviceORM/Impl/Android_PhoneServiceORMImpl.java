package com.tienthanh.serviceORM.Impl;

import com.tienthanh.modelORM.Android_PhoneORM;
import com.tienthanh.repositoryORM.IAndroid_PhoneRepositoryORM;
import com.tienthanh.serviceORM.IAndroid_PhoneServiceORM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class Android_PhoneServiceORMImpl implements IAndroid_PhoneServiceORM {
    @Autowired
    private IAndroid_PhoneRepositoryORM androidPhoneRepositoryORM;
    @Override
    public List<Android_PhoneORM> displayAndroid_Phone() {
        return androidPhoneRepositoryORM.displayAndroid_Phone();
    }

    @Override
    public Boolean add_or_edit_new_android_phone(Android_PhoneORM androidPhoneORM) {
        return androidPhoneRepositoryORM.add_or_edit_new_android_phone(androidPhoneORM);
    }

    @Override
    public Boolean check_if_id_exist(String idToCheck) {
        return androidPhoneRepositoryORM.check_if_id_exist(idToCheck);
    }

    @Override
    public Boolean delete_Android_Phone(String idToDelete) {
        return androidPhoneRepositoryORM.delete_Android_Phone(idToDelete);
    }

    @Override
    public Boolean extend_interest_payment(String id, Date newDate) {
        return androidPhoneRepositoryORM.extend_interest_payment(id, newDate);
    }

    @Override
    public List<Android_PhoneORM> list_Find_Android_Phone_Similar_By_Id(String id) {
        return androidPhoneRepositoryORM.list_Find_Android_Phone_Similar_By_Id(id);
    }

    @Override
    public List<Android_PhoneORM> list_Find_Android_Phone_Similar_By_Name(String name) {
        return androidPhoneRepositoryORM.list_Find_Android_Phone_Similar_By_Name(name);
    }

    @Override
    public List<Android_PhoneORM> late_list_android_phone() {
        return androidPhoneRepositoryORM.late_list_android_phone();
    }

    @Override
    public List<Android_PhoneORM> near_term_list_android_phone() {
        return androidPhoneRepositoryORM.near_term_list_android_phone();
    }
}

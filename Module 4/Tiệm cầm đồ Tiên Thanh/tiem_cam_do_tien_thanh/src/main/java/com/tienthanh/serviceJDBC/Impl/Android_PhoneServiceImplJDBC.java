package com.tienthanh.serviceJDBC.Impl;



import com.tienthanh.modelJDBC.Android_PhoneJDBC;
import com.tienthanh.repositoryJDBC.IAndroid_PhoneRepositoryJDBC;
import com.tienthanh.repositoryJDBC.Impl.Android_PhoneRepositoryJDBCImpl;
import com.tienthanh.serviceJDBC.IAndroid_PhoneServiceJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Android_PhoneServiceImplJDBC implements IAndroid_PhoneServiceJDBC {
    @Autowired
    private IAndroid_PhoneRepositoryJDBC IAndroid_phoneRepositoryJDBC = new Android_PhoneRepositoryJDBCImpl();
    @Override
    public List<Android_PhoneJDBC> displayAndroid_Phone() {
        return IAndroid_phoneRepositoryJDBC.displayAndroid_Phone();
    }

    @Override
    public void add_New_Android_Phone(Android_PhoneJDBC android_phoneJDBC) {
        IAndroid_phoneRepositoryJDBC.add_New_Android_Phone(android_phoneJDBC);
    }

    @Override
    public void edit_Android_Phone(Android_PhoneJDBC android_phoneJDBC) {
        IAndroid_phoneRepositoryJDBC.edit_Android_Phone(android_phoneJDBC);
    }

    @Override
    public void delete_Android_Phone(String id) {
        IAndroid_phoneRepositoryJDBC.delete_Android_Phone(id);
    }

    @Override
    public void interest_payment(String id, Date date) {
        IAndroid_phoneRepositoryJDBC.interest_payment(id, date);
    }

    @Override
    public void stored_procedure(String action) {
        IAndroid_phoneRepositoryJDBC.stored_procedure(action);
    }

    @Override
    public Boolean check_if_id_exist(String idToCheck) {
        return IAndroid_phoneRepositoryJDBC.check_if_id_exist(idToCheck);
    }

    @Override
    public List<Android_PhoneJDBC> list_Find_Android_Phone_Similar_By_Id(String id) {
        return IAndroid_phoneRepositoryJDBC.list_Find_Android_Phone_Similar_By_Id(id);
    }


    @Override
    public List<Android_PhoneJDBC> list_Find_Android_Phone_Similar_By_Name(String name) {
        return IAndroid_phoneRepositoryJDBC.list_Find_Android_Phone_Similar_By_Name(name);
    }

    @Override
    public List<Android_PhoneJDBC> late_list_android_phone() {
        return IAndroid_phoneRepositoryJDBC.late_list_android_phone();
    }

    @Override
    public List<Android_PhoneJDBC> near_term_list_android_phone() {
        return IAndroid_phoneRepositoryJDBC.near_term_list_android_phone();
    }
}

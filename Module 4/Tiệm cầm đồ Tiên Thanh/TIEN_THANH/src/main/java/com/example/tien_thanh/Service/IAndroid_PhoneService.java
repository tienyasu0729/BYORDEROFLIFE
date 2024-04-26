package com.example.tien_thanh.Service;

import com.example.tien_thanh.model.Android_Phone;

import java.util.Date;
import java.util.List;

public interface IAndroid_PhoneService {
    List<Android_Phone> displayAndroid_Phone();
    void add_New_Android_Phone(Android_Phone android_phone);
    void edit_Android_Phone(Android_Phone android_phone);
    void delete_Android_Phone(String id);
    void interest_payment(String id, Date date);
    void stored_procedure(String action);
    Boolean check_if_id_exist(String idToCheck);
    List<Android_Phone> list_Find_Android_Phone_Similar_By_Id(String id);
    List<Android_Phone> list_Find_Android_Phone_Similar_By_Name(String name);
    List<Android_Phone> late_list_android_phone();
    List<Android_Phone> near_term_list_android_phone();
}

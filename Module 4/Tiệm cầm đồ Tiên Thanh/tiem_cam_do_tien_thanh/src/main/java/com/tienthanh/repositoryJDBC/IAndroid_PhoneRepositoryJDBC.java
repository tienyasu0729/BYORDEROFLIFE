package com.tienthanh.repositoryJDBC;


import com.tienthanh.modelJDBC.Android_PhoneJDBC;

import java.util.Date;
import java.util.List;

public interface IAndroid_PhoneRepositoryJDBC {
    List<Android_PhoneJDBC> displayAndroid_Phone();
    void add_New_Android_Phone(Android_PhoneJDBC android_phoneJDBC);
    void edit_Android_Phone(Android_PhoneJDBC android_phoneJDBC);
    void delete_Android_Phone(String id);
    void interest_payment(String id, Date date);
    void stored_procedure(String action);
    Boolean check_if_id_exist(String idToCheck);
    List<Android_PhoneJDBC> list_Find_Android_Phone_Similar_By_Id(String id);
    List<Android_PhoneJDBC> list_Find_Android_Phone_Similar_By_Name(String name);
    List<Android_PhoneJDBC> late_list_android_phone();
    List<Android_PhoneJDBC> near_term_list_android_phone();

}


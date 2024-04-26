package com.tienthanh.repositorySERVLET;


import com.tienthanh.modelSERVLET.Android_PhoneSERVLET;

import java.util.Date;
import java.util.List;

public interface IAndroid_PhoneRepositorySERVLET {
    List<Android_PhoneSERVLET> displayAndroid_Phone();
    void add_New_Android_Phone(Android_PhoneSERVLET android_phone);
    void edit_Android_Phone(Android_PhoneSERVLET android_phone);
    void delete_Android_Phone(String id);
    void interest_payment(String id, Date date);
    void stored_procedure(String action);
    Boolean check_if_id_exist(String idToCheck);
    List<Android_PhoneSERVLET> list_Find_Android_Phone_Similar_By_Id(String id);
    List<Android_PhoneSERVLET> list_Find_Android_Phone_Similar_By_Name(String name);
    List<Android_PhoneSERVLET> late_list_android_phone();
    List<Android_PhoneSERVLET> near_term_list_android_phone();

}


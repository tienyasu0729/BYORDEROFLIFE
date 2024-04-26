package com.tienthanh.repositoryJPA;

import com.tienthanh.modelJPA.Android_PhoneJPA;

import java.util.Date;
import java.util.List;

public interface IAndroid_PhoneRepositoryJPA {
    List<Android_PhoneJPA> displayAndroid_Phone();
    Boolean add_or_edit_new_android_phone(Android_PhoneJPA androidPhoneJPA);
    Boolean check_if_id_exist(String idToCheck);
    Boolean delete_Android_Phone(String idToDelete);
    Boolean extend_interest_payment(String id, Date newDate);
    List<Android_PhoneJPA> list_Find_Android_Phone_Similar_By_Id(String id);
    List<Android_PhoneJPA> list_Find_Android_Phone_Similar_By_Name(String name);
    List<Android_PhoneJPA> late_list_android_phone();
    List<Android_PhoneJPA> near_term_list_android_phone();
    Android_PhoneJPA findById(String id);

}

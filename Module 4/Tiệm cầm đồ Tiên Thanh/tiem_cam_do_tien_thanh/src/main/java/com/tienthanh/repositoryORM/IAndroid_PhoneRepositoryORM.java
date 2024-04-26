package com.tienthanh.repositoryORM;

import com.tienthanh.modelORM.Android_PhoneORM;

import java.util.Date;
import java.util.List;

public interface IAndroid_PhoneRepositoryORM {
    List<Android_PhoneORM> displayAndroid_Phone();
    Boolean add_or_edit_new_android_phone(Android_PhoneORM androidPhoneORM);
    Boolean check_if_id_exist(String idToCheck);
    Boolean delete_Android_Phone(String idToDelete);
    Boolean extend_interest_payment(String id, Date newDate);
    List<Android_PhoneORM> list_Find_Android_Phone_Similar_By_Id(String id);
    List<Android_PhoneORM> list_Find_Android_Phone_Similar_By_Name(String name);
    List<Android_PhoneORM> late_list_android_phone();
    List<Android_PhoneORM> near_term_list_android_phone();


}

package com.tienthanh.repositoryJPA.Impl;

import com.tienthanh.modelJPA.Android_PhoneJPA;
import com.tienthanh.repositoryJPA.IAndroid_PhoneRepositoryJPA;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class Android_PhoneRepositoryJPAImpl implements IAndroid_PhoneRepositoryJPA {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Android_PhoneJPA> displayAndroid_Phone() {
        List<Android_PhoneJPA> androidPhoneORMList = new ArrayList<>();
//        TypedQuery<Android_PhoneJPA> query = entityManager.createQuery("SELECT a FROM Android_PhoneJPA a", Android_PhoneJPA.class);   //chat GPT sửa lỗi (làm theo spring lấy tên cài lại trong đối tượng để bỏ vào câu truy vấn)
        TypedQuery<Android_PhoneJPA> query = (TypedQuery<Android_PhoneJPA>) entityManager.createNativeQuery("select * from android_phone", Android_PhoneJPA.class); // này là theo anh chánh (này phải làm theo câu lệnh query thuần tuý, không có hổ trợ , hay tự hiểu gì của spring cả)
        androidPhoneORMList = query.getResultList();
        return androidPhoneORMList;
    }

    @Transactional
    @Override
    public Boolean add_or_edit_new_android_phone(Android_PhoneJPA androidPhoneJPA) {
        try {
            if (findById(androidPhoneJPA.getId()) != null) {
                entityManager.merge(androidPhoneJPA);
            } else {
                entityManager.persist(androidPhoneJPA);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean check_if_id_exist(String idToCheck) {
        Android_PhoneJPA androidPhoneJPA = findById(idToCheck);
        if (androidPhoneJPA == null) {
            return false;
        } else {
            return true;
        }
    }

    @Transactional
    @Override
    public Boolean delete_Android_Phone(String idToDelete) {
        try {
            Android_PhoneJPA androidPhoneJPA = findById(idToDelete);
            System.out.println(androidPhoneJPA);
            entityManager.remove(androidPhoneJPA);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Android_PhoneJPA> list_Find_Android_Phone_Similar_By_Id(String id) {
        return entityManager.createNativeQuery("from android_phone where id like :idFind", Android_PhoneJPA.class).setParameter("idFind", id + "%").getResultList();
    }

    @Override
    public List<Android_PhoneJPA> list_Find_Android_Phone_Similar_By_Name(String name) {
        return entityManager.createNativeQuery("from android_phone where name_owner like :name", Android_PhoneJPA.class).setParameter("name", name + "%").getResultList();
    }

    @Override
    public List<Android_PhoneJPA> late_list_android_phone() {
        return entityManager.createNativeQuery("from android_phone where DATEDIFF(CURRENT_DATE(), start_Date) >10 ", Android_PhoneJPA.class).getResultList();
    }

    @Override
    public List<Android_PhoneJPA> near_term_list_android_phone() {
        return entityManager.createNativeQuery("from android_phone where DATEDIFF(CURRENT_DATE(), start_Date) between 8 and 10", Android_PhoneJPA.class).getResultList();
    }

    @Override
    public Boolean extend_interest_payment(String id, Date newDate) {
        Android_PhoneJPA androidPhoneJPA = findById(id);
        androidPhoneJPA.setStart_Date(newDate);
        try {
            entityManager.merge(androidPhoneJPA);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Android_PhoneJPA findById(String id) {
        return entityManager.find(Android_PhoneJPA.class, id);
    }
}

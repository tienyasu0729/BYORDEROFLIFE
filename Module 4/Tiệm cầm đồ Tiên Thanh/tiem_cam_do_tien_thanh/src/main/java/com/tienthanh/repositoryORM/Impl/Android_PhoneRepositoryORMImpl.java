package com.tienthanh.repositoryORM.Impl;

import com.tienthanh.connectionsORM.ConnectionUtilORM;
import com.tienthanh.modelORM.Android_PhoneORM;
import com.tienthanh.repositoryORM.IAndroid_PhoneRepositoryORM;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class Android_PhoneRepositoryORMImpl implements IAndroid_PhoneRepositoryORM {
    @Override
    public List<Android_PhoneORM> displayAndroid_Phone() {
        List<Android_PhoneORM> androidPhoneORMList = new ArrayList<>();
        Session session = ConnectionUtilORM.sessionFactory.openSession();
        TypedQuery<Android_PhoneORM> query = session.createQuery("from Android_PhoneORM order by id", Android_PhoneORM.class);
        androidPhoneORMList = query.getResultList();
        return androidPhoneORMList;
    }

    @Override
    public Boolean add_or_edit_new_android_phone(Android_PhoneORM androidPhoneORM) {
        Session session = ConnectionUtilORM.sessionFactory.openSession();
        try {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.saveOrUpdate(androidPhoneORM);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean check_if_id_exist(String idToCheck) {
        Session session = ConnectionUtilORM.sessionFactory.openSession();
        TypedQuery<Android_PhoneORM> query = session.createQuery("from Android_PhoneORM where id =:idToCheck", Android_PhoneORM.class);
        query.setParameter("idToCheck", idToCheck);
        List<Android_PhoneORM> resultList = query.getResultList();
        return !resultList.isEmpty();
    }

    @Override
    public Boolean delete_Android_Phone(String idToDelete) {
        Session session = ConnectionUtilORM.sessionFactory.openSession();
        try {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            session.delete(session.get(Android_PhoneORM.class, idToDelete));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
//        Query query = session.createQuery("DELETE from Android_PhoneORM where id =: idToDelete",Android_PhoneORM.class);
//        query.setParameter("idToDelete", idToDelete);
    }

    @Override
    public List<Android_PhoneORM> list_Find_Android_Phone_Similar_By_Id(String id) {
        List<Android_PhoneORM> androidPhoneORMList= new ArrayList<>();
        Session session = ConnectionUtilORM.sessionFactory.openSession();
        TypedQuery<Android_PhoneORM> typedQuery = session.createQuery("from Android_PhoneORM where id_of_phone like :  id", Android_PhoneORM.class);
        typedQuery.setParameter("id", id + "%");
        androidPhoneORMList = typedQuery.getResultList();
        return androidPhoneORMList;
    }

    @Override
    public List<Android_PhoneORM> list_Find_Android_Phone_Similar_By_Name(String name) {
        List<Android_PhoneORM> androidPhoneORMList= new ArrayList<>();
        Session session = ConnectionUtilORM.sessionFactory.openSession();
        TypedQuery<Android_PhoneORM> typedQuery = session.createQuery("from Android_PhoneORM where name_owner like : name", Android_PhoneORM.class);
        typedQuery.setParameter("name", name + "%");
        androidPhoneORMList = typedQuery.getResultList();
        return androidPhoneORMList;    }

    @Override
    public List<Android_PhoneORM> late_list_android_phone() {
        List<Android_PhoneORM> androidPhoneORMList = new ArrayList<>();
        Session session = ConnectionUtilORM.sessionFactory.openSession();
        TypedQuery<Android_PhoneORM> typedQuery = session.createQuery("from Android_PhoneORM where DATEDIFF(CURRENT_DATE(), start_Date) >10 ", Android_PhoneORM.class);
        androidPhoneORMList = typedQuery.getResultList();
        return androidPhoneORMList;
    }

    @Override
    public List<Android_PhoneORM> near_term_list_android_phone() {
        List<Android_PhoneORM> androidPhoneORMList = new ArrayList<>();
        Session session = ConnectionUtilORM.sessionFactory.openSession();
        TypedQuery<Android_PhoneORM> typedQuery = session.createQuery("from Android_PhoneORM where DATEDIFF(CURRENT_DATE(), start_Date) between 8 and 10", Android_PhoneORM.class);
        androidPhoneORMList = typedQuery.getResultList();
        return androidPhoneORMList;
    }

//    @Override
//    public Boolean extend_interest_payment(String id, Date newDate) {
//        try {
//            Session session = ConnectionUtilORM.sessionFactory.openSession();
//            Query query = session.createNativeQuery("UPDATE Android_PhoneORM SET  start_Date = :newDate WHERE id = :id", Android_PhoneORM.class);
//            query.setParameter("newDate", newDate);
//            query.setParameter("id", id);
//            int rowsAffected = query.executeUpdate();
//            session.close();
//            return rowsAffected > 0;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return  true;
//    }

    @Override
    public Boolean extend_interest_payment(String id, Date newDate) {
        Session session = ConnectionUtilORM.sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery("UPDATE Android_PhoneORM SET start_Date = :newDate WHERE id = :id");
            query.setParameter("newDate", newDate);
            query.setParameter("id", id);

            int rowsAffected = query.executeUpdate();

            transaction.commit();

            return rowsAffected > 0;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

}

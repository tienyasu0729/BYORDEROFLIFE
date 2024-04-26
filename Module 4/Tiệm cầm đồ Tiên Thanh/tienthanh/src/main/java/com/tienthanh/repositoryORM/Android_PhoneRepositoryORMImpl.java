package com.tienthanh.repositoryORM;

import com.tienthanh.repositoryORM.ConnectionUtilORM;
import com.tienthanh.modelORM.Android_PhoneORM;
import com.tienthanh.repositoryORM.IAndroid_PhoneRepositoryORM;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Android_PhoneRepositoryORMImpl implements IAndroid_PhoneRepositoryORM {
    @Override
    public List<Android_PhoneORM> displayAndroid_Phone() {
        List<Android_PhoneORM> androidPhoneORMList = new ArrayList<>();
        Session session = ConnectionUtilORM.sessionFactory.openSession();
        TypedQuery<Android_PhoneORM> query = session.createQuery("from Android_PhoneORM", Android_PhoneORM.class);
        androidPhoneORMList = query.getResultList();
        return androidPhoneORMList;
    }
}

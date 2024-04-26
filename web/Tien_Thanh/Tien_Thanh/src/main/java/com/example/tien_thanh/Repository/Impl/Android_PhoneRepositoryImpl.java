package com.example.tien_thanh.Repository.Impl;

import com.example.tien_thanh.Connections.BaseRepository;
import com.example.tien_thanh.Repository.Android_PhoneRepository;
import com.example.tien_thanh.model.Android_Phone;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Android_PhoneRepositoryImpl implements Android_PhoneRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private String DISPLAY_ANDROID_PHONE = "select * from android_phone order by android_phone.id desc;";
    private String ADD_NEW_ANDROID_PHONE = "INSERT INTO android_phone(id,name_owner, name_phone, price, start_Date, status, password, note ) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private String DELETE_ANDROID_PHONE_BY_ID = "delete from android_phone where id = ?";
    private String EDIT_ANDROID_PHONE_BY_ID = "UPDATE android_phone SET name_owner = ?,name_phone = ?,price = ?,start_Date = ?,status = ?,password = ?,note = ? WHERE id = ?";
    private String INTEREST_PAYMENT = "UPDATE android_phone SET  start_Date = ? WHERE id = ?";
    private String LIST_FIND_ANDROID_PHONE_SIMILAR_BY_ID = "SELECT * from android_phone where id like ?";
    private String LIST_FIND_ANDROID_PHONE_SIMILAR_BY_NAME = "select * from android_phone where name_owner like ?";
    private String WATCH_LATE_LIST_ANDROID_PHONE = "SELECT * from android_phone where DATEDIFF(CURRENT_DATE(), start_Date) > 10";
    private String WATCH_NEAR_TERM_LIST_ANDROID_PHONE = "SELECT * from android_phone where DATEDIFF(CURRENT_DATE(), start_Date) BETWEEN 8 AND 10";
    private String CHECK_IF_ID_EXIST = "SELECT id from android_phone where id = ?";
    private String CALL_STORED_PROCEDURE_ANDROID_PHONE = "CALL history_for_update__extend_edit_take_product(?);";
//    private String DELETE_HISTORY = "INSERT INTO LichSuThayDoi (Action, DuLieuCu, DuLieuMoi) VALUES (?, ?, ?)";
    private String TAKE_PRODUCT_HISTORY = "";
    private String EDIT_HISTORY = "";
    private String EXTEND_HISTORY = "";
    @Override
    public void interest_payment(String id, Date date) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(INTEREST_PAYMENT);
            preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Android_Phone> displayAndroid_Phone() {
        List<Android_Phone> androidPhoneList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DISPLAY_ANDROID_PHONE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name_owner = resultSet.getString("name_owner");
                String name_phone = resultSet.getString("name_phone");
                String id_of_phone = resultSet.getString("id_of_phone");
                int price = resultSet.getInt("price");
                Date start_Date  = new Date(resultSet.getDate("start_Date").getTime());
                String phone_number_owner = resultSet.getString("phone_number_owner");
                String status = resultSet.getString("status");
                String password = resultSet.getString("password");
                String note = resultSet.getString("note");
                androidPhoneList.add(new Android_Phone(id,name_owner,name_phone,id_of_phone,price,start_Date,phone_number_owner,status,password,note));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return androidPhoneList;
    }

    @Override
    public void add_New_Android_Phone(Android_Phone android_phone) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(ADD_NEW_ANDROID_PHONE);
            preparedStatement.setString(1, android_phone.getId());
            preparedStatement.setString(2, android_phone.getName_owner());
            preparedStatement.setString(3, android_phone.getName_phone());
            preparedStatement.setInt(4, android_phone.getPrice());
            preparedStatement.setDate(5, new java.sql.Date(android_phone.getStart_Date().getTime()));
            preparedStatement.setString(6, android_phone.getStatus());
            preparedStatement.setString(7, android_phone.getPassword());
            preparedStatement.setString(8, android_phone.getNote());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit_Android_Phone(Android_Phone android_phone) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(EDIT_ANDROID_PHONE_BY_ID);
            preparedStatement.setString(1,android_phone.getName_owner());
            preparedStatement.setString(2,android_phone.getName_phone());
            preparedStatement.setInt(3,android_phone.getPrice());
            preparedStatement.setDate(4,new java.sql.Date(android_phone.getStart_Date().getTime()));
            preparedStatement.setString(5,android_phone.getStatus());
            preparedStatement.setString(6,android_phone.getPassword());
            preparedStatement.setString(7,android_phone.getNote());
            preparedStatement.setString(8,android_phone.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete_Android_Phone(String id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DELETE_ANDROID_PHONE_BY_ID);
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();

//            PreparedStatement insertStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(DELETE_HISTORY);
//            insertStatement.setString(1, "DELETE");
//            insertStatement.setString(2, "{'DAS': 'SADASDA'}");
//            insertStatement.setString(3, "{'DĐ': 'DDD'  }");
//            insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stored_procedure(String action) {
        try {
            CallableStatement callableStatement = this.baseRepository.getConnectionJavaToDB().prepareCall(CALL_STORED_PROCEDURE_ANDROID_PHONE);
            callableStatement.setString(1,action);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Boolean check_if_id_exist(String idToCheck) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(CHECK_IF_ID_EXIST);
            preparedStatement.setString(1,idToCheck);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Android_Phone> list_Find_Android_Phone_Similar_By_Id(String id) {
        List<Android_Phone> androidPhoneList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(LIST_FIND_ANDROID_PHONE_SIMILAR_BY_ID);
            preparedStatement.setString(1, id + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String find_by_id = resultSet.getString("id");
                String name_owner = resultSet.getString("name_owner");
                String name_phone = resultSet.getString("name_phone");
                String id_of_phone = resultSet.getString("id_of_phone");
                int price = resultSet.getInt("price");
                Date start_Date  = new Date(resultSet.getDate("start_Date").getTime());
                String phone_number_owner = resultSet.getString("phone_number_owner");
                String status = resultSet.getString("status");
                String password = resultSet.getString("password");
                String note = resultSet.getString("note");
                androidPhoneList.add(new Android_Phone(find_by_id,name_owner,name_phone,id_of_phone,price,start_Date,phone_number_owner,status,password,note));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return androidPhoneList;
    }

    @Override
    public List<Android_Phone> list_Find_Android_Phone_Similar_By_Name(String name) {
        List<Android_Phone> androidPhoneList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(LIST_FIND_ANDROID_PHONE_SIMILAR_BY_NAME);
            preparedStatement.setString(1, name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name_owner = resultSet.getString("name_owner");
                String name_phone = resultSet.getString("name_phone");
                String id_of_phone = resultSet.getString("id_of_phone");
                int price = resultSet.getInt("price");
                Date start_Date  = new Date(resultSet.getDate("start_Date").getTime());
                String phone_number_owner = resultSet.getString("phone_number_owner");
                String status = resultSet.getString("status");
                String password = resultSet.getString("password");
                String note = resultSet.getString("note");
                androidPhoneList.add(new Android_Phone(id,name_owner,name_phone,id_of_phone,price,start_Date,phone_number_owner,status,password,note));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return androidPhoneList;
    }

    @Override
    public List<Android_Phone> late_list_android_phone() {
        List<Android_Phone> androidPhoneList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(WATCH_LATE_LIST_ANDROID_PHONE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name_owner = resultSet.getString("name_owner");
                String name_phone = resultSet.getString("name_phone");
                String id_of_phone = resultSet.getString("id_of_phone");
                int price = resultSet.getInt("price");
                Date start_Date  = new Date(resultSet.getDate("start_Date").getTime());
                String phone_number_owner = resultSet.getString("phone_number_owner");
                String status = resultSet.getString("status");
                String password = resultSet.getString("password");
                String note = resultSet.getString("note");
                androidPhoneList.add(new Android_Phone(id,name_owner,name_phone,id_of_phone,price,start_Date,phone_number_owner,status,password,note));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return androidPhoneList;
    }

    @Override
    public List<Android_Phone> near_term_list_android_phone() {
        List<Android_Phone> androidPhoneList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement(WATCH_NEAR_TERM_LIST_ANDROID_PHONE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name_owner = resultSet.getString("name_owner");
                String name_phone = resultSet.getString("name_phone");
                String id_of_phone = resultSet.getString("id_of_phone");
                int price = resultSet.getInt("price");
                Date start_Date = new Date(resultSet.getDate("start_Date").getTime());
                String phone_number_owner = resultSet.getString("phone_number_owner");
                String status = resultSet.getString("status");
                String password = resultSet.getString("password");
                String note = resultSet.getString("note");
                androidPhoneList.add(new Android_Phone(id,name_owner,name_phone,id_of_phone,price,start_Date,phone_number_owner,status,password,note));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return androidPhoneList;
    }
}

package com.example.demo_quan_ly_nhan_vien.repository;

import com.example.demo_quan_ly_nhan_vien.model.CongViec;
import com.example.demo_quan_ly_nhan_vien.model.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo_quan_ly_nhan_vien.ultil.ConnectionUtils.getConnection;

public class CongViecRepositoryImpl implements CongViecRepository{
    private static final String SELECT_ALL_CONG_VIEC = "Select * from Cong_Viec";
    private static final String SELECT_CONG_VIEC_BY_ID = "Select * from Cong_Viec where ma_cong_viec = ?";

    @Override
    public CongViec findById(String maCongViec) {
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONG_VIEC_BY_ID)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, maCongViec);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            if (rs.next()) {
                String tenCongViec = rs.getString("ten_cong_viec");
                double luongThapNhat = rs.getDouble("luong_thap_nhat");
                double luongCaoNhat = rs.getDouble("luong_cao_nhat");
                return new CongViec(maCongViec, tenCongViec, luongThapNhat, luongCaoNhat);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return null;
    }

    @Override
    public List<CongViec> findAll() {
        List<CongViec> congViecList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONG_VIEC)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String maCongViec = rs.getString("ma_cong_viec");
                String tenCongViec = rs.getString("ten_cong_viec");
                double luongThapNhat = rs.getDouble("luong_thap_nhat");
                double luongCaoNhat = rs.getDouble("luong_cao_nhat");
                congViecList.add(new CongViec(maCongViec, tenCongViec, luongThapNhat, luongCaoNhat));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return congViecList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

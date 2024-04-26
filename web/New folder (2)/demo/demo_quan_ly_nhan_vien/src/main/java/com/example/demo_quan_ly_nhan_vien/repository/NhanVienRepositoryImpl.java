package com.example.demo_quan_ly_nhan_vien.repository;

import com.example.demo_quan_ly_nhan_vien.model.CongViec;
import com.example.demo_quan_ly_nhan_vien.model.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo_quan_ly_nhan_vien.ultil.ConnectionUtils.getConnection;

public class NhanVienRepositoryImpl implements NhanVienRepository {
    private CongViecRepository congViecRepository = new CongViecRepositoryImpl();

    private static final String SELECT_ALL_NHAN_VIEN = "select *\n" +
            "from nhan_vien \n" +
            "\tjoin cong_viec on nhan_vien.ma_cong_viec = cong_viec.ma_cong_viec;";
    private static final String INSERT_USERS_SQL = "INSERT INTO nhan_vien(ma_nhan_vien, ho_ten, ngay_sinh, dia_chi, " +
            "ngay_bat_dau_lam, ngay_ket_thuc_lam, luong, ma_cong_viec) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";



    @Override
    public void add(NhanVien nhanVien) {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, nhanVien.getMaNhanVien());
            preparedStatement.setString(2, nhanVien.getHoTen());
            preparedStatement.setDate(3, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            preparedStatement.setString(4, nhanVien.getDiaChi());
            preparedStatement.setDate(5, new java.sql.Date(nhanVien.getNgayBatDauLam().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(nhanVien.getNgayKetThucLam().getTime()));
            preparedStatement.setDouble(7, nhanVien.getLuong());
            preparedStatement.setString(8, nhanVien.getMaCongViec().getMaCongViec());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void update(NhanVien nhanVien) {

    }

    @Override
    public List<NhanVien> findAll() {
// using try-with-resources to avoid closing resources (boiler plate code)
        List<NhanVien> nhanVienList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NHAN_VIEN)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String maNhanVien = rs.getString("ma_nhan_vien");
                String hoTen = rs.getString("ho_ten");
                Date ngaySinh = new Date(rs.getDate("ngay_sinh").getTime());
                String diaChi = rs.getString("dia_chi");
                Date ngayBatDauLam = new Date(rs.getDate("ngay_bat_dau_lam").getTime());
                Date ngayKetThucLam = new Date(rs.getDate("ngay_ket_thuc_lam").getTime());
                double luong = rs.getDouble("luong");
                String maCongViec = rs.getString("ma_cong_viec");
                CongViec congViec = congViecRepository.findById(maCongViec);
                nhanVienList.add(new NhanVien(maNhanVien, hoTen, ngaySinh, diaChi, ngayBatDauLam, ngayKetThucLam, luong, congViec));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return nhanVienList;
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

    @Override
    public List<NhanVien> findByTenCongViec(String tenCongViec) {
        return null;
    }

    @Override
    public List<NhanVien> findByNgayLamVaNgayKetThuc(String ngayBatDauLam, String ngayKetThucLam) {
        return null;
    }
}

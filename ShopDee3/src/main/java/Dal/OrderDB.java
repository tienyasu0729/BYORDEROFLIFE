/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Han
 */
public class OrderDB extends DBContext {
    
    public List<Order> getAllOrder(){
        List<Order> listOrder= new ArrayList<>();
        String query= "SELECT * FROM [Order]";
        try{
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order od= new Order();
                od.setOrderID(rs.getInt("OrderID"));
                od.setOrderDate(rs.getDate("OrderDate"));
                od.setStatus(rs.getString("Status"));
                od.setTotal(rs.getDouble("Total")); 
                od.setVoucher(rs.getString("VoucherCode"));
                od.setNameReceiver(rs.getString("NameReciever"));
                String addrReciever= rs.getString("AddrReciever");
                listOrder.add(od);
            }
        }catch(SQLException ex){
            System.err.println(ex);
        }
        
        return listOrder;
    }
    
    public void addOrder(Order o){
        String query= "INSERT INTO [Order](OrderDate, Total, Status, VoucherCode, NameReciever, AddrReciever, PhoneReciever, CartID)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setDate(1, new java.sql.Date(o.getOrderDate().getTime()));
            stm.setDouble(2, o.getTotal());
            stm.setString(3, o.getStatus());
            stm.setString(4, o.getVoucher());
            stm.setString(5, o.getNameReceiver());
            stm.setString(6, o.getAddrReceiver());
            stm.setString(7, o.getPhoneReceiver());
            stm.setInt(8, o.getCartID());

            int rs = stm.executeUpdate();
            if (rs <= 0) {
                throw new RuntimeException("Insert fail...");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public static void main(String[] args) {
        OrderDB oDB= new OrderDB();
        List<Order> oL = oDB.getAllOrder();
        for(Order o: oL){
            System.out.println(o);
        }
        
    }
    
}

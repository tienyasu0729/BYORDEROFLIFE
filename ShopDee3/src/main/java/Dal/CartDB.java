/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Cart_Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Han
 */
public class CartDB extends DBContext {

    public List<Cart_Item> getCartByName(String userName) {
        List<Cart_Item> cartL = new ArrayList<>();
        String sql = " Select * FROM ShoppingCart sc" +
                " JOIN CartDetail cd ON sc.CartID = cd.CartID" +
               " JOIN Product p ON cd.ProductID = p.ProductID " +
                "WHERE sc.UserName = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cart_Item c = new Cart_Item();
                c.setCartDetailID(rs.getInt("CartDetailID"));
                c.setCartID(rs.getInt("CartDetailID"));
                c.setProductName(rs.getString("ProductName"));
                c.setPrice(rs.getDouble("Price"));
                c.setColor(rs.getString("Color"));
                c.setCartImg(rs.getString("ProductImg"));
                c.setSize(rs.getString("Size"));
                c.setQuantity(rs.getInt("Quantity"));
                cartL.add(c);
            }

        } catch (Exception e) {

        }
        return cartL;
    }
    
    public void updateQuantityCart(int cartDetailID, int newQuantity){
        String sql = "UPDATE CartDetail SET Quantity = ? WHERE CartDetailID = ?";
       
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, newQuantity);
            statement.setInt(2, cartDetailID);
            
            statement.executeUpdate();
        }catch(Exception e){
            
        }
    }
    
    public static void main(String[] args) {
        CartDB c= new CartDB();
        List<Cart_Item> cartL =c.getCartByName("user1");
        for(Cart_Item p: cartL){
        System.err.println(p);
    }
    }
}

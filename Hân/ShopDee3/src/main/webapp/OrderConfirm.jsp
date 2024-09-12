<%@page import="Model.Product"%>
<%@ page import="java.util.List" %>
<%@ page import="com.yourpackage.Product" %>

<%
    HttpSession session = request.getSession();
    List<Product> selectedItems = (List<Product>) session.getAttribute("selectedItems");
    String name = (String) session.getAttribute("name");
    String phone = (String) session.getAttribute("phone");
    String city = (String) session.getAttribute("city");
    String street = (String) session.getAttribute("street");
    String houseNumber = (String) session.getAttribute("houseNumber");
    String paymentMethod = (String) session.getAttribute("paymentMethod");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Confirmation</title>
    <!-- Include necessary styles and scripts -->
</head>
<body>
    <h2>Order Confirmation</h2>
    <h3>Thông tin ng??i nh?n</h3>
    <p><strong>Tên:</strong> <%= name %></p>
    <p><strong>?i?n tho?i:</strong> <%= phone %></p>
    <p><strong>Thành ph?:</strong> <%= city %></p>
    <p><strong>Tên ???ng:</strong> <%= street %></p>
    <p><strong>S? nhà:</strong> <%= houseNumber %></p>
    
    <h3>Danh sách s?n ph?m</h3>
    <table>
        <tr>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        <% if (selectedItems != null && !selectedItems.isEmpty()) { %>
            <% for (Product item : selectedItems) { %>
                <tr>
                    <td><%= item.getProductName() %></td>
                    <td>$ <%= String.format("%.2f", item.getPrice()) %></td>
                    <td>1</td> <!-- Assume quantity is always 1 for now -->
                    <td>$ <%= String.format("%.2f", item.getPrice()) %></td>
                </tr>
            <% } %>
        <% } else { %>
            <tr>
                <td colspan="4">No items selected.</td>
            </tr>
        <% } %>
    </table>
    
    <h3>T?ng c?ng: $79.65</h3> <!-- T?ng c?ng th?c t? c?n tính d?a trên giá tr? trong session -->

    <form action="ProcessPaymentServlet" method="post">
        <input type="hidden" name="paymentMethod" value="<%= paymentMethod %>">
        <button type="submit">Proceed to Payment</button>
    </form>

    <form action="shopping-cart.jsp">
        <button type="submit">Back to Cart</button>
    </form>
</body>
</html>

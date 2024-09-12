<%-- 
    Document   : shopCart
    Created on : Jun 12, 2024, 11:22:32 PM
    Author     : Han
--%>

<%@page import="Model.Cart_Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          

                                    <%   Double total = 0.0;
                                        List<Cart_Item> cartL= (List<Cart_Item>)request.getAttribute("cartList");
                                        if (cartL != null && !cartL.isEmpty()) {
                                        
                                    %>
                                    <h1>yes</h1>
                                    <% }else { %>
                                    <h1>no</h1>
                                    <% }%>    


    </body>
</html>

<%@ page import="java.sql.*" %>
<%@ page session="true" %>
<html>
<head><title>View Orders</title></head>
<body>
    <h2>Your Orders</h2>
    <table border="1">
        <tr><th>Order ID</th><th>Item</th><th>Quantity</th><th>Customer</th><th>Status</th></tr>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("orders");
            while (rs != null && rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("item_name") %></td>
            <td><%= rs.getInt("quantity") %></td>
            <td><%= rs.getString("customer_name") %></td>
            <td><%= rs.getString("status") %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>

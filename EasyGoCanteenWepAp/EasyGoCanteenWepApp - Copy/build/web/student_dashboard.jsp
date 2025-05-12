<%@ page session="true" %>
<%@ page isErrorPage="false" %>
<%
    if (session.getAttribute("role") == null || !session.getAttribute("role").equals("Student")) {
        response.sendRedirect("index.html");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
</head>
<body style="font-family: Arial, sans-serif; background: #f0f8ff; margin: 0; padding: 0; display: flex; flex-direction: column; align-items: center;">

    <div style="width: 100%; background: #007bff; color: white; padding: 20px; text-align: center;">
        <h1>Welcome, <%= session.getAttribute("userName") %> (Student)</h1>
    </div>

    <div style="margin-top: 40px; display: flex; gap: 20px; flex-wrap: wrap; justify-content: center;">
        <a href="view_orders.jsp" style="background: #28a745; color: white; padding: 15px 30px; border-radius: 8px; text-decoration: none;">View Menu</a>
        <a href="place_order.jsp" style="background: #17a2b8; color: white; padding: 15px 30px; border-radius: 8px; text-decoration: none;">Place Order</a>
        <a href="order_history.jsp" style="background: #ffc107; color: white; padding: 15px 30px; border-radius: 8px; text-decoration: none;">Order History</a>
        <a href="logout.jsp" style="background: #dc3545; color: white; padding: 15px 30px; border-radius: 8px; text-decoration: none;">Logout</a>
    </div>

</body>
</html>

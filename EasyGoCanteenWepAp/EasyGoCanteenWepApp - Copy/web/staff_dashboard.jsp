<%@ page session="true" %>
<%
    String staffName = (String) session.getAttribute("userName");
    if (staffName == null) {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Staff Dashboard - Easy-Go Canteen</title>
</head>
<body style="margin: 0; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(to right, #f0f4f8, #ffffff);">

    <div style="background-color: #007bff; padding: 20px; text-align: center; color: white;">
        <h1 style="margin: 0;">Staff Dashboard</h1>
        <p>Welcome, <strong><%= staffName %></strong> </p>
    </div>

    <div style="padding: 40px; text-align: center;">
        <h2 style="color: #333;">Your Actions</h2>
        <div style="display: flex; flex-wrap: wrap; justify-content: center; gap: 20px; margin-top: 30px;">
            <a href="view_orders.jsp" style="padding: 20px; background-color: #28a745; color: white; text-decoration: none; border-radius: 8px; width: 200px; display: inline-block; font-weight: bold;">View Orders</a>
            <a href="manage_customers.jsp" style="padding: 20px; background-color: #17a2b8; color: white; text-decoration: none; border-radius: 8px; width: 200px; display: inline-block; font-weight: bold;">Manage Customers</a>
            <a href="update_profile.jsp" style="padding: 20px; background-color: #ffc107; color: white; text-decoration: none; border-radius: 8px; width: 200px; display: inline-block; font-weight: bold;">Update Profile</a>
        </div>
    </div>

    <div style="text-align: center; margin-top: 50px;">
        <a href="logout.jsp" style="color: #dc3545; text-decoration: none; font-weight: bold;">Logout</a>
    </div>

    <footer style="position: fixed; bottom: 10px; width: 100%; text-align: center; color: #aaa; font-size: 14px;">
        &copy; 2025 Easy-Go Canteen System. All rights reserved.
    </footer>

</body>
</html>

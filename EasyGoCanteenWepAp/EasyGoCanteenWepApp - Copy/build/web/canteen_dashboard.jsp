<%@ page session="true" %>
<%
    String canteenName = (String) session.getAttribute("userName");
    if (canteenName == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Canteen Dashboard - Easy-Go</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 0; padding: 0; background: linear-gradient(to right, #f8f9fa, #ffffff);">
    
    <div style="background-color: #007bff; padding: 20px; color: white; text-align: center;">
        <h1>Welcome, <%= canteenName %> (Canteen)</h1>
        <p style="margin-top: 10px;">Easy-Go Canteen Management Dashboard</p>
    </div>

    <div style="padding: 40px; text-align: center;">
        <h2 style="color: #333;">Dashboard Features</h2>

        <div style="display: flex; justify-content: center; flex-wrap: wrap; gap: 30px; margin-top: 30px;">
            <a href="ViewOrdersServlet" style="background-color: #28a745; color: white; padding: 20px 30px; border-radius: 8px; text-decoration: none; font-weight: bold;">View Orders</a>
            <a href="ManageMenuServlet" style="background-color: #ffc107; color: black; padding: 20px 30px; border-radius: 8px; text-decoration: none; font-weight: bold;">Manage Menu</a>
            <a href="updateMenu.jsp" style="background-color: #17a2b8; color: white; padding: 20px 30px; border-radius: 8px; text-decoration: none; font-weight: bold;">Update Stock</a>
            <a href="#" style="background-color: #dc3545; color: white; padding: 20px 30px; border-radius: 8px; text-decoration: none; font-weight: bold;">Feedback</a>
        </div>

        <div style="margin-top: 50px;">
            <form action="logout.jsp" method="post">
                <input type="submit" value="Logout" style="background-color: #343a40; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer;">
            </form>
        </div>
    </div>

    <footer style="text-align: center; padding: 20px; background-color: #f1f1f1; color: #666; font-size: 14px;">
        &copy; 2025 Easy-Go Canteen System. All rights reserved.
    </footer>

</body>
</html>

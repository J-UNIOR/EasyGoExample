<%@ page session="true" %>
<%
    String corpName = (String) session.getAttribute("userName");
    if (corpName == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Corporate/School Dashboard - Easy-Go</title>
</head>
<body style="margin: 0; font-family: 'Segoe UI', sans-serif; background: linear-gradient(to right, #e3f2fd, #ffffff);">

    <div style="background-color: #343a40; padding: 25px; color: white; text-align: center;">
        <h1>Welcome, <%= corpName %> (Corporate/School)</h1>
        <p>Manage your group or institution orders with Easy-Go</p>
    </div>

    <div style="padding: 50px; text-align: center;">
        <h2 style="color: #333;">Corporate Tools</h2>

        <div style="display: flex; flex-wrap: wrap; justify-content: center; gap: 30px; margin-top: 30px;">
            <a href="#" style="background-color: #007bff; color: white; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;">Place Group Order</a>
            <a href="#" style="background-color: #28a745; color: white; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;">Order History</a>
            <a href="#" style="background-color: #ffc107; color: black; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;">Invoices</a>
            <a href="#" style="background-color: #17a2b8; color: white; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;">Support</a>
        </div>

        <div style="margin-top: 50px;">
            <form action="logout.jsp" method="post">
                <input type="submit" value="Logout" style="background-color: #dc3545; color: white; padding: 12px 24px; border: none; border-radius: 5px; cursor: pointer;">
            </form>
        </div>
    </div>

    <footer style="text-align: center; padding: 20px; background-color: #f8f9fa; color: #6c757d; font-size: 14px;">
        &copy; 2025 Easy-Go Canteen System | Corporate & School Services
    </footer>

</body>
</html>

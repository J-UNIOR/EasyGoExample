<%@ page session="true" %>
<%@ include file="deliverySessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delivery Dashboard - Easy-Go</title>
</head>
<body style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin: 0; padding: 0; background: linear-gradient(to right, #ffffff, #f3f6f9);">

    <div style="background-color: #28a745; padding: 20px; color: white; text-align: center;">
        <h1>Hello, <%= session.getAttribute("userName") %> (Delivery Personnel)</h1>
        <p>Welcome to your Easy-Go Delivery Dashboard</p>
    </div>

    <div style="padding: 40px; text-align: center;">
        <h2 style="color: #333;">Delivery Management Tools</h2>

        <div style="display: flex; justify-content: center; flex-wrap: wrap; gap: 30px; margin-top: 30px;">
            <a href="assignedDeliveries.jsp" style="background-color: #007bff; color: white; padding: 20px 30px; border-radius: 8px; text-decoration: none; font-weight: bold;">Assigned Deliveries</a>
            <a href="updateDeliveryStatus.jsp" style="background-color: #ffc107; color: black; padding: 20px 30px; border-radius: 8px; text-decoration: none; font-weight: bold;">Update Delivery Status</a>
            <a href="deliveryHistory.jsp" style="background-color: #17a2b8; color: white; padding: 20px 30px; border-radius: 8px; text-decoration: none; font-weight: bold;">Delivery History</a>
            <a href="support.jsp" style="background-color: #6c757d; color: white; padding: 20px 30px; border-radius: 8px; text-decoration: none; font-weight: bold;">Support</a>
        </div>

        <div style="margin-top: 50px;">
            <form action="logout.jsp" method="post">
                <input type="submit" value="Logout" style="background-color: #dc3545; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer;">
            </form>
        </div>
    </div>

    <footer style="text-align: center; padding: 20px; background-color: #f1f1f1; color: #777; font-size: 14px;">
        &copy; 2025 Easy-Go Canteen System. All rights reserved.
    </footer>

</body>
</html>

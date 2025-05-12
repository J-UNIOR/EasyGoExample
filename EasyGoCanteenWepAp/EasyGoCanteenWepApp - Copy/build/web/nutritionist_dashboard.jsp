<%@ page session="true" %>
<%
    String nutritionistName = (String) session.getAttribute("userName");
    if (nutritionistName == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nutritionist Dashboard - Easy-Go</title>
</head>
<body style="margin: 0; font-family: 'Segoe UI', sans-serif; background: linear-gradient(to right, #fdfbfb, #ebedee);">

    <div style="background-color: #6f42c1; padding: 25px; color: white; text-align: center;">
        <h1>Welcome, <%= nutritionistName %> (Nutritionist/Dietitian)</h1>
        <p>Your personalized nutrition & diet management portal</p>
    </div>

    <div style="padding: 50px; text-align: center;">
        <h2 style="color: #333;">Nutrition Tools</h2>

        <div style="display: flex; flex-wrap: wrap; justify-content: center; gap: 30px; margin-top: 30px;">
            <a href="createDietPlan.jsp" style="background-color: #20c997; color: white; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;">Create Diet Plan</a>
            <a href="viewSubmissions.jsp" style="background-color: #fd7e14; color: white; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;">View Submissions</a>
            <a href="healthReports.jsp" style="background-color: #17a2b8; color: white; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;">Health Reports</a>
            <a href="consultationHistory.jsp" style="background-color: #007bff; color: white; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;">Consultation History</a>
        </div>

        <div style="margin-top: 50px;">
            <form action="logout.jsp" method="post">
                <input type="submit" value="Logout" style="background-color: #dc3545; color: white; padding: 12px 24px; border: none; border-radius: 5px; cursor: pointer;">
            </form>
        </div>
    </div>

    <footer style="text-align: center; padding: 20px; background-color: #f8f9fa; color: #6c757d; font-size: 14px;">
        &copy; 2025 Easy-Go Canteen System | Nutrition Services
    </footer>

</body>
</html>

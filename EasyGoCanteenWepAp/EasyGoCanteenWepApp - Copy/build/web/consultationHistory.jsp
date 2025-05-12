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
    <title>Consultation History - Nutritionist Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #fdfbfb, #ebedee);
        }
        .container {
            padding: 50px;
            text-align: center;
        }
    </style>
</head>
<body>

    <div style="background-color: #6f42c1; padding: 25px; color: white; text-align: center;">
        <h1>Welcome, <%= nutritionistName %> (Nutritionist/Dietitian)</h1>
        <p>Review your past consultations</p>
    </div>

    <div class="container">
        <h2>Consultation History</h2>
        <table border="1" cellpadding="10" cellspacing="0" style="margin: 0 auto;">
            <thead>
                <tr>
                    <th>Client Name</th>
                    <th>Date of Consultation</th>
                    <th>Notes</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Omphile</td>
                    <td>2025-04-20</td>
                    <td>Discussed low-carb diet options.</td>
                </tr>
                <tr>
                    <td>Nelson</td>
                    <td>2025-04-22</td>
                    <td>Discussed weight gain plan.</td>
                </tr>
            </tbody>
        </table>
    </div>

</body>
</html>

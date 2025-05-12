<%@ page import="java.sql.*" %>
<%@ page session="true" %>
<%
    String nutritionist = (String) session.getAttribute("userName");
    if (nutritionist == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Your Diet Plans</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            margin: 0;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
        .plan-box {
            background: #ffffff;
            border: 1px solid #ddd;
            border-radius: 8px;
            margin: 15px auto;
            padding: 15px;
            max-width: 700px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
        }
        .plan-box h4 {
            margin-top: 0;
            color: #2980b9;
        }
        .plan-box p {
            font-size: 14px;
            color: #555;
        }
        ul {
            padding-left: 20px;
            margin: 10px 0;
        }
        li {
            line-height: 1.6;
        }
    </style>
</head>
<body>
<h2>Submitted Diet Plans</h2>
<%
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/EasyGoCanteenDB", "administrator", "admin@123");

        PreparedStatement ps = conn.prepareStatement("SELECT plan_id, description, created_at FROM diet_plan WHERE nutritionist = ?");
        ps.setString(1, nutritionist);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int planId = rs.getInt("plan_id");
            String desc = rs.getString("description");
            Timestamp date = rs.getTimestamp("created_at");

            out.println("<div class='plan-box'>");
            out.println("<h4>Plan ID: " + planId + " | " + date + "</h4>");
            out.println("<p><strong>Description:</strong> " + desc + "</p>");
            out.println("<ul>");

            PreparedStatement itemsStmt = conn.prepareStatement(
                "SELECT name FROM menu WHERE id IN (SELECT menu_id FROM diet_plan_menu WHERE plan_id = ?)");
            itemsStmt.setInt(1, planId);
            ResultSet items = itemsStmt.executeQuery();

            while (items.next()) {
                out.println("<li>" + items.getString("name") + "</li>");
            }

            itemsStmt.close();
            out.println("</ul></div>");
        }

        conn.close();
    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    }
%>
</body>
</html>

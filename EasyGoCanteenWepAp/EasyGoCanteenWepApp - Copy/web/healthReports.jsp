<%@ page import="java.sql.*" %>
<%@ page session="true" %>
<%
    String nutritionistName = (String) session.getAttribute("userName");
    if (nutritionistName == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Database connection
    String dbURL = "jdbc:derby://localhost:1527/easygoCanteenDB";
    String dbUser = "administrator";
    String dbPass = "admin@123";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Health Reports - Easy-Go</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f4f4f4;
            padding: 20px;
        }
        .container {
            background: white;
            border-radius: 8px;
            padding: 30px;
            max-width: 900px;
            margin: auto;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        h2 {
            color: #6f42c1;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 25px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #6f42c1;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f8f8f8;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Healthy Food Recommendations</h2>
    <p>Based on the food items available in stock:</p>
    <table>
        <tr>
            <th>Food Name</th>
            <th>Description</th>
            <th>Price (R)</th>
        </tr>
        <%
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                String sql = "SELECT name, description, price FROM menu ORDER BY price ASC";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("description") %></td>
            <td><%= rs.getDouble("price") %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
                out.println("<tr><td colspan='3'>Error: " + e.getMessage() + "</td></tr>");
            } finally {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            }
        %>
    </table>
</div>
</body>
</html>

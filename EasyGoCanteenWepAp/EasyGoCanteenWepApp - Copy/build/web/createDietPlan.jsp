<%@ page import="java.sql.*" %>
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
    <title>Create Diet Plan</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 70%;
            margin: 50px auto;
            background: #fff;
            padding: 30px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 10px;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        label {
            font-weight: bold;
        }
        textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
            resize: vertical;
        }
        .food-list {
            margin-top: 20px;
        }
        .food-item {
            margin-bottom: 10px;
        }
        input[type="checkbox"] {
            margin-right: 10px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 12px 25px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Create Diet Plan</h2>
    <form action="saveDietPlan.jsp" method="post">
        <label>Plan Description:</label><br>
        <textarea name="description" rows="4" required></textarea><br><br>

        <label>Select Foods to Recommend:</label><br>
        <div class="food-list">
            <%
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/EasyGoCanteenDB", "administrator", "admin@123");

                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT id, name, description, price FROM menu");

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String desc = rs.getString("description");
                        double price = rs.getDouble("price");
            %>
                <div class="food-item">
                    <input type="checkbox" name="selectedItems" value="<%=id%>">
                    <strong><%=name%></strong> - <%=desc%> - R<%=price%>
                </div>
            <%
                    }
                    rs.close();
                    conn.close();
                } catch (Exception e) {
            %>
                <div class="error">Error: <%= e.getMessage() %></div>
            <%
                }
            %>
        </div>
        <br><input type="submit" value="Save Plan">
    </form>
</div>
</body>
</html>

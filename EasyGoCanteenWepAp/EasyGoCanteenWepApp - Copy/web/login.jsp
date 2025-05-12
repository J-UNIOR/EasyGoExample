<%@ page import="java.sql.*, util.DBConnection" %>
<%@ page session="true" %>
<%
    String role = request.getParameter("role");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (role == null || role.trim().equals("")) {
        response.sendRedirect("index.html");
        return;
    }

    if (email != null && password != null) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM \"User\" WHERE email = ? AND password = ? AND role = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, role);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                session.setAttribute("userId", rs.getInt("userId"));
                session.setAttribute("userName", rs.getString("name"));
                session.setAttribute("userEmail", rs.getString("email"));
                session.setAttribute("role", rs.getString("role"));

                String dash = role.toLowerCase().replace("/", "").replace(" ", "_") + "_dashboard.jsp";
                response.sendRedirect(dash);
                return;
            } else {
%>
                <p style="color:red; text-align:center;">Invalid credentials for <%= role %>. Please try again.</p>
<%
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
%>
            <p style="color:red; text-align:center;">Error: <%= e.getMessage() %></p>
<%
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title><%= role %> Login - EasyGo</title>
</head>
<body style="font-family: Arial, sans-serif; background: linear-gradient(to right, #f9f9f9, #dfefff); display: flex; flex-direction: column; align-items: center; justify-content: center; height: 100vh;">

    <div style="background: white; padding: 30px; border-radius: 10px; box-shadow: 0 0 12px rgba(0,0,0,0.1); width: 350px; text-align: center;">
        <h2 style="color: #333; margin-bottom: 20px;"><%= role %> Login</h2>

        <form method="post" action="login.jsp?role=<%= role %>">
            <input type="email" name="email" placeholder="Email" required style="width: 100%; padding: 10px; margin-bottom: 15px; border-radius: 6px; border: 1px solid #ccc;"><br>

            <input type="password" name="password" placeholder="Password" required style="width: 100%; padding: 10px; margin-bottom: 20px; border-radius: 6px; border: 1px solid #ccc;"><br>

            <input type="submit" value="Login" style="width: 100%; padding: 12px; background-color: #007bff; color: white; border: none; border-radius: 6px; font-weight: bold; cursor: pointer;">
        </form>

        <p style="margin-top: 15px;">
            Not registered yet?
            <a href="register.jsp" style="color: #007bff; text-decoration: none;">Sign up here</a>
        </p>
    </div>

</body>
</html>

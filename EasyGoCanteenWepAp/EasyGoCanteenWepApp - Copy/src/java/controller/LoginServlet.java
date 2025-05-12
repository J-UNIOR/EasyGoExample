package controller;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import javax.servlet.*;
import javax.servlet.http.*;
import util.DBConnection;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM \"User\" WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password); // Make sure to hash if passwords are hashed
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                int userId = rs.getInt("userId");
                String name = rs.getString("name");

                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                session.setAttribute("userName", name);
                session.setAttribute("userEmail", email);
                session.setAttribute("role", role);

                // Log login
                String logSql = "INSERT INTO LoginLog (userId, loginTime, activity) VALUES (?, ?, ?)";
                PreparedStatement logPs = conn.prepareStatement(logSql);
                logPs.setInt(1, userId);
                logPs.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                logPs.setString(3, "Logged in");
                logPs.executeUpdate();

                if ("Administrator".equals(role)) {
                    response.sendRedirect("administrator_dashboard.jsp");
                } else if ("Customer".equals(role)) {
                    response.sendRedirect("customer_dashboard.jsp");
                } else {
                    response.sendRedirect("dashboard.jsp");
                }
            } else {
                request.setAttribute("error", "Invalid email or password.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

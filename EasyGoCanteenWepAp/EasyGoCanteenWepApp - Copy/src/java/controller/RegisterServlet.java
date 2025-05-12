package controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import util.DBConnection;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");

        try {
            Connection conn = DBConnection.getConnection();

            // Generate random user ID between 10000 and 99999
            int userId = (int)(Math.random() * 90000 + 10000);

            String sql = "INSERT INTO \"User\" (userId, name, email, password, address, phone, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, address);
            ps.setString(6, phone);
            ps.setString(7, role);

            int result = ps.executeUpdate();
            if (result > 0) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("error", "Registration failed. Please try again.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}

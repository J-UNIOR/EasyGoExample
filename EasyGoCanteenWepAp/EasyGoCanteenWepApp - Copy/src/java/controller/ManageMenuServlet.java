package controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ManageMenuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/easygodb", "app", "123");
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM menu WHERE canteen_id = ?")) {

            HttpSession session = request.getSession();
            int canteenId = (Integer) session.getAttribute("userId");

            ps.setInt(1, canteenId);
            ResultSet rs = ps.executeQuery();
            request.setAttribute("menuItems", rs);
            RequestDispatcher dispatcher = request.getRequestDispatcher("manage_menu.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int canteenId = (Integer) request.getSession().getAttribute("userId");

        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/easygodb", "app", "app")) {

            if ("add".equals(action)) {
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                PreparedStatement ps = conn.prepareStatement("INSERT INTO menu (name, price, canteen_id) VALUES (?, ?, ?)");
                ps.setString(1, name);
                ps.setDouble(2, price);
                ps.setInt(3, canteenId);
                ps.executeUpdate();
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                PreparedStatement ps = conn.prepareStatement("DELETE FROM menu WHERE id = ? AND canteen_id = ?");
                ps.setInt(1, id);
                ps.setInt(2, canteenId);
                ps.executeUpdate();
            }

            response.sendRedirect("ManageMenuServlet");

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error: " + e.getMessage());
        }
    }
}

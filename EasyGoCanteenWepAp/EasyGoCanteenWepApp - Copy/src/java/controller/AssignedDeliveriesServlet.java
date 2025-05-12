package controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import za.ac.tut.model.Delivery;

public class AssignedDeliveriesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check if session is valid and user is logged in
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userName") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String deliveryPerson = (String) session.getAttribute("userName");

        List<Delivery> deliveries = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establish DB connection
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/easygodb", "administrator", "admin@123");

            // Query assigned deliveries not yet marked as 'Delivered'
            String sql = "SELECT * FROM Deliveries WHERE delivery_person = ? AND status != 'Delivered'";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, deliveryPerson);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Delivery d = new Delivery(
                    rs.getInt("delivery_id"),
                    rs.getString("recipient_name"),
                    rs.getString("address"),
                    rs.getString("status"),
                    rs.getDate("assigned_date"),
                    rs.getDate("delivered_date")
                );
                deliveries.add(d);
            }

        } catch (SQLException e) {
            // Log the exception and set error message
            e.printStackTrace();
            request.setAttribute("error", "Error retrieving deliveries. Please try again later.");
        } finally {
            // Properly close resources
            try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
            try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
        }

        // Pass data to JSP
        request.setAttribute("deliveries", deliveries);
        RequestDispatcher rd = request.getRequestDispatcher("assignedDeliveries.jsp");
        rd.forward(request, response);
    }
}

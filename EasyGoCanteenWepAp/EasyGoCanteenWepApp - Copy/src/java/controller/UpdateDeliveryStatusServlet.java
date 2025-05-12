package controller;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateDeliveryStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deliveryId = request.getParameter("deliveryId");
        String status = request.getParameter("status");

        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/easygodb", "administrator", "admin@123");
             PreparedStatement stmt = conn.prepareStatement("UPDATE Deliveries SET status=? WHERE delivery_id=?")) {
            stmt.setString(1, status);
            stmt.setInt(2, Integer.parseInt(deliveryId));

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                request.setAttribute("successMessage", "Delivery status updated successfully!");
            } else {
                request.setAttribute("errorMessage", "Failed to update the status. Please check the delivery ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while updating the delivery status.");
        }

        request.getRequestDispatcher("updateDeliveryStatus.jsp").forward(request, response);
    }
}

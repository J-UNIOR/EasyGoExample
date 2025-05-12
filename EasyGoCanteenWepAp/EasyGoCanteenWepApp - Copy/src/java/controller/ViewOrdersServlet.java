package controller;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewOrdersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/EasyGoCanteenDB", "administrator", "admin@123");
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM orders WHERE order_id = ?")) {

            HttpSession session = request.getSession();
            int order_id = (Integer) session.getAttribute("userId");

            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            request.setAttribute("orders", rs);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view_orders.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
    // Log the full exception stack trace
    Logger.getLogger(UpdateStockServlet.class.getName()).log(Level.SEVERE, "Error occurred while updating menu item", e);

    // Optionally, print the error message to the browser (for debugging purposes)
    request.setAttribute("errorMessage", e.getMessage());
    request.getRequestDispatcher("error.jsp").forward(request, response);
}

    }
}

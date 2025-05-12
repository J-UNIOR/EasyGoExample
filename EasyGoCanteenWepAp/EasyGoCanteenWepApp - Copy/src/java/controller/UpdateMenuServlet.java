package controller;

import util.DBConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@MultipartConfig
public class UpdateMenuServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String itemIdStr = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String priceStr = request.getParameter("price");

        Part imagePart = request.getPart("image");

        if (itemIdStr == null || name == null || description == null || priceStr == null ||
            itemIdStr.isEmpty() || name.isEmpty() || description.isEmpty() || priceStr.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        try {
            long itemId = Long.parseLong(itemIdStr);
            double price = Double.parseDouble(priceStr);

            Connection conn = DBConnection.getConnection();
            String sql;
            PreparedStatement stmt;

            if (imagePart != null && imagePart.getSize() > 0) {
                sql = "UPDATE MENU SET name=?, description=?, price=?, image=? WHERE id=?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, description);
                stmt.setDouble(3, price);
                InputStream imageStream = imagePart.getInputStream();
                stmt.setBinaryStream(4, imageStream, (int) imagePart.getSize());
                stmt.setLong(5, itemId);
            } else {
                sql = "UPDATE MENU SET name=?, description=?, price=? WHERE id=?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, name);
                stmt.setString(2, description);
                stmt.setDouble(3, price);
                stmt.setLong(4, itemId);
            }

            int rowsUpdated = stmt.executeUpdate();
            stmt.close();
            conn.close();

            if (rowsUpdated > 0) {
                response.sendRedirect("menuSuccess.jsp");
            } else {
                request.setAttribute("errorMessage", "No item found with ID: " + itemId);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

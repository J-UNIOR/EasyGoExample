package controller;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class ExportExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=users.xls");

        PrintWriter out = response.getWriter();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/EasyGoDB", "easy", "easy");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM \"User\"");

            out.println("User ID\tName\tEmail\tPhone\tRole");

            while (rs.next()) {
                out.println(
                        rs.getString("userId") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("email") + "\t" +
                        rs.getString("phone") + "\t" +
                        rs.getString("role")
                );
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}

package controller;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import util.DBConnection;

public class ExportUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=UserList.xls");

        try (PrintWriter out = response.getWriter();
             Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM \"User\"");
             ResultSet rs = ps.executeQuery()) {

            out.println("UserID\tName\tEmail\tPhone\tRole");

            while (rs.next()) {
                out.println(
                    rs.getInt("userId") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("email") + "\t" +
                    rs.getString("phone") + "\t" +
                    rs.getString("role")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

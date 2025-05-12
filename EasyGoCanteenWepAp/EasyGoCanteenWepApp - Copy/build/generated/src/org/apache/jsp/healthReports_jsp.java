package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class healthReports_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

    String nutritionistName = (String) session.getAttribute("userName");
    if (nutritionistName == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Database connection
    String dbURL = "jdbc:derby://localhost:1527/easygoCanteenDB";
    String dbUser = "administrator";
    String dbPass = "admin@123";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Health Reports - Easy-Go</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: 'Segoe UI', sans-serif;\n");
      out.write("            background: #f4f4f4;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            background: white;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            padding: 30px;\n");
      out.write("            max-width: 900px;\n");
      out.write("            margin: auto;\n");
      out.write("            box-shadow: 0 4px 10px rgba(0,0,0,0.1);\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            color: #6f42c1;\n");
      out.write("        }\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin-top: 25px;\n");
      out.write("        }\n");
      out.write("        th, td {\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            padding: 12px;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("        th {\n");
      out.write("            background-color: #6f42c1;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        tr:nth-child(even) {\n");
      out.write("            background-color: #f8f8f8;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <h2>Healthy Food Recommendations</h2>\n");
      out.write("    <p>Based on the food items available in stock:</p>\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <th>Food Name</th>\n");
      out.write("            <th>Description</th>\n");
      out.write("            <th>Price (R)</th>\n");
      out.write("        </tr>\n");
      out.write("        ");

            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                String sql = "SELECT name, description, price FROM menu ORDER BY price ASC";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( rs.getString("name") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("description") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getDouble("price") );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

                }
            } catch (Exception e) {
                out.println("<tr><td colspan='3'>Error: " + e.getMessage() + "</td></tr>");
            } finally {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            }
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

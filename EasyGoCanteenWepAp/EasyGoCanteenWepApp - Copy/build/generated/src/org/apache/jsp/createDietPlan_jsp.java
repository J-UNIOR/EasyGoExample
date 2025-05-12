package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class createDietPlan_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Create Diet Plan</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background: #f9f9f9;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            width: 70%;\n");
      out.write("            margin: 50px auto;\n");
      out.write("            background: #fff;\n");
      out.write("            padding: 30px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n");
      out.write("            border-radius: 10px;\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            color: #333;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        label {\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        textarea {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-top: 5px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            resize: vertical;\n");
      out.write("        }\n");
      out.write("        .food-list {\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        .food-item {\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("        input[type=\"checkbox\"] {\n");
      out.write("            margin-right: 10px;\n");
      out.write("        }\n");
      out.write("        input[type=\"submit\"] {\n");
      out.write("            background-color: #28a745;\n");
      out.write("            color: white;\n");
      out.write("            padding: 12px 25px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        input[type=\"submit\"]:hover {\n");
      out.write("            background-color: #218838;\n");
      out.write("        }\n");
      out.write("        .error {\n");
      out.write("            color: red;\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <h2>Create Diet Plan</h2>\n");
      out.write("    <form action=\"saveDietPlan.jsp\" method=\"post\">\n");
      out.write("        <label>Plan Description:</label><br>\n");
      out.write("        <textarea name=\"description\" rows=\"4\" required></textarea><br><br>\n");
      out.write("\n");
      out.write("        <label>Select Foods to Recommend:</label><br>\n");
      out.write("        <div class=\"food-list\">\n");
      out.write("            ");

                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/EasyGoCanteenDB", "administrator", "admin@123");

                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT id, name, description, price FROM menu");

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String desc = rs.getString("description");
                        double price = rs.getDouble("price");
            
      out.write("\n");
      out.write("                <div class=\"food-item\">\n");
      out.write("                    <input type=\"checkbox\" name=\"selectedItems\" value=\"");
      out.print(id);
      out.write("\">\n");
      out.write("                    <strong>");
      out.print(name);
      out.write("</strong> - ");
      out.print(desc);
      out.write(" - R");
      out.print(price);
      out.write("\n");
      out.write("                </div>\n");
      out.write("            ");

                    }
                    rs.close();
                    conn.close();
                } catch (Exception e) {
            
      out.write("\n");
      out.write("                <div class=\"error\">Error: ");
      out.print( e.getMessage() );
      out.write("</div>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <br><input type=\"submit\" value=\"Save Plan\">\n");
      out.write("    </form>\n");
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

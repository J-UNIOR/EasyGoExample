package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewSubmissions_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String nutritionist = (String) session.getAttribute("userName");
    if (nutritionist == null) {
        response.sendRedirect("login.jsp");
        return;
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Your Diet Plans</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background: #f4f6f8;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            text-align: center;\n");
      out.write("            color: #2c3e50;\n");
      out.write("        }\n");
      out.write("        .plan-box {\n");
      out.write("            background: #ffffff;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            margin: 15px auto;\n");
      out.write("            padding: 15px;\n");
      out.write("            max-width: 700px;\n");
      out.write("            box-shadow: 0 4px 6px rgba(0,0,0,0.1);\n");
      out.write("        }\n");
      out.write("        .plan-box h4 {\n");
      out.write("            margin-top: 0;\n");
      out.write("            color: #2980b9;\n");
      out.write("        }\n");
      out.write("        .plan-box p {\n");
      out.write("            font-size: 14px;\n");
      out.write("            color: #555;\n");
      out.write("        }\n");
      out.write("        ul {\n");
      out.write("            padding-left: 20px;\n");
      out.write("            margin: 10px 0;\n");
      out.write("        }\n");
      out.write("        li {\n");
      out.write("            line-height: 1.6;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h2>Submitted Diet Plans</h2>\n");

    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/EasyGoCanteenDB", "administrator", "admin@123");

        PreparedStatement ps = conn.prepareStatement("SELECT plan_id, description, created_at FROM diet_plan WHERE nutritionist = ?");
        ps.setString(1, nutritionist);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int planId = rs.getInt("plan_id");
            String desc = rs.getString("description");
            Timestamp date = rs.getTimestamp("created_at");

            out.println("<div class='plan-box'>");
            out.println("<h4>Plan ID: " + planId + " | " + date + "</h4>");
            out.println("<p><strong>Description:</strong> " + desc + "</p>");
            out.println("<ul>");

            PreparedStatement itemsStmt = conn.prepareStatement(
                "SELECT name FROM menu WHERE id IN (SELECT menu_id FROM diet_plan_menu WHERE plan_id = ?)");
            itemsStmt.setInt(1, planId);
            ResultSet items = itemsStmt.executeQuery();

            while (items.next()) {
                out.println("<li>" + items.getString("name") + "</li>");
            }

            itemsStmt.close();
            out.println("</ul></div>");
        }

        conn.close();
    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    }

      out.write("\n");
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

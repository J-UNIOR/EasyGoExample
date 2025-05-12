package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class saveDietPlan_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    String description = request.getParameter("description");
    String[] selectedItems = request.getParameterValues("selectedItems");

    if (nutritionist == null || selectedItems == null || description == null || description.trim().isEmpty()) {
        out.println("Missing data.");
        return;
    }

    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/EasyGoDB", "administrator", "admin@123");

        PreparedStatement insertPlan = conn.prepareStatement(
            "INSERT INTO diet_plan (nutritionist, description) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        insertPlan.setString(1, nutritionist);
        insertPlan.setString(2, description);
        insertPlan.executeUpdate();

        ResultSet generatedKeys = insertPlan.getGeneratedKeys();
        int planId = 0;
        if (generatedKeys.next()) {
            planId = generatedKeys.getInt(1);
        }

        PreparedStatement insertItems = conn.prepareStatement("INSERT INTO diet_plan_menu (plan_id, menu_id) VALUES (?, ?)");
        for (String itemId : selectedItems) {
            insertItems.setInt(1, planId);
            insertItems.setInt(2, Integer.parseInt(itemId));
            insertItems.executeUpdate();
        }

        conn.close();
        out.println("<h3>Diet Plan Saved Successfully!</h3>");
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }

      out.write('\n');
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

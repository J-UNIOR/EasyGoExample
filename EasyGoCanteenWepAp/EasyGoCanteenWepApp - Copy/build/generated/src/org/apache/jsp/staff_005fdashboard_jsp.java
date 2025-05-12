package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class staff_005fdashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String staffName = (String) session.getAttribute("userName");
    if (staffName == null) {
        response.sendRedirect("index.html");
        return;
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Staff Dashboard - Easy-Go Canteen</title>\n");
      out.write("</head>\n");
      out.write("<body style=\"margin: 0; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(to right, #f0f4f8, #ffffff);\">\n");
      out.write("\n");
      out.write("    <div style=\"background-color: #007bff; padding: 20px; text-align: center; color: white;\">\n");
      out.write("        <h1 style=\"margin: 0;\">Staff Dashboard</h1>\n");
      out.write("        <p>Welcome, <strong>");
      out.print( staffName );
      out.write("</strong> </p>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div style=\"padding: 40px; text-align: center;\">\n");
      out.write("        <h2 style=\"color: #333;\">Your Actions</h2>\n");
      out.write("        <div style=\"display: flex; flex-wrap: wrap; justify-content: center; gap: 20px; margin-top: 30px;\">\n");
      out.write("            <a href=\"view_orders.jsp\" style=\"padding: 20px; background-color: #28a745; color: white; text-decoration: none; border-radius: 8px; width: 200px; display: inline-block; font-weight: bold;\">View Orders</a>\n");
      out.write("            <a href=\"manage_customers.jsp\" style=\"padding: 20px; background-color: #17a2b8; color: white; text-decoration: none; border-radius: 8px; width: 200px; display: inline-block; font-weight: bold;\">Manage Customers</a>\n");
      out.write("            <a href=\"update_profile.jsp\" style=\"padding: 20px; background-color: #ffc107; color: white; text-decoration: none; border-radius: 8px; width: 200px; display: inline-block; font-weight: bold;\">Update Profile</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div style=\"text-align: center; margin-top: 50px;\">\n");
      out.write("        <a href=\"logout.jsp\" style=\"color: #dc3545; text-decoration: none; font-weight: bold;\">Logout</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <footer style=\"position: fixed; bottom: 10px; width: 100%; text-align: center; color: #aaa; font-size: 14px;\">\n");
      out.write("        &copy; 2025 Easy-Go Canteen System. All rights reserved.\n");
      out.write("    </footer>\n");
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

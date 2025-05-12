package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class student_005fdashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    if (session.getAttribute("role") == null || !session.getAttribute("role").equals("Student")) {
        response.sendRedirect("index.html");
        return;
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Student Dashboard</title>\n");
      out.write("</head>\n");
      out.write("<body style=\"font-family: Arial, sans-serif; background: #f0f8ff; margin: 0; padding: 0; display: flex; flex-direction: column; align-items: center;\">\n");
      out.write("\n");
      out.write("    <div style=\"width: 100%; background: #007bff; color: white; padding: 20px; text-align: center;\">\n");
      out.write("        <h1>Welcome, ");
      out.print( session.getAttribute("userName") );
      out.write(" (Student)</h1>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div style=\"margin-top: 40px; display: flex; gap: 20px; flex-wrap: wrap; justify-content: center;\">\n");
      out.write("        <a href=\"view_orders.jsp\" style=\"background: #28a745; color: white; padding: 15px 30px; border-radius: 8px; text-decoration: none;\">View Menu</a>\n");
      out.write("        <a href=\"place_order.jsp\" style=\"background: #17a2b8; color: white; padding: 15px 30px; border-radius: 8px; text-decoration: none;\">Place Order</a>\n");
      out.write("        <a href=\"order_history.jsp\" style=\"background: #ffc107; color: white; padding: 15px 30px; border-radius: 8px; text-decoration: none;\">Order History</a>\n");
      out.write("        <a href=\"logout.jsp\" style=\"background: #dc3545; color: white; padding: 15px 30px; border-radius: 8px; text-decoration: none;\">Logout</a>\n");
      out.write("    </div>\n");
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

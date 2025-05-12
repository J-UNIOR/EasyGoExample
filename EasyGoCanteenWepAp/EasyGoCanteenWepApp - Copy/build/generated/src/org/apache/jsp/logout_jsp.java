package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class logout_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    session.invalidate(); // Clear all session data
    response.setHeader("Cache-Control","no-cache"); // Prevent caching
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    response.sendRedirect("index.html");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Logging Out - Easy-Go</title>\n");
      out.write("</head>\n");
      out.write("<body style=\"font-family: Arial, sans-serif; background-color: #f8f9fa; text-align: center; padding-top: 100px;\">\n");
      out.write("\n");
      out.write("    <div style=\"display: inline-block; padding: 40px; background: white; box-shadow: 0 0 10px rgba(0,0,0,0.1); border-radius: 10px;\">\n");
      out.write("        <h2 style=\"color: #333;\">You have been logged out</h2>\n");
      out.write("        <p style=\"color: #555;\">Thank you for using the Easy-Go Canteen System</p>\n");
      out.write("        <a href=\"index.html\" style=\"margin-top: 20px; display: inline-block; padding: 12px 25px; background-color: #007bff; color: white; text-decoration: none; border-radius: 6px;\">Return to Home</a>\n");
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

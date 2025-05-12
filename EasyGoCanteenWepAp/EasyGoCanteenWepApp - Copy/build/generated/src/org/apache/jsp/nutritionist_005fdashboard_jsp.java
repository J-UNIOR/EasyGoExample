package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nutritionist_005fdashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String nutritionistName = (String) session.getAttribute("userName");
    if (nutritionistName == null) {
        response.sendRedirect("login.jsp");
        return;
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Nutritionist Dashboard - Easy-Go</title>\n");
      out.write("</head>\n");
      out.write("<body style=\"margin: 0; font-family: 'Segoe UI', sans-serif; background: linear-gradient(to right, #fdfbfb, #ebedee);\">\n");
      out.write("\n");
      out.write("    <div style=\"background-color: #6f42c1; padding: 25px; color: white; text-align: center;\">\n");
      out.write("        <h1>Welcome, ");
      out.print( nutritionistName );
      out.write(" (Nutritionist/Dietitian)</h1>\n");
      out.write("        <p>Your personalized nutrition & diet management portal</p>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div style=\"padding: 50px; text-align: center;\">\n");
      out.write("        <h2 style=\"color: #333;\">Nutrition Tools</h2>\n");
      out.write("\n");
      out.write("        <div style=\"display: flex; flex-wrap: wrap; justify-content: center; gap: 30px; margin-top: 30px;\">\n");
      out.write("            <a href=\"createDietPlan.jsp\" style=\"background-color: #20c997; color: white; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;\">Create Diet Plan</a>\n");
      out.write("            <a href=\"viewSubmissions.jsp\" style=\"background-color: #fd7e14; color: white; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;\">View Submissions</a>\n");
      out.write("            <a href=\"healthReports.jsp\" style=\"background-color: #17a2b8; color: white; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;\">Health Reports</a>\n");
      out.write("            <a href=\"consultationHistory.jsp\" style=\"background-color: #007bff; color: white; padding: 20px 35px; border-radius: 8px; text-decoration: none; font-weight: bold;\">Consultation History</a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div style=\"margin-top: 50px;\">\n");
      out.write("            <form action=\"logout.jsp\" method=\"post\">\n");
      out.write("                <input type=\"submit\" value=\"Logout\" style=\"background-color: #dc3545; color: white; padding: 12px 24px; border: none; border-radius: 5px; cursor: pointer;\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <footer style=\"text-align: center; padding: 20px; background-color: #f8f9fa; color: #6c757d; font-size: 14px;\">\n");
      out.write("        &copy; 2025 Easy-Go Canteen System | Nutrition Services\n");
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

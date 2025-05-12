package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import za.ac.tut.model.Delivery;

public final class updateDeliveryStatus_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/deliverySessionCheck.jsp");
  }

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
      out.write('\n');

    String deliveryName = (String) session.getAttribute("userName");
    if (deliveryName == null) {
        response.sendRedirect("login.jsp");
        return;
    }

      out.write('\n');
      out.write(" <!-- Session check -->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Update Delivery Status - Easy-Go</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: 'Segoe UI', sans-serif;\n");
      out.write("            background-color: #f4f7f9;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            margin: 40px auto;\n");
      out.write("            max-width: 900px;\n");
      out.write("            background: #fff;\n");
      out.write("            padding: 30px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n");
      out.write("            border-radius: 8px;\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            text-align: center;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("        .form-group {\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("        }\n");
      out.write("        label {\n");
      out.write("            display: block;\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("        input, select {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 4px;\n");
      out.write("        }\n");
      out.write("        button {\n");
      out.write("            background-color: #007bff;\n");
      out.write("            color: white;\n");
      out.write("            padding: 12px 20px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("        button:hover {\n");
      out.write("            background-color: #0056b3;\n");
      out.write("        }\n");
      out.write("        .alert {\n");
      out.write("            background-color: #f44336;\n");
      out.write("            color: white;\n");
      out.write("            padding: 15px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("        .success {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Update Delivery Status</h2>\n");
      out.write("\n");
      out.write("        <!-- Show success or error messages -->\n");
      out.write("        ");
 
            String successMessage = (String) request.getAttribute("successMessage");
            if (successMessage != null) {
        
      out.write("\n");
      out.write("        <div class=\"alert success\">\n");
      out.write("            ");
      out.print( successMessage );
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
 
            }
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        
      out.write("\n");
      out.write("        <div class=\"alert\">\n");
      out.write("            ");
      out.print( errorMessage );
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
 
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"UpdateDeliveryStatusServlet\" method=\"post\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"deliveryId\">Delivery ID:</label>\n");
      out.write("                <input type=\"text\" id=\"deliveryId\" name=\"deliveryId\" required>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label for=\"status\">New Status:</label>\n");
      out.write("                <select id=\"status\" name=\"status\" required>\n");
      out.write("                    <option value=\"In Transit\">In Transit</option>\n");
      out.write("                    <option value=\"Delivered\">Delivered</option>\n");
      out.write("                    <option value=\"Pending\">Pending</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("            <button type=\"submit\">Update Status</button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <div style=\"margin-top: 20px;\">\n");
      out.write("            <a href=\"delivery_dashboard.jsp\" style=\"text-decoration: none; color: #007bff;\">Back to Dashboard</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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

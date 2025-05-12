package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import za.ac.tut.model.Delivery;

public final class assignedDeliveries_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Assigned Deliveries - Easy-Go</title>\n");
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
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin-top: 25px;\n");
      out.write("        }\n");
      out.write("        th, td {\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            padding: 14px;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("        th {\n");
      out.write("            background-color: #007bff;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        tr:nth-child(even) {\n");
      out.write("            background-color: #f9f9f9;\n");
      out.write("        }\n");
      out.write("        .no-data {\n");
      out.write("            text-align: center;\n");
      out.write("            color: #888;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        .button {\n");
      out.write("            display: block;\n");
      out.write("            width: 200px;\n");
      out.write("            margin: 20px auto;\n");
      out.write("            background-color: #007bff;\n");
      out.write("            color: white;\n");
      out.write("            padding: 12px;\n");
      out.write("            text-align: center;\n");
      out.write("            text-decoration: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            font-size: 16px;\n");
      out.write("        }\n");
      out.write("        .button:hover {\n");
      out.write("            background-color: #0056b3;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Your Assigned Deliveries</h2>\n");
      out.write("\n");
      out.write("        ");

            List<Delivery> deliveries = (List<Delivery>) request.getAttribute("deliveries");
            if (deliveries != null && !deliveries.isEmpty()) {
        
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Recipient</th>\n");
      out.write("                <th>Address</th>\n");
      out.write("                <th>Status</th>\n");
      out.write("                <th>Assigned Date</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                for (Delivery d : deliveries) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( d.getRecipientName() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( d.getAddress() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( d.getStatus() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( d.getAssignedDate() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </table>\n");
      out.write("        ");
 } else { 
      out.write("\n");
      out.write("            <p class=\"no-data\">You have no assigned deliveries at the moment.</p>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Back to Dashboard Button -->\n");
      out.write("        <a href=\"delivery_dashboard.jsp\" class=\"button\">Back to Dashboard</a>\n");
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

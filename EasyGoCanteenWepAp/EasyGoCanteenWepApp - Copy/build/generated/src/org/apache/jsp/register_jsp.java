package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Register - EasyGo Canteen</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background: linear-gradient(to right, #e8f0ff, #ffffff);\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            height: 100vh;\n");
      out.write("            margin: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .register-container {\n");
      out.write("            background-color: white;\n");
      out.write("            padding: 30px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 0 15px rgba(0,0,0,0.1);\n");
      out.write("            width: 400px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .register-container h2 {\n");
      out.write("            text-align: center;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        label {\n");
      out.write("            display: block;\n");
      out.write("            margin-top: 15px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: #555;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"text\"],\n");
      out.write("        input[type=\"email\"],\n");
      out.write("        input[type=\"password\"],\n");
      out.write("        select {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            margin-top: 5px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"submit\"] {\n");
      out.write("            margin-top: 20px;\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 12px;\n");
      out.write("            background-color: #007BFF;\n");
      out.write("            border: none;\n");
      out.write("            color: white;\n");
      out.write("            font-size: 16px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: background-color 0.3s ease;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=\"submit\"]:hover {\n");
      out.write("            background-color: #0056b3;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .error-message {\n");
      out.write("            color: red;\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 15px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<form method=\"post\" action=\"RegisterServlet\" class=\"register-container\">\n");
      out.write("    <h2>Register an Account</h2>\n");
      out.write("\n");
      out.write("    <label for=\"name\">Full Name:</label>\n");
      out.write("    <input type=\"text\" name=\"name\" required>\n");
      out.write("\n");
      out.write("    <label for=\"email\">Email:</label>\n");
      out.write("    <input type=\"email\" name=\"email\" required>\n");
      out.write("\n");
      out.write("    <label for=\"password\">Password:</label>\n");
      out.write("    <input type=\"password\" name=\"password\" required>\n");
      out.write("\n");
      out.write("    <label for=\"address\">Address:</label>\n");
      out.write("    <input type=\"text\" name=\"address\">\n");
      out.write("\n");
      out.write("    <label for=\"phone\">Phone:</label>\n");
      out.write("    <input type=\"text\" name=\"phone\">\n");
      out.write("\n");
      out.write("    <label for=\"role\">Select Role:</label>\n");
      out.write("    <select name=\"role\" required>\n");
      out.write("        <option value=\"\">-- Select Role --</option>\n");
      out.write("        <option value=\"Student\">Student</option>\n");
      out.write("        <option value=\"Staff\">Staff</option>\n");
      out.write("        <option value=\"Canteen\">Canteen</option>\n");
      out.write("        <option value=\"Delivery\">Delivery Personnel</option>\n");
      out.write("        <option value=\"Corporate\">Corporate/School</option>\n");
      out.write("        <option value=\"Nutritionist\">Nutritionist/Dietitian</option>\n");
      out.write("    </select>\n");
      out.write("\n");
      out.write("    <input type=\"submit\" value=\"Register\">\n");
      out.write("\n");
      out.write("    ");
 if (request.getAttribute("error") != null) { 
      out.write("\n");
      out.write("        <div class=\"error-message\">");
      out.print( request.getAttribute("error") );
      out.write("</div>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("</form>\n");
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

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import util.DBConnection;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String role = request.getParameter("role");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (role == null || role.trim().equals("")) {
        response.sendRedirect("index.html");
        return;
    }

    if (email != null && password != null) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM \"User\" WHERE email = ? AND password = ? AND role = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, role);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                session.setAttribute("userId", rs.getInt("userId"));
                session.setAttribute("userName", rs.getString("name"));
                session.setAttribute("userEmail", rs.getString("email"));
                session.setAttribute("role", rs.getString("role"));

                String dash = role.toLowerCase().replace("/", "").replace(" ", "_") + "_dashboard.jsp";
                response.sendRedirect(dash);
                return;
            } else {

      out.write("\n");
      out.write("                <p style=\"color:red; text-align:center;\">Invalid credentials for ");
      out.print( role );
      out.write(". Please try again.</p>\n");

            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {

      out.write("\n");
      out.write("            <p style=\"color:red; text-align:center;\">Error: ");
      out.print( e.getMessage() );
      out.write("</p>\n");

        }
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>");
      out.print( role );
      out.write(" Login - EasyGo</title>\n");
      out.write("</head>\n");
      out.write("<body style=\"font-family: Arial, sans-serif; background: linear-gradient(to right, #f9f9f9, #dfefff); display: flex; flex-direction: column; align-items: center; justify-content: center; height: 100vh;\">\n");
      out.write("\n");
      out.write("    <div style=\"background: white; padding: 30px; border-radius: 10px; box-shadow: 0 0 12px rgba(0,0,0,0.1); width: 350px; text-align: center;\">\n");
      out.write("        <h2 style=\"color: #333; margin-bottom: 20px;\">");
      out.print( role );
      out.write(" Login</h2>\n");
      out.write("\n");
      out.write("        <form method=\"post\" action=\"login.jsp?role=");
      out.print( role );
      out.write("\">\n");
      out.write("            <input type=\"email\" name=\"email\" placeholder=\"Email\" required style=\"width: 100%; padding: 10px; margin-bottom: 15px; border-radius: 6px; border: 1px solid #ccc;\"><br>\n");
      out.write("\n");
      out.write("            <input type=\"password\" name=\"password\" placeholder=\"Password\" required style=\"width: 100%; padding: 10px; margin-bottom: 20px; border-radius: 6px; border: 1px solid #ccc;\"><br>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Login\" style=\"width: 100%; padding: 12px; background-color: #007bff; color: white; border: none; border-radius: 6px; font-weight: bold; cursor: pointer;\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <p style=\"margin-top: 15px;\">\n");
      out.write("            Not registered yet?\n");
      out.write("            <a href=\"register.jsp\" style=\"color: #007bff; text-decoration: none;\">Sign up here</a>\n");
      out.write("        </p>\n");
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

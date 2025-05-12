package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class administrator_005fdashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String role = (String) session.getAttribute("role");
    if (role == null || !role.equals("Administrator")) {
        response.sendRedirect("login.jsp");
        return;
    }

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Map<String, String>> users = new ArrayList<Map<String, String>>();
    List<Map<String, String>> logs = new ArrayList<Map<String, String>>();
    int totalUsers = 0, admins = 0, students = 0;

    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/EasyGoCanteenDB", "administrator", "admin@123");

        // Count users
        rs = conn.createStatement().executeQuery("SELECT role, COUNT(*) as count FROM \"User\" GROUP BY role");
        while (rs.next()) {
            String r = rs.getString("role");
            int count = rs.getInt("count");
            totalUsers += count;
            if ("Administrator".equals(r)) admins = count;
            else if ("Student".equals(r)) students = count;
        }

        // Get all users
        rs = conn.createStatement().executeQuery("SELECT * FROM \"User\"");
        while (rs.next()) {
            Map<String, String> user = new HashMap<String, String>();
            user.put("id", rs.getString("userId"));
            user.put("name", rs.getString("name"));
            user.put("email", rs.getString("email"));
            user.put("phone", rs.getString("phone"));
            user.put("role", rs.getString("role"));
            users.add(user);
        }

        // Get login logs
        rs = conn.createStatement().executeQuery(
            "SELECT u.name, l.loginTime, l.activity FROM LoginLog l JOIN \"User\" u ON l.userId = u.userId ORDER BY l.loginTime DESC FETCH FIRST 5 ROWS ONLY"
        );
        while (rs.next()) {
            Map<String, String> log = new HashMap<String, String>();
            log.put("name", rs.getString("name"));
            log.put("time", rs.getString("loginTime"));
            log.put("activity", rs.getString("activity"));
            logs.add(log);
        }

    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Admin Dashboard</title>\n");
      out.write("    <style>\n");
      out.write("        body { font-family: Arial; background: #f0f2f5; margin: 0; padding: 0; }\n");
      out.write("        .header { background: #004aad; color: white; padding: 20px; text-align: center; }\n");
      out.write("        .container { padding: 30px; }\n");
      out.write("        .card { background: white; padding: 20px; margin: 10px; border-radius: 10px; box-shadow: 0 0 10px #ccc; width: 200px; display: inline-block; vertical-align: top; }\n");
      out.write("        table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n");
      out.write("        th, td { padding: 10px; border: 1px solid #ddd; }\n");
      out.write("        th { background: #007bff; color: white; }\n");
      out.write("        .logs { margin-top: 40px; }\n");
      out.write("        .popup { display: none; position: fixed; background: white; border: 1px solid #ccc; padding: 20px; z-index: 999; top: 20%; left: 35%; width: 30%; box-shadow: 0 0 10px gray; }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"header\">\n");
      out.write("        <h1>Admin Dashboard</h1>\n");
      out.write("        <p>Welcome, ");
      out.print( session.getAttribute("userName") );
      out.write(" | <a href=\"logout.jsp\" style=\"color: yellow;\">Logout</a></p>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"card\"><h3>Total Users</h3><p>");
      out.print( totalUsers );
      out.write("</p></div>\n");
      out.write("        <div class=\"card\"><h3>Admins</h3><p>");
      out.print( admins );
      out.write("</p></div>\n");
      out.write("        <div class=\"card\"><h3>Students</h3><p>");
      out.print( students );
      out.write("</p></div>\n");
      out.write("\n");
      out.write("        <h2>Registered Users</h2>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Role</th><th>Action</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                for (Map<String, String> user : users) {
            
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( user.get("id") );
      out.write("</td>\n");
      out.write("                    <td><a href=\"#\" onclick=\"showProfile('");
      out.print( user.get("id") );
      out.write("', '");
      out.print( user.get("name") );
      out.write("', '");
      out.print( user.get("email") );
      out.write("', '");
      out.print( user.get("phone") );
      out.write("', '");
      out.print( user.get("role") );
      out.write("')\">");
      out.print( user.get("name") );
      out.write("</a></td>\n");
      out.write("                    <td>");
      out.print( user.get("email") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( user.get("phone") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( user.get("role") );
      out.write("</td>\n");
      out.write("                    <td><form action=\"DeleteUserServlet\" method=\"post\" onsubmit=\"return confirm('Delete this user?');\">\n");
      out.write("                        <input type=\"hidden\" name=\"userId\" value=\"");
      out.print( user.get("id") );
      out.write("\"/>\n");
      out.write("                        <input type=\"submit\" value=\"Delete\" style=\"background:red;color:white;border:none;padding:5px 10px;border-radius:4px;\">\n");
      out.write("                    </form></td>\n");
      out.write("                </tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <div class=\"logs\">\n");
      out.write("            <h2>Recent Logins</h2>\n");
      out.write("            <table>\n");
      out.write("                <tr><th>User</th><th>Time</th><th>Activity</th></tr>\n");
      out.write("                ");
 for (Map<String, String> log : logs) { 
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( log.get("name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( log.get("time") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( log.get("activity") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Profile Popup -->\n");
      out.write("    <div id=\"profilePopup\" class=\"popup\">\n");
      out.write("        <h3>User Profile</h3>\n");
      out.write("        <p><strong>ID:</strong> <span id=\"p_id\"></span></p>\n");
      out.write("        <p><strong>Name:</strong> <span id=\"p_name\"></span></p>\n");
      out.write("        <p><strong>Email:</strong> <span id=\"p_email\"></span></p>\n");
      out.write("        <p><strong>Phone:</strong> <span id=\"p_phone\"></span></p>\n");
      out.write("        <p><strong>Role:</strong> <span id=\"p_role\"></span></p>\n");
      out.write("        <button onclick=\"document.getElementById('profilePopup').style.display='none'\">Close</button>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function showProfile(id, name, email, phone, role) {\n");
      out.write("            document.getElementById('p_id').innerText = id;\n");
      out.write("            document.getElementById('p_name').innerText = name;\n");
      out.write("            document.getElementById('p_email').innerText = email;\n");
      out.write("            document.getElementById('p_phone').innerText = phone;\n");
      out.write("            document.getElementById('p_role').innerText = role;\n");
      out.write("            document.getElementById('profilePopup').style.display = 'block';\n");
      out.write("        }\n");
      out.write("    </script>\n");
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

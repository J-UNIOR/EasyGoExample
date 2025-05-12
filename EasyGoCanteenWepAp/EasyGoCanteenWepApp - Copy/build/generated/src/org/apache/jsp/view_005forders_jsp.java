package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class view_005forders_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head><title>View Orders</title></head>\n");
      out.write("<body>\n");
      out.write("    <h2>Your Orders</h2>\n");
      out.write("    <table border=\"1\">\n");
      out.write("        <tr><th>Order ID</th><th>Item</th><th>Quantity</th><th>Customer</th><th>Status</th></tr>\n");
      out.write("        ");

            ResultSet rs = (ResultSet) request.getAttribute("orders");
            while (rs != null && rs.next()) {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( rs.getInt("id") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("item_name") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getInt("quantity") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("customer_name") );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("status") );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </table>\n");
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

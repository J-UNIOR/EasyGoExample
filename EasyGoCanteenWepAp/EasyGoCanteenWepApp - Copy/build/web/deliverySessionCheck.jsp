<%@ page session="true" %>
<%
    String deliveryName = (String) session.getAttribute("userName");
    if (deliveryName == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

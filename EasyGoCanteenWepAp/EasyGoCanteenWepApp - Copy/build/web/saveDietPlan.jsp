<%@ page import="java.sql.*, java.util.*" %>
<%@ page session="true" %>
<%
    String nutritionist = (String) session.getAttribute("userName");
    String description = request.getParameter("description");
    String[] selectedItems = request.getParameterValues("selectedItems");

    if (nutritionist == null || selectedItems == null || description == null || description.trim().isEmpty()) {
        out.println("Missing data.");
        return;
    }

    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/EasyGoDB", "administrator", "admin@123");

        PreparedStatement insertPlan = conn.prepareStatement(
            "INSERT INTO diet_plan (nutritionist, description) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        insertPlan.setString(1, nutritionist);
        insertPlan.setString(2, description);
        insertPlan.executeUpdate();

        ResultSet generatedKeys = insertPlan.getGeneratedKeys();
        int planId = 0;
        if (generatedKeys.next()) {
            planId = generatedKeys.getInt(1);
        }

        PreparedStatement insertItems = conn.prepareStatement("INSERT INTO diet_plan_menu (plan_id, menu_id) VALUES (?, ?)");
        for (String itemId : selectedItems) {
            insertItems.setInt(1, planId);
            insertItems.setInt(2, Integer.parseInt(itemId));
            insertItems.executeUpdate();
        }

        conn.close();
        out.println("<h3>Diet Plan Saved Successfully!</h3>");
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>

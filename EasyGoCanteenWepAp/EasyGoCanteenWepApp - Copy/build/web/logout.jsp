<%@ page session="true" %>
<%
    session.invalidate(); // Clear all session data
    response.setHeader("Cache-Control","no-cache"); // Prevent caching
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    response.sendRedirect("index.html");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logging Out - Easy-Go</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f8f9fa; text-align: center; padding-top: 100px;">

    <div style="display: inline-block; padding: 40px; background: white; box-shadow: 0 0 10px rgba(0,0,0,0.1); border-radius: 10px;">
        <h2 style="color: #333;">You have been logged out</h2>
        <p style="color: #555;">Thank you for using the Easy-Go Canteen System</p>
        <a href="index.html" style="margin-top: 20px; display: inline-block; padding: 12px 25px; background-color: #007bff; color: white; text-decoration: none; border-radius: 6px;">Return to Home</a>
    </div>

</body>
</html>

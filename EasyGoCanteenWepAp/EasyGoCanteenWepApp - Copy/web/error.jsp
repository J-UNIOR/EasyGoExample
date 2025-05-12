<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Occurred</title>
</head>
<body>
    <h2>Error Occurred</h2>
    <p><strong>Error Message:</strong></p>
    <p style="color: red;">
        ${errorMessage}
    </p>
    <a href="updateMenuForm.jsp">Go back to the form</a>
</body>
</html>

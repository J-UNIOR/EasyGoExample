<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register - EasyGo Canteen</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #e8f0ff, #ffffff);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .register-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            width: 400px;
        }

        .register-container h2 {
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #555;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            margin-top: 20px;
            width: 100%;
            padding: 12px;
            background-color: #007BFF;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: red;
            text-align: center;
            margin-top: 15px;
        }
    </style>
</head>
<body>

<form method="post" action="RegisterServlet" class="register-container">
    <h2>Register an Account</h2>

    <label for="name">Full Name:</label>
    <input type="text" name="name" required>

    <label for="email">Email:</label>
    <input type="email" name="email" required>

    <label for="password">Password:</label>
    <input type="password" name="password" required>

    <label for="address">Address:</label>
    <input type="text" name="address">

    <label for="phone">Phone:</label>
    <input type="text" name="phone">

    <label for="role">Select Role:</label>
    <select name="role" required>
        <option value="">-- Select Role --</option>
        <option value="Student">Student</option>
        <option value="Staff">Staff</option>
        <option value="Canteen">Canteen</option>
        <option value="Delivery">Delivery Personnel</option>
        <option value="Corporate">Corporate/School</option>
        <option value="Nutritionist">Nutritionist/Dietitian</option>
    </select>

    <input type="submit" value="Register">

    <% if (request.getAttribute("error") != null) { %>
        <div class="error-message"><%= request.getAttribute("error") %></div>
    <% } %>
</form>

</body>
</html>

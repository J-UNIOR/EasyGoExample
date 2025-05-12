<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.Delivery"%>
<%@ include file="deliverySessionCheck.jsp" %> <!-- Session check -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Delivery Status - Easy-Go</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f7f9;
            margin: 0;
            padding: 0;
        }
        .container {
            margin: 40px auto;
            max-width: 900px;
            background: #fff;
            padding: 30px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            font-weight: bold;
            color: #333;
        }
        input, select {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #007bff;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .alert {
            background-color: #f44336;
            color: white;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 5px;
        }
        .success {
            background-color: #4CAF50;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Update Delivery Status</h2>

        <!-- Show success or error messages -->
        <% 
            String successMessage = (String) request.getAttribute("successMessage");
            if (successMessage != null) {
        %>
        <div class="alert success">
            <%= successMessage %>
        </div>
        <% 
            }
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
        <div class="alert">
            <%= errorMessage %>
        </div>
        <% 
            }
        %>

        <form action="UpdateDeliveryStatusServlet" method="post">
            <div class="form-group">
                <label for="deliveryId">Delivery ID:</label>
                <input type="text" id="deliveryId" name="deliveryId" required>
            </div>
            <div class="form-group">
                <label for="status">New Status:</label>
                <select id="status" name="status" required>
                    <option value="In Transit">In Transit</option>
                    <option value="Delivered">Delivered</option>
                    <option value="Pending">Pending</option>
                </select>
            </div>
            <button type="submit">Update Status</button>
        </form>

        <div style="margin-top: 20px;">
            <a href="delivery_dashboard.jsp" style="text-decoration: none; color: #007bff;">Back to Dashboard</a>
        </div>
    </div>
</body>
</html>

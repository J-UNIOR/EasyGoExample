<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.Delivery"%>
<%@ include file="deliverySessionCheck.jsp" %> <!-- Session check -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Assigned Deliveries - Easy-Go</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 25px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 14px;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .no-data {
            text-align: center;
            color: #888;
            margin-top: 20px;
        }
        .button {
            display: block;
            width: 200px;
            margin: 20px auto;
            background-color: #007bff;
            color: white;
            padding: 12px;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Your Assigned Deliveries</h2>

        <%
            List<Delivery> deliveries = (List<Delivery>) request.getAttribute("deliveries");
            if (deliveries != null && !deliveries.isEmpty()) {
        %>
        <table>
            <tr>
                <th>Recipient</th>
                <th>Address</th>
                <th>Status</th>
                <th>Assigned Date</th>
            </tr>
            <%
                for (Delivery d : deliveries) {
            %>
            <tr>
                <td><%= d.getRecipientName() %></td>
                <td><%= d.getAddress() %></td>
                <td><%= d.getStatus() %></td>
                <td><%= d.getAssignedDate() %></td>
            </tr>
            <% } %>
        </table>
        <% } else { %>
            <p class="no-data">You have no assigned deliveries at the moment.</p>
        <% } %>

        <!-- Back to Dashboard Button -->
        <a href="delivery_dashboard.jsp" class="button">Back to Dashboard</a>
    </div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Menu Item</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            padding: 40px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        form {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #555;
        }

        input[type="text"],
        input[type="number"],
        input[type="file"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        textarea {
            resize: vertical;
            height: 100px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
            width: 100%;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2>Update Menu Item</h2>
    <form action="UpdateMenuServlet" method="post" enctype="multipart/form-data">
        <input type="hidden" name="item_id" value="${menu.id}">
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${menu.name}" required>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required>${menu.description}</textarea>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" value="${menu.price}" required>

        <label for="image">New Image (optional):</label>
        <input type="file" id="image" name="image" accept="image/*">

        <input type="submit" value="Update Menu Item">
    </form>
</body>
</html>

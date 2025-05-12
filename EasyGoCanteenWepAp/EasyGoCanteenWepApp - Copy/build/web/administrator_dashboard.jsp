<%@ page import="java.sql.*, java.util.*" %>
<%@ page session="true" %>
<%
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
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body { font-family: Arial; background: #f0f2f5; margin: 0; padding: 0; }
        .header { background: #004aad; color: white; padding: 20px; text-align: center; }
        .container { padding: 30px; }
        .card { background: white; padding: 20px; margin: 10px; border-radius: 10px; box-shadow: 0 0 10px #ccc; width: 200px; display: inline-block; vertical-align: top; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 10px; border: 1px solid #ddd; }
        th { background: #007bff; color: white; }
        .logs { margin-top: 40px; }
        .popup { display: none; position: fixed; background: white; border: 1px solid #ccc; padding: 20px; z-index: 999; top: 20%; left: 35%; width: 30%; box-shadow: 0 0 10px gray; }
    </style>
</head>
<body>
    <div class="header">
        <h1>Admin Dashboard</h1>
        <p>Welcome, <%= session.getAttribute("userName") %> | <a href="logout.jsp" style="color: yellow;">Logout</a></p>
    </div>
    <div class="container">
        <div class="card"><h3>Total Users</h3><p><%= totalUsers %></p></div>
        <div class="card"><h3>Admins</h3><p><%= admins %></p></div>
        <div class="card"><h3>Students</h3><p><%= students %></p></div>

        <h2>Registered Users</h2>
        <table>
            <tr>
                <th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Role</th><th>Action</th>
            </tr>
            <%
                for (Map<String, String> user : users) {
            %>
                <tr>
                    <td><%= user.get("id") %></td>
                    <td><a href="#" onclick="showProfile('<%= user.get("id") %>', '<%= user.get("name") %>', '<%= user.get("email") %>', '<%= user.get("phone") %>', '<%= user.get("role") %>')"><%= user.get("name") %></a></td>
                    <td><%= user.get("email") %></td>
                    <td><%= user.get("phone") %></td>
                    <td><%= user.get("role") %></td>
                    <td><form action="DeleteUserServlet" method="post" onsubmit="return confirm('Delete this user?');">
                        <input type="hidden" name="userId" value="<%= user.get("id") %>"/>
                        <input type="submit" value="Delete" style="background:red;color:white;border:none;padding:5px 10px;border-radius:4px;">
                    </form></td>
                </tr>
            <% } %>
        </table>

        <div class="logs">
            <h2>Recent Logins</h2>
            <table>
                <tr><th>User</th><th>Time</th><th>Activity</th></tr>
                <% for (Map<String, String> log : logs) { %>
                <tr>
                    <td><%= log.get("name") %></td>
                    <td><%= log.get("time") %></td>
                    <td><%= log.get("activity") %></td>
                </tr>
                <% } %>
            </table>
        </div>
    </div>

    <!-- Profile Popup -->
    <div id="profilePopup" class="popup">
        <h3>User Profile</h3>
        <p><strong>ID:</strong> <span id="p_id"></span></p>
        <p><strong>Name:</strong> <span id="p_name"></span></p>
        <p><strong>Email:</strong> <span id="p_email"></span></p>
        <p><strong>Phone:</strong> <span id="p_phone"></span></p>
        <p><strong>Role:</strong> <span id="p_role"></span></p>
        <button onclick="document.getElementById('profilePopup').style.display='none'">Close</button>
    </div>

    <script>
        function showProfile(id, name, email, phone, role) {
            document.getElementById('p_id').innerText = id;
            document.getElementById('p_name').innerText = name;
            document.getElementById('p_email').innerText = email;
            document.getElementById('p_phone').innerText = phone;
            document.getElementById('p_role').innerText = role;
            document.getElementById('profilePopup').style.display = 'block';
        }
    </script>
</body>
</html>

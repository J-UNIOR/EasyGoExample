package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver"); // Make sure this matches your driver
        String url = "jdbc:derby://localhost:1527/EasyGoCanteenDB";
        String user = "administrator";  // use your DB username
        String password = "admin@123";  // your DB password
        return DriverManager.getConnection(url, user, password);
    }
}

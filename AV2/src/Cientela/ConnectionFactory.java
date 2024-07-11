package Cientela;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Clientela";
        String user = "root";
        String password = "";

        Connection conn = null;
        conn = DriverManager.getConnection(url, user, password);

        return conn;
    }
}

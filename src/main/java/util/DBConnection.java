package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String url = "jdbc:mysql://127.0.0.1:3306/audit_data?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=UTF-8";
    private String user = "root";
    private String password = "";
    private Connection conn;
    private static DBConnection instance;

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connection re-established");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private DBConnection() {
        try {
            this.conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

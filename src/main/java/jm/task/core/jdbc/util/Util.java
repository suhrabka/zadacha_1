package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String DRIVER= "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/mydb";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    public Connection getConection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }
        return connection;
    }
}

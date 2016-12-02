package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    public static String USER = "java";
    public static String USERPW = "password";
    public static String DBNAME = "sundebygninger";
    public static String HOST = "localhost";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);

        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(url, USER, USERPW);
    }
}

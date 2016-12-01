package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    public static String USER = "root";
    public static String USERPW = "Highfem5";
    public static String DBNAME = "app";
    public static String HOST = "localhost";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {


        String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);

        //definerer driveren til at driveren bliver skrevet med MYSQL dialekt
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(url, USER, USERPW);
    }
}

package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    // Standard localhost DB for starting app in isolated environment
    public static String USER_STD = "java";
    public static String USERPW_STD = "password";
    public static String DBNAME_STD = "sundebygninger";
    public static String HOST_STD = "localhost";

    // Jonas localhost DB for testing with Main App
    public static String USER_JS_MAC = "root";
    public static String USERPW_JS_MAC = "tEb6M>CAEuua1";
    public static String DBNAME_JS_MAC = "app";
    public static String HOST_JS_MAC = "localhost";

    public static Connection getConnection(String profile) throws SQLException, ClassNotFoundException {

        if (profile.equals("test-js-mac")) {
            String url = String.format("jdbc:mysql://%s:3306/%s?useSSL=false", HOST_JS_MAC, DBNAME_JS_MAC);
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, USER_JS_MAC, USERPW_JS_MAC);
        }
        else {
            String url = String.format("jdbc:mysql://%s:3306/%s?useSSL=false", HOST_STD, DBNAME_STD);
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, USER_STD, USERPW_STD);
        }
    }
}

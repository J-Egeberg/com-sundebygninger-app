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

    // Test Sundebygninger.com connection with data on Main App
    public static String USER_TEST = "root";
    public static String USERPW_TEST = "AaY6B6X6c8hYomGvVWmV";
    public static String DBNAME_TEST = "test";
    public static String HOST_TEST = "localhost";

    // Live Sundebygninger.com connection with data on Main App
    public static String USER_LIVE = "scheldejonas";
    public static String USERPW_LIVE = "Wildfly2016";
    public static String DBNAME_LIVE = "polygon";
    public static String HOST_LIVE = "sundebygninger.com";

    public static Connection getConnection(String profile) throws SQLException, ClassNotFoundException, ConnectionProfileNotFoundException {
        String url;
        switch (profile) {
            case "test-js-mac" :
                url = String.format("jdbc:mysql://%s:3306/%s?useSSL=false", HOST_JS_MAC, DBNAME_JS_MAC);
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection(url, USER_JS_MAC, USERPW_JS_MAC);
            case "test" :
                url = String.format("jdbc:mysql://%s:3306/%s", HOST_TEST, DBNAME_TEST);
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection(url, USER_TEST, USERPW_TEST);
            case "live" :
                url = String.format("jdbc:mysql://%s:3306/%s?useSSL=false", HOST_LIVE, DBNAME_LIVE);
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection(url, USER_LIVE, USERPW_LIVE);
            case "std" :
                url = String.format("jdbc:mysql://%s:3306/%s?useSSL=false", HOST_STD, DBNAME_STD);
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection(url, USER_STD, USERPW_STD);
        }
        throw new ConnectionProfileNotFoundException();
    }
}

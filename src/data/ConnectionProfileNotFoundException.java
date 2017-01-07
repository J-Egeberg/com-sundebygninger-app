package data;

/**
 * Created by scheldejonas on 10/12/2016.
 */
public class ConnectionProfileNotFoundException extends Exception {
    public ConnectionProfileNotFoundException() {
        super("The choosen profile was not found in connection creator");
    }
}

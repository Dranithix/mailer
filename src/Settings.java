/**
 * Created by Kenta Iwasaki on 8/3/2017.
 */
public class Settings {
    public static final String AUTH_CONNECTION_STRING = "smtp.googlemail.com:465";
    public static final String AUTH_SERVER_ADDRESS = AUTH_CONNECTION_STRING.split(":")[0];
    public static final int AUTH_SERVER_PORT = Integer.decode(AUTH_CONNECTION_STRING.split(":")[1]);

    public static final String AUTH_EMAIL = "test@gmail.com";
    public static final String AUTH_EMAIL_PASSWORD = "passwordhere";
}

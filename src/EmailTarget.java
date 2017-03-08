import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by Kenta Iwasaki on 8/3/2017.
 */
public class EmailTarget {
    private String email;

    public EmailTarget(String email) {
        this.email = email;
    }

    public void sendEmail(String title, String body) {
        Email email = new SimpleEmail();
        try {
            email.setHostName(Settings.AUTH_SERVER_ADDRESS);
            email.setSmtpPort(Settings.AUTH_SERVER_PORT);
            email.setAuthenticator(new DefaultAuthenticator(Settings.AUTH_EMAIL, Settings.AUTH_EMAIL_PASSWORD));
            email.setSSLOnConnect(true);
            email.setFrom(Settings.AUTH_EMAIL);
            email.setSubject(title);
            email.setMsg(body);
            email.addTo(this.email);

            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
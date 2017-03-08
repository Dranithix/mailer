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
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("test28145@gmail.com", "putyourownpasswordhere"));
            email.setSSLOnConnect(true);
            email.setFrom("test28145@gmail.com");
            email.setSubject(title);
            email.setMsg(body);
            email.addTo(this.email);

            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
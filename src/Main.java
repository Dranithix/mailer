import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kenta Iwasaki on 8/3/2017.
 */
public class Main extends JFrame {
    public Main() {
        setTitle("Mass Emailer by Kenta Iwasaki");
        setSize(new Dimension(800, 600));

        GridLayout layout = new GridLayout();
        layout.setHgap(10);
        layout.setVgap(10);

        JTextField titleField = new JTextField("Email Subject");
        add(titleField);

        JTextField messageField = new JTextField("Body");
        add(messageField);

        JButton sendButton = new JButton("Mass-Send");
        sendButton.addActionListener((event) -> {
            for (EmailTarget target : targets) target.sendEmail(titleField.getText(), messageField.getText());
            JOptionPane.showMessageDialog(this, "Sent!");
        });
        add(sendButton);

        setLayout(layout);


        pack();

        setVisible(true);
    }

    private class EmailTarget {
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

    private List<EmailTarget> targets = new ArrayList<EmailTarget>();

    public void init() {
        targets.add(new EmailTarget("test@gmail.com"));
        targets.add(new EmailTarget("two@gmail.com"));
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ex) {}
        new Main().init();
    }
}

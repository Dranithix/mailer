import javax.swing.*;
import java.awt.*;
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

        JTextArea titleField = new JTextArea("Email Subject");
        add(titleField);

        JTextArea messageField = new JTextArea("Body");
        add(messageField);

        JButton sendButton = new JButton("Mass-Send");
        sendButton.addActionListener((event) -> {
            for (EmailTarget target : targets) target.sendEmail(titleField.getText(), messageField.getText());
            JOptionPane.showMessageDialog(this, "Sent!");
        });
        add(sendButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(layout);
        setVisible(true);
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

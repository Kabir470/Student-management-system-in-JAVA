import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.*;

public class practiceCode extends JFrame implements ActionListener {

    JButton sendButton;
    JTextField recipientField, subjectField;
    JTextArea messageArea;

    public practiceCode() {
        setLayout(new BorderLayout());

        // Panel for email fields
        JPanel emailPanel = new JPanel(new GridLayout(3, 2));

        emailPanel.add(new JLabel("Recipient:"));
        recipientField = new JTextField();
        emailPanel.add(recipientField);

        emailPanel.add(new JLabel("Subject:"));
        subjectField = new JTextField();
        emailPanel.add(subjectField);

        emailPanel.add(new JLabel("Message:"));
        messageArea = new JTextArea(5, 20);
        emailPanel.add(new JScrollPane(messageArea));

        add(emailPanel, BorderLayout.CENTER);

        // Send button
        sendButton = new JButton("Send Email");
        sendButton.addActionListener(this);
        add(sendButton, BorderLayout.SOUTH);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            String recipient = recipientField.getText();
            String subject = subjectField.getText();
            String message = messageArea.getText();
            sendEmail(recipient, subject, message);
        }
    }

    private void sendEmail(String recipient, String subject, String messageText) {
        // Assuming you are sending email from a Gmail account
        String from = "skkabir2704@gmail.com";
        final String username = "skkabir2704@gmail.com"; // Your Gmail username
        final String password = ""; // Your Gmail password

        // Set properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Get the Session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field of the header
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(messageText);

            // Send message
            Transport.send(message);

            JOptionPane.showMessageDialog(this, "Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new practiceCode();
    }
}

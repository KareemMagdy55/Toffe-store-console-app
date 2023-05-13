/**

OTP (One Time Password) class that generates a random 6-digit code and sends it via email to the user for verification.
Uses JavaMail API to send email messages and requires a valid Gmail account credentials.
/
/**
 * Sends a verification code via email to the specified email address.
 * @param recipientEmail email address of the user to receive the verification code.
 */
import javax.mail.;
import javax.activation.;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.;
public class OTP {
private String code;
public void send(String recipientEmail){
    generateCode();
    System.out.println(code);
    // Sender's email address
    String senderEmail = "youssefmohammed747@gmail.com";
    // Sender's email password
    String password = "ufqofiivgclmvxdc";
    // Email subject
    String subject = "Verify your Email in TOFFEE";
    // Email message
    String message = "This is your OTP Code: " + code + "\n";

    // Set properties for the email server
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    // Authenticate sender's email address
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, password);
                }
            });

    try {
        // Create email message
        Message emailMessage = new MimeMessage(session);
        emailMessage.setFrom(new InternetAddress(senderEmail));
        emailMessage.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(recipientEmail));
        emailMessage.setSubject(subject);
        emailMessage.setText(message);

        // Send email message
        Transport.send(emailMessage);

        System.out.println("Email sent successfully.");

    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
}

/**
 * Generates a random 6-digit code.
 */
private void generateCode(){
    Random random = new Random();
    // Generate a 6-digit random number
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 6; i++) {
        int digit = random.nextInt(10);
        sb.append(digit);
    }
    code = sb.toString();
}

/**
 * Returns the generated code.
 * @return generated code.
 */
public String getCode(){
    return code;
}
}







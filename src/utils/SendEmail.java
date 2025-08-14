/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 *
 * @author ADMIN
 */
public class SendEmail {

    public static void sendEmail(String toEmail, String subject, String messageText) {
        final String username = "hongdat098789@gmail.com";
        final String password = "mjul hcrj fmit ntlb";
        Properties pp = new Properties();
        pp.put("mail.smtp.host", "smtp.gmail.com");
        pp.put("mail.smtp.port", "465");
        pp.put("mail.smtp.auth", "true");
        pp.put("mail.smtp.socketFactory.port", "465");
        pp.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(pp, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Lấy Lại Mật Khẩu");
            message.setText(messageText);
            Transport.send(message);
            System.out.println("Gửi Thành Công");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

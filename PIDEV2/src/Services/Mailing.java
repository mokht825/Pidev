/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author belha
 */
public class Mailing {
    
    public static void sendMail(String recepient) throws Exception {
        
        System.out.println("Preparing mail");
        Properties propreties = new Properties();
        
        propreties.put("mail.smtp.auth", "true");
        propreties.put("mail.smtp.starttls.enable","true");
        propreties.put("mail.smtp.host","smtp.gmail.com");
        propreties.put("mail.smtp.port","587");
        
        String myAccount = "oolympus39@gmail.com";
        String password = "a123456789A";
        
        Session session;
        session = Session.getInstance(propreties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
        Message message = prepareMessage(session, myAccount, recepient);
        
        Transport.send(message);
        System.out.println("Mail sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccount , String recepient ) {
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Soyez les Bienvenus");
            message.setText("Chèr(e) Client(e),\n \nNous voudrons vous informer que votre inscription a été faite avec succès. \nVous faites partie, maintenant, de la famille de Olympus. \n \nNous vous souhaitons une agréable journée et soyez les bienvenus");
            return message;
        }
        catch ( MessagingException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





/**
 *
 * @author EmmanuelJs
 */
public class EnviarCorreo {
    
    public void send(String receptor, String pass){
    
    try{
    Properties props = new Properties();
 
    props.put("mail.smtp.host","smtp.gmail.com");
    // TLS si está disponible
    props.setProperty("mail.smtp.starttls.enable", "true");
    props.put("mail.transport.protocol","smtp");
    props.put("mail.smtp.auth", "true");
    // Puerto de gmail para envio de correos
    props.setProperty("mail.smtp.port","587");
    props.setProperty("mail.user", "shopymarketcr@gmail.com");
    props.setProperty("mail.password", "ucradmin");
    
    Session session = Session.getDefaultInstance(props);
    session.setDebug(true);
    
    // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("shopymarketcr@gmail.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(receptor));
            message.setSubject("ShopyMarket");
            message.setText("Bienvenido " + receptor+" a shopyMarket     " +pass);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("shopymarketcr@gmail.com", "ucradmin");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
              }
        catch (Exception e)
        {
            e.printStackTrace();
        }
 }
    
}

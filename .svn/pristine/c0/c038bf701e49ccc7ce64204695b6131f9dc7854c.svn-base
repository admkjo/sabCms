/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.common;

import com.sabonay.cms.web.controller.CommonQuery;
import java.sql.SQLException;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
 * SendEmail.java
 *
 * Created on November 15, 2005, 12:06 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


/**
 *
 * @author agyepong
 */
public class SendEmail {

    private String username = "";
    private String passwd = "";
    private String smtpserver = "mail.sabonay.com";
    private String emailaddr = "";
    private String subject = "XML Data";
    private String content = "This is the message content";
    //private int smtpPort = 25;
    private int smtpPort = 587;
    private boolean needsAuth = true;
    private String protocol = "smtp";
CommonQuery commonQuery = new CommonQuery();
String userparts[];
    /**
     * Creates a new instance of SendEmail
     */
    public SendEmail() throws SQLException {
        emailaddr = commonQuery.getApplicationSettings(26, 1);
        passwd =    commonQuery.getApplicationSettings(27, 1);
       userparts = emailaddr.split("@");
       username = userparts[0];
        System.out.println("username: "+ emailaddr + " "+ passwd+ " "+username);

    }

    public SendEmail(boolean needsAuth, String username, String passwd) {
        this.needsAuth = needsAuth;
        this.username = username;
        this.passwd = passwd;
        
    }

    public void send( String from, String to, String subject, String content, String filename) throws AddressException, MessagingException {
        send(smtpserver, smtpPort, from, to, subject, content, filename);
    }

    public void send(String smtpserver, int smtpPort,
            String from, String to,
            String subject, String content, String filename) throws AddressException, MessagingException {
        try {
            // Create a mail session
            java.util.Properties props = new java.util.Properties();
            props.put("mail.smtp.host", smtpserver);
            props.put("mail.smtp.port", "" + smtpPort);

            Session session;
            if (needsAuth) {
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.user", emailaddr);
                props.put("mail.smtp.password", passwd);

                //create the authenticator object
                Authenticator auth = new SmtpAuthenticator(emailaddr, passwd);
                session = Session.getInstance(props, auth);
            } else {
                session = Session.getDefaultInstance(props, null);
            }
            System.out.println("creating");
            // Construct the message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);
            msg.setSentDate(new java.util.Date());
            //msg.saveChanges();
            //msg.writeTo(OutputStream os);
            //msg.setDisposition(String disposition); javax.mail.Part.ATTACHMENT, javax.mail.Part.INLINE;
            //msg.setFileName(String filename)content;
            if (filename == null) {
                msg.setText(content);
            } else {     
                setMultiparttFileAsAttachment(msg, content, filename);
            }
            System.out.println("before transport");
            // Send the message
            Transport.send(msg);
            System.out.println("after transport");
        } catch (AddressException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendConnAuth(String smtpserver, int smtpPort,
            String from, String to,
            String subject, String content, String filename) throws AddressException, MessagingException {
        try {
            // Create a mail session
            java.util.Properties props = new java.util.Properties();
            props.put("mail.smtp.host", smtpserver);
            props.put("mail.smtp.port", "" + smtpPort);

            Session session = Session.getDefaultInstance(props, null);
            Transport t = session.getTransport(protocol);
            if (needsAuth) {
                t.connect(username, passwd);
            }

            // Construct the message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);
            msg.setSentDate(new java.util.Date());
            
            if (filename == null) {
                msg.setText(content);
            } else {
                setMultiparttFileAsAttachment(msg, content, filename);
            }

            // Send the message
            //Transport.send(msg);
            t.sendMessage(msg, msg.getAllRecipients());
        } catch (AddressException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendGmail( String from, String to,
            String subject, String content, String filename) throws AddressException, MessagingException {
        try {
            // Create a mail session
            java.util.Properties props = new java.util.Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.quitwait", "false");
            //props.put("mail.debug", "true");
            
            Session session;
            if (needsAuth) {
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.user", username);
                props.put("mail.smtp.password", passwd);

                //create the authenticator object
                Authenticator auth = new SmtpAuthenticator(username, passwd);
                session = Session.getDefaultInstance(props, auth);
            } else {
                session = Session.getDefaultInstance(props, null);
            }

            // Construct the message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject(subject);
            msg.setSentDate(new java.util.Date());
            //msg.saveChanges();
            //msg.writeTo(OutputStream os);
            //msg.setDisposition(String disposition); javax.mail.Part.ATTACHMENT, javax.mail.Part.INLINE;
            //msg.setFileName(String filename)content;
            if (filename == null) {
                msg.setText(content);
            } else {
                setMultiparttFileAsAttachment(msg, content, filename);
            }

            // Send the message
            Transport.send(msg);
        } catch (AddressException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        //} catch (AuthenticationFailedException ex) {
            //ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
// Set a file as an attachment.  Uses JAF FileDataSource.
    public void setMultiparttFileAsAttachment(Message msg, String content, String filename) throws MessagingException {

        // Create and fill first part
        MimeBodyPart p1 = new MimeBodyPart();
        p1.setText(content);

        // Create second part
        MimeBodyPart p2 = new MimeBodyPart();

        // Put a file in the second part
        FileDataSource fds = new FileDataSource(filename);
        p2.setDataHandler(new DataHandler(fds));
        p2.setFileName(fds.getName());

        // Create the Multipart.  Add BodyParts to it.
        Multipart mp = new MimeMultipart();
        mp.addBodyPart(p1);
        mp.addBodyPart(p2);

        // Set Multipart as the message's content
        msg.setContent(mp);
    }

    public static void main(String[] args) throws Exception {
        //String smtpserver = "mail.atl.bellsouth.net";
        //String emailaddrto = "stephenagyepong@bellsouth.net";

        String smtpserver = "smtpout.secureserver.net";
        //String emailaddrfrom = "contact@sabonay.com";
        //String emailaddrto = "contact@sabonay.com";
        int smtpPort = 25;
        //String emailaddrfrom = "stephenagyepong@juno.com";
        //String emailaddrto = "stephenagyepong@gmail.com";
        //String subject = "Gmail Message Data";
        //String content = "This is the message content (Deborah)";
        String emailaddrfrom = "stephenagyepong@sabonay.com";
        String emailaddrto = "stephenagyepong@sabonay.com";
        String emailaddrto1 = "stephenagyepong@gmail.com";
        String emailaddrto2 = "sophia.agyepong@yahoo.com";
        String emailaddrto3 = "ebayagyepong@yahoo.com";
        String emailaddrto4 = "stephenagyepong@juno.com";
        String emailaddrto5 = "kwosman@hotmail.com";
        String emailaddrto6 = "harry.oseimensah@verizon.net";
        String emailaddrto7 = "tnkrumah@sc.rr.com";
        String subject = "Sabonay Mail Message";
        String content = "Please let me know (reply) when you receive this test message. Thanks.";
        String filename = null;
        
        //int smtpPort = 80;  // for godaddy.com
        //int smtpPort = 3535;    // for godaddy.com

        // Send a test message
        //new SendEmail().send( smtpserver, smtpPort, emailaddrfrom, emailaddrto, subject, content, null );
        
        //new SendEmail(true, "contact@sabonay.com", "contact12").send(smtpserver, smtpPort, emailaddrfrom, emailaddrto, subject, content, null);
        //new SendEmail(true, "stephenagyepong@gmail.com", "password").sendGmail(emailaddrfrom, emailaddrto, subject, content, null);
        
        //SendEmail smail = new SendEmail(true, "stephenagyepong@gmail.com", "Password");
        //smail.sendGmail(emailaddrfrom, emailaddrto, subject, content, null);

        //SendEmail smail = new SendEmail(true, emailaddrfrom, "Password");
        SendEmail smail = new SendEmail(true, emailaddrfrom, "Password");
        smail.send( emailaddrfrom, emailaddrto, subject, content, filename);
        smail.send( emailaddrfrom, emailaddrto1, subject, content, filename);
        smail.send( emailaddrfrom, emailaddrto2, subject, content, filename);
        smail.send( emailaddrfrom, emailaddrto3, subject, content, filename);
        smail.send( emailaddrfrom, emailaddrto4, subject, content, filename);
        smail.send( emailaddrfrom, emailaddrto5, subject, content, filename);
        smail.send( emailaddrfrom, emailaddrto6, subject, content, "C:/0000Assets/kenmore_assets.txt");
        smail.send( emailaddrfrom, emailaddrto7, subject, content, filename);
        //SendEmail smail = new SendEmail(true, "akosuadebi@yahoo.com.com", "christinyou");
        //smail.sendGmail("akosuadebi@yahoo.com", "akosuadebi@yahoo.com.com", "trying", "Recor Exams", null);

        //String emailaddrto = "sophia.agyepong@yahoo.com";
        //String emailaddrto = "stephenagyepong@gmail.com";
        //String emailaddrto = "ebayagyepong@yahoo.com";
    }
}
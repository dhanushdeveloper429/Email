package com.main.email.Email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl  {

    @Autowired
    private Session session;

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    public void sendMsg(Email mail){

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("username@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("username@gmail.com"));
            message.setSubject(mail.getSubject());
            message.setText(mail.getContent());
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        finally {
            logger.info("Email Executed Successfully");
        }
    }


}

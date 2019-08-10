package com.main.email.Email;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class EmailConfig {

    @Bean
    public Session registerSession()
    {

        //Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port", "587");

   	        Session session = Session.getInstance(props,
   	          new javax.mail.Authenticator() {
   	            protected PasswordAuthentication getPasswordAuthentication() {
   	                return new PasswordAuthentication("username@gmail.com", "password");
   	            }
                });
        return session;
    }
}

package com.main.email.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@SpringBootApplication
public class EmailApplication implements CommandLineRunner {

	//https://docs.spring.io/spring/docs/5.1.6.RELEASE/spring-framework-reference/integration.html#mail
	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

	@Autowired
	EmailServiceImpl emailService;

	@Override
	public void run(String... args) {

		System.out.println("Sending Email...");
		EmailConfig emailEntity = new EmailConfig();
		//emailEntity.registerSession();
		//sendEmailWithAttachment();
		emailEntity.registerSession();
			emailService.sendMsg(new Email("Unable to establish the Hbase configuration","Hello"));




	}
}
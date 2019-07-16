package com.main.email.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class EmailApplication implements CommandLineRunner {

	//https://docs.spring.io/spring/docs/5.1.6.RELEASE/spring-framework-reference/integration.html#mail

	@Autowired
	JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("Sending Email...");


			sendEmail();
			//sendEmailWithAttachment();



		System.out.println("Done");

	}

	void sendEmail() {

		final String user="username@gmail.com";//change accordingly
		final String password="****";//change accordingly

		String to="dhanushka994@gmail.com";//change accordingly

		//Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host","smtp.gmail.com");
		//props.put("mail.smtp.auth", "false");


		props.put("mail.smtp.port", "587");


		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user,password);
					}
				});

		//Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject("javatpoint");
			message.setText("This is simple program of sending email using JavaMail API");

			//send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {e.printStackTrace();}
	}



	void sendEmailWithAttachment() throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo("");

		helper.setSubject("Testing from Spring Boot");

		// default = text/plain
		//helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText("<h1>Check attachment for image!</h1>", true);

		//FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));

		//Resource resource = new ClassPathResource("android.png");
		//InputStream input = resource.getInputStream();

		//ResourceUtils.getFile("classpath:android.png");

		helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

		javaMailSender.send(msg);

	}
}
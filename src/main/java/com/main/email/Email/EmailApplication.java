package com.main.email.Email;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailApplication implements CommandLineRunner {

	//https://docs.spring.io/spring/docs/5.1.6.RELEASE/spring-framework-reference/integration.html#mail
	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("Sending Email...");
		EmailEntity emailEntity = new EmailEntity();
		emailEntity.sendEmail();
		//sendEmailWithAttachment();
		System.out.println("Done");

	}
}
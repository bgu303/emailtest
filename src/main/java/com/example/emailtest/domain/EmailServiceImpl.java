package com.example.emailtest.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	public String sendSimpleMail(EmailDetails details) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(sender);
			message.setTo(details.getReceiver());
			message.setText(details.getMessage());
			message.setSubject(details.getSubject());
			
			mailSender.send(message);
			System.out.println("moi!");
			return "Mail sent!";
		} catch (Exception e) {
			System.out.println(e);
            return "Error! Mail not sent!";
        }
	}
	
}

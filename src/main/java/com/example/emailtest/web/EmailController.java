package com.example.emailtest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emailtest.domain.EmailDetails;
import com.example.emailtest.domain.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@PostMapping("/sendmail")
	public String sendMail(@RequestBody EmailDetails details) {
		String status = emailService.sendSimpleMail(details);
		return status;
	}
	
	@GetMapping("/sendmail2")
	public String sendMail2() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("venla.a01@gmail.com");
		message.setText("JUKKA TÄÄL MOEEEEEEEEE :D");
		message.setSubject("MORO");
		
		mailSender.send(message);
		return "";
	}
}

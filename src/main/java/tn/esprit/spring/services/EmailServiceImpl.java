package tn.esprit.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.repository.SujetRepository;

@Service
@Component
@Slf4j
public class EmailServiceImpl implements EmailService {

	@Autowired
	SujetRepository sujetRepository;
	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String toEmail,String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("consomitounsi8@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		
		javaMailSender.send(message);
		
		System.out.println("Mail sent ........");
		
	
	}
	


}

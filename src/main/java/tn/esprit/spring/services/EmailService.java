package tn.esprit.spring.services;

import java.util.List;



public interface EmailService {
	
	 void sendEmail(String toEmail,String body, String subject);
	

}

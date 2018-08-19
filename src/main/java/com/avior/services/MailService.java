package com.avior.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service("mailSvc")
public class MailService {
	@Autowired
	private MailSender sender;
	
	@Autowired 
	private SimpleMailMessage alertMailMessage;
	
	
	public void setAlertMailMessage(SimpleMailMessage alertMailMessage) {
		this.alertMailMessage = alertMailMessage;
	}


	public void setSender(MailSender sender) {
		this.sender = sender;
	}
	
	
	public void sendMail(String from, String body){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		
		message.setTo("contacto@avior.com.mx");
		message.setSubject(from);
		message.setText(body);
		sender.send(message);
	}
	
	public void sendAlertMail(String text){
		SimpleMailMessage mailMsg = new SimpleMailMessage(alertMailMessage);
		mailMsg.setText(text);
		sender.send(mailMsg);
	}
	
	public void sendMail(String to, String subject, String body){
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("noresponder@avior.com.mx");
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(body);
		sender.send(msg);
	}
	

}

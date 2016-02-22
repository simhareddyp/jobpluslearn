package com.jpl.util.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.jpl.dao.ClientDao;
import com.jpl.dao.UserDao;
import com.jpl.ui.model.ClientDm;
import com.jpl.util.event.OnRegistrationCompleteEvent;

@Component
public class RegistrationListener implements
		ApplicationListener<OnRegistrationCompleteEvent> {

	// @Autowired
	// private IUserService service;

	@Autowired
	private MessageSource messages;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Environment env;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ClientDao clientDao;

	@Override
	public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
		this.confirmRegistration(event);
	}

	private void confirmRegistration(final OnRegistrationCompleteEvent event) {

		 String token=null;
		 if(event.getUserDm()==null)
		 {
		token = "client"+UUID.randomUUID().toString();
		event.getClientDm().setTokenId(token);
		 }
		 else
		 { token = "user"+UUID.randomUUID().toString(); 
		
		 event.getUserDm().setTokenId(token);
		 }
	
		//service.createVerificationTokenForUser(user, token);

		final SimpleMailMessage email = constructEmailMessage(event, token);
		mailSender.send(email);
	}

	private final SimpleMailMessage constructEmailMessage(
			final OnRegistrationCompleteEvent event, final String token) {
		 String recipientAddress=null;
		if(event.getClientDm()!=null)
		{
		
		 recipientAddress = event.getClientDm().getEmailId();
		}
		else
		{
		
			 recipientAddress = event.getUserDm().getEmailId();
		}
		final String subject = "Registration Confirmation";
		final String confirmationUrl = event.getAppUrl()
				+ "/regconfirm/registrationConfirm?token=" + token;
		
		
		final String message = "Hello World";
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message + " \r\n" + confirmationUrl);
		email.setFrom(env.getProperty("support.email"));
		return email;
	}

}

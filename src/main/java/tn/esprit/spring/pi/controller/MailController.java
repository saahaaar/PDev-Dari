package tn.esprit.spring.pi.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.pi.entity.User;
import tn.esprit.spring.pi.service.MailService;

/**
 * This class contains a Mail API developed using Spring Boot
 * 
 * @author MukulJaiswal
 *
 */

@RestController
public class MailController{

	@Autowired
	private User user;
	@Autowired
	private MailService notificationService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("send-mail")
	public String send() {

		/*
		 * Creating a User with the help of User class that we have declared.
		 * Setting the First,Last and Email address of the sender.
		 */
		user.setNom("sahar");
		user.setPrenom("mansouri");
		user.setEmail("sahar.mansouri@esprit.tn"); // Receiver's email address

		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

	/**
	 * 
	 * @return
	 * @throws MessagingException
	 */
	@RequestMapping("send-mail-attachment")
	public String sendWithAttachment() throws MessagingException {

		/*
		 * Creating a User with the help of User class that we have declared.
		 * Setting the First,Last and Email address of the sender.
		 */
		user.setNom("sahar");
		user.setPrenom("mansouri");
		user.setEmail("sahar.mansouri@esprit.tn"); // Receiver's email address

		/*
		 * Here we will call sendEmailWithAttachment() for Sending mail to the
		 * sender that contains a attachment.
		 */
		try {
			notificationService.sendEmailWithAttachment(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
}

package com.niit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.ContactDAO;
import com.niit.model.Contact;

@Controller
public class ContactUsController
{
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired Contact contact;
	@Autowired ContactDAO contactDAO;
	
	@RequestMapping("/saveContact")
	public ModelAndView submitContact(@RequestParam("contactName") String name, @RequestParam("contactEmail") String email, @RequestParam("contactContact") String mobile, @RequestParam("contactMessage") String message)
	{
		log.debug("Starting to save Contact Us Request");
		ModelAndView mv = new ModelAndView("redirect:/Home");
		
		contact.setName(name);
		contact.setEmail(email);
		contact.setContact(mobile);
		contact.setMessage(message);
		
		if(contactDAO.save(contact)==true)
		{
			log.debug("Contact request submitted successfully.");
			mv.addObject("message", "Thank you for contacting us Mr./ Ms "+name+". We will get back to you ASAP.");
		}
		else
		{
			mv.addObject("message", "Error submitting contact request. Please try again");
		}
		return mv;
	}
	
		@RequestMapping("/manage-contactus-delete/{id}")
		public ModelAndView deleteContactUs(@PathVariable("id") int id)
		{
			log.debug("Starting of delete Contact Us Message");
			log.info("You are about to delete a contact us request with id : " + id);
			
			ModelAndView mv = new ModelAndView("redirect:/manageContactUs");
			
			if (contactDAO.delete(id) == true)
			{
				mv.addObject("contactUsMessage", "Successfullly deleted");
			} 
			else
			{
				mv.addObject("contactUsMessage", "Failed to delete");
			}
			log.debug("Ending of delete Contact Us Message");

			return mv;
		}

}

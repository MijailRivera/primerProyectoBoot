package com.sinbugs.contacs.api;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinbugs.contacs.dto.Contact;
import com.sinbugs.contacs.service.ContactService;
import org.dozer.Mapper;

@RestController
public class ContactsApi {

	@Autowired
	ContactService contactService;
	
	// Inyecta mapper de Dozer
	@Autowired
	Mapper mapper;
	
//	@RequestMapping(value="/contact", method=RequestMethod.POST)
//	public Contact updateOrSave(@RequestBody Contact contact){
//		System.out.println("Hola Mundo!!");
//	    return contactService.save(contact);
//	}
	
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public ContactResponse updateOrSave(@RequestBody @Valid ContactRequest contactRequest){
		// Mapeo request dto ==> entity
		Contact contact = mapper.map(contactRequest, Contact.class);
	    
		// Invoca l[ogica de negocio
		Contact updatedContact = contactService.save(contact);
	    
		// Mapeo entity ==> response dto
	    ContactResponse contactResponse = mapper.map(updatedContact, ContactResponse.class); 
	    
	    return contactResponse;
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public Contact getById(){
		return new Contact(1L, "John", "Doe", "+57 311 222 3344", "john@sinbugs.com");
	}
	

}

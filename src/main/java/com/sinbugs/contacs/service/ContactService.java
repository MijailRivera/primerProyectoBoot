package com.sinbugs.contacs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinbugs.contacs.dao.ContactRepository;
import com.sinbugs.contacs.dto.Contact;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	public Contact save(Contact contact) {
		return contactRepository.saveAndFlush(contact);
	}
}

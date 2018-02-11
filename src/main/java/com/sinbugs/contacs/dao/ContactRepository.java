package com.sinbugs.contacs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinbugs.contacs.dto.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}

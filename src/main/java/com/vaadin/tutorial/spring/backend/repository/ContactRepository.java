package com.vaadin.tutorial.spring.backend.repository;

import com.vaadin.tutorial.spring.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

  @Query("select c from Contact c where lower(c.firstName) like %:searchTerm% or lower(c.lastName) like %:searchTerm%")
  List<Contact> search(@Param("searchTerm") String searchTerm);
}

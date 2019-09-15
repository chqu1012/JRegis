package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.repository;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

	Contact findAllByStatus(int i);
}

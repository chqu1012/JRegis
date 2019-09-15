package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.repository;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPhonenumberRepository extends JpaRepository<ContactPhonenumber, Long>{

	List<ContactPhonenumber> findAllByContactId(Long id);
}

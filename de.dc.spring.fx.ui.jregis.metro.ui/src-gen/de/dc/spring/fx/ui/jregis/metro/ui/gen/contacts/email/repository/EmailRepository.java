package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.email.repository;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.email.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{

	List<Email> findAllByContactId(Long id);
}

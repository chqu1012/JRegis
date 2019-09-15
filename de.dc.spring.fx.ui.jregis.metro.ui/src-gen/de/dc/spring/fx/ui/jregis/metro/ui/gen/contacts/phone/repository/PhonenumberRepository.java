package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber;

@Repository
public interface PhonenumberRepository extends JpaRepository<Phonenumber, Long>{

	List<Phonenumber> findAllByContactId(Long id);
}

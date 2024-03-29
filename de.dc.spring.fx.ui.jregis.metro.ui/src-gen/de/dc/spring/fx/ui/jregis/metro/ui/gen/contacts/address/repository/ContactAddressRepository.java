package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.repository;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactAddressRepository extends JpaRepository<ContactAddress, Long>{

	List<ContactAddress> findAllByContactId(Long id);
}

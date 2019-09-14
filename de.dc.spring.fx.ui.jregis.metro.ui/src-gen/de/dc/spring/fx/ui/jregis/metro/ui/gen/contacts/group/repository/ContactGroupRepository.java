package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.repository;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactGroupRepository extends JpaRepository<ContactGroup, Long>{
}

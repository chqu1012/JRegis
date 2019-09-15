package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.repository;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Long>{

	List<Dates> findAllByContactId(Long id);
}

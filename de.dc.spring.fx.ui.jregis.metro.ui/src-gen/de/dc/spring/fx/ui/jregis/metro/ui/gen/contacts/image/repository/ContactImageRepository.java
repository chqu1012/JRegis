package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.image.repository;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.image.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactImageRepository extends JpaRepository<ContactImage, Long>{
}

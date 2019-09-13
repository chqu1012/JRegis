package de.dc.spring.fx.ui.jregis.metro.ui.document.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentReference;

public interface DocumentReferenceRepository extends JpaRepository<DocumentReference, Long>{

	List<DocumentReference> findAllById(Long id);

}

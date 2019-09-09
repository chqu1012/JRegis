package de.dc.spring.fx.ui.jregis.metro.ui.document.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

	List<Document> findAllByOrderByIdDesc();

	List<Document> findAllByCategoryIdOrderByIdDesc(Long id);
}

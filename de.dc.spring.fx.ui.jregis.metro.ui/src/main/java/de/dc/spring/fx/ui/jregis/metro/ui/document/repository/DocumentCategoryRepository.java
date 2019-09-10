package de.dc.spring.fx.ui.jregis.metro.ui.document.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentCategory;

public interface DocumentCategoryRepository extends JpaRepository<DocumentCategory, Long>{

	List<DocumentCategory> findAllByOrderByNameAsc();
}

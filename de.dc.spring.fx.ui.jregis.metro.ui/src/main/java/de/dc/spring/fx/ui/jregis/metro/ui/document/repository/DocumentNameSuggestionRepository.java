package de.dc.spring.fx.ui.jregis.metro.ui.document.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentNameSuggestion;

public interface DocumentNameSuggestionRepository extends JpaRepository<DocumentNameSuggestion, Long>{

	List<DocumentNameSuggestion> findAllByOrderByNameAsc();
}

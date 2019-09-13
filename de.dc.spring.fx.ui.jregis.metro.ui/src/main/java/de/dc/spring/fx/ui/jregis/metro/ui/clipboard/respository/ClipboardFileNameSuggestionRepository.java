package de.dc.spring.fx.ui.jregis.metro.ui.clipboard.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.spring.fx.ui.jregis.metro.ui.clipboard.model.ClipboardFileNameSuggestion;

public interface ClipboardFileNameSuggestionRepository extends JpaRepository<ClipboardFileNameSuggestion, Long>{

	void deleteByName(String name);

}

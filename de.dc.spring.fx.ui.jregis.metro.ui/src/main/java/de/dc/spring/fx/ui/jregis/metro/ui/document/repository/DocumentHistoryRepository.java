package de.dc.spring.fx.ui.jregis.metro.ui.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentHistory;

public interface DocumentHistoryRepository extends JpaRepository<DocumentHistory, Long>{

}

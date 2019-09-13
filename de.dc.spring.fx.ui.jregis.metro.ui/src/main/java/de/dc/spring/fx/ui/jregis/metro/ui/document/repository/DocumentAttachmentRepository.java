package de.dc.spring.fx.ui.jregis.metro.ui.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentAttachment;

public interface DocumentAttachmentRepository extends JpaRepository<DocumentAttachment, Long>{
}

package de.dc.spring.fx.ui.jregis.metro.ui.document.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentReference;
import de.dc.spring.fx.ui.jregis.metro.ui.document.repository.DocumentReferenceRepository;

@Service
public class DocumentReferenceService {

	@Autowired DocumentReferenceRepository referenceRepository;
	
	public List<DocumentReference> findAllById(Long id){
		return referenceRepository.findAllById(id);
	}

	public DocumentReference save(DocumentReference documentReference) {
		return referenceRepository.save(documentReference);
	}
}

package de.dc.spring.fx.ui.jregis.metro.ui.document.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentAttachment;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentAttachmentStatus;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentHistory;
import de.dc.spring.fx.ui.jregis.metro.ui.document.repository.DocumentAttachmentRepository;

@Service
public class DocumentAttachmentService {

	@Autowired DocumentAttachmentRepository attachmentRepository;
	
	public List<DocumentAttachment> findAll(){
		return attachmentRepository.findAll();
	}
	
	/**
	 * Create new attachments with aggregation to history in database.
	 * @param context
	 * @return
	 */
	public List<DocumentAttachment> create(DocumentHistory history, String... names) {
		List<DocumentAttachment> attachments = new ArrayList<>();
		for (String name : names) {
			attachments.add(create(history, name));
		}
		history.getAttachments().addAll(attachments);
		return attachments;
	}
	
	 /**
	 * Create a new attachment with aggregation to history in database.
	 * @param context
	 * @return
	 */
	public DocumentAttachment create(DocumentHistory history, String name) {
		LocalDateTime createdOn = LocalDateTime.now();
		DocumentAttachment attachment = new DocumentAttachment(name, createdOn, createdOn, history.getId());
		attachment.setStatus(DocumentAttachmentStatus.ADD.getStatusValue());
		attachment = attachmentRepository.save(attachment);
		history.getAttachments().add(attachment);
		return attachment;
	}

	public DocumentAttachment save(DocumentAttachment attachment) {
		return attachmentRepository.save(attachment);
	}

//	/**
//	 * Status changed to {@link HistoryStatus} delete.
//	 * @param context
//	 * @return
//	 */
//	public History delete(DocumentContext context) {
//		LocalDateTime createdOn = LocalDateTime.now();
//		History history = new History(context.documentComment.get(), createdOn , createdOn, context.current.get().getId());
//		history.setStatus(HistoryStatus.DELETE.getStatusValue());
//		JRegisPlatform.getInstance(HistoryRepository.class).save(history);
//		return history;
//	}
//
//	/**
//	 * Delete from database.
//	 * @param context
//	 * @return
//	 */
//	public History deleteFromDB(DocumentContext context) {
//		LocalDateTime createdOn = LocalDateTime.now();
//		History history = new History(context.documentComment.get(), createdOn , createdOn, context.current.get().getId());
//		JRegisPlatform.getInstance(HistoryRepository.class).delete(history);
//		return history;
//	}
}

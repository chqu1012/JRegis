package de.dc.fx.ui.jregis.metro.ui.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import de.dc.fx.ui.jregis.metro.ui.model.AttachmentStatus;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.repository.AttachmentRepository;

public class AttachmentService {

	/**
	 * Create new attachments with aggregation to history in database.
	 * @param context
	 * @return
	 */
	public List<Attachment> create(History history, String... names) {
		List<Attachment> attachments = new ArrayList<>();
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
	public Attachment create(History history, String name) {
		LocalDateTime createdOn = LocalDateTime.now();
		
		Attachment attachment = new Attachment(name, createdOn, createdOn, history.getId());
		attachment.setStatus(AttachmentStatus.ADD.getStatusValue());
		long attachmentId = JRegisPlatform.getInstance(AttachmentRepository.class).save(attachment);
		attachment.setId(attachmentId);
		
		history.getAttachments().add(attachment);
		
		return attachment;
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

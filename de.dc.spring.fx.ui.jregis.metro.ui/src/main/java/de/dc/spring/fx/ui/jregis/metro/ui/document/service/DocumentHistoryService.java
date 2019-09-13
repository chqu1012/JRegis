package de.dc.spring.fx.ui.jregis.metro.ui.document.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentContext;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentHistory;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentHistoryStatus;
import de.dc.spring.fx.ui.jregis.metro.ui.document.repository.DocumentHistoryRepository;

@Service
public class DocumentHistoryService {

	@Autowired DocumentAttachmentService attachmentService;
	@Autowired DocumentHistoryRepository historyRepository;
	
	/**
	 * Create a history with aggregated attachments.
	 * @param context
	 * @param attachments
	 * @return
	 */
	public DocumentHistory create(DocumentContext context, String... attachments) {
		DocumentHistory history = create(context);
		attachmentService.create(history, attachments);
		return history;
	}
	
	/**
	 * Create a new history item in database.
	 * @param context
	 * @return
	 */
	public DocumentHistory create(DocumentContext context) {
		LocalDateTime createdOn = LocalDateTime.now();
		DocumentHistory history = new DocumentHistory(context.documentComment.get(), createdOn , createdOn, context.current.get().getId());
		history.setStatus(DocumentHistoryStatus.ADD.getStatusValue());
		return historyRepository.save(history);
	}

	/**
	 * Status changed to {@link DocumentHistoryStatus} delete.
	 * @param context
	 * @return 
	 * @return
	 */
	public DocumentHistory delete(DocumentContext context) {
		LocalDateTime createdOn = LocalDateTime.now();
		DocumentHistory history = new DocumentHistory(context.documentComment.get(), createdOn , createdOn, context.current.get().getId());
		history.setStatus(DocumentHistoryStatus.DELETE.getStatusValue());
		historyRepository.save(history);
		return history;
	}

	/**
	 * Delete from database.
	 * @param context
	 * @return
	 */
	public void deleteFromDB(DocumentContext context) {
		LocalDateTime createdOn = LocalDateTime.now();
		DocumentHistory history = new DocumentHistory(context.documentComment.get(), createdOn , createdOn, context.current.get().getId());
		historyRepository.delete(history);
	}
}

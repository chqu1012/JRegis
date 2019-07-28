package de.dc.fx.ui.jregis.metro.ui.service;

import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.control.binding.DocumentContext;
import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.model.HistoryStatus;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;

public class HistoryService {

	/**
	 * Create a new history item in database.
	 * @param context
	 * @return
	 */
	public History create(DocumentContext context) {
		LocalDateTime createdOn = LocalDateTime.now();
		History history = new History(context.documentComment.get(), createdOn , createdOn, context.current.get().getId());
		history.setStatus(HistoryStatus.ADD.getStatusValue());
		long id = JRegisPlatform.getInstance(HistoryRepository.class).save(history);
		history.setId(id);
		return history;
	}

	/**
	 * Status changed to {@link HistoryStatus} delete.
	 * @param context
	 * @return
	 */
	public History delete(DocumentContext context) {
		LocalDateTime createdOn = LocalDateTime.now();
		History history = new History(context.documentComment.get(), createdOn , createdOn, context.current.get().getId());
		history.setStatus(HistoryStatus.DELETE.getStatusValue());
		JRegisPlatform.getInstance(HistoryRepository.class).save(history);
		return history;
	}

	/**
	 * Delete from database.
	 * @param context
	 * @return
	 */
	public History deleteFromDB(DocumentContext context) {
		LocalDateTime createdOn = LocalDateTime.now();
		History history = new History(context.documentComment.get(), createdOn , createdOn, context.current.get().getId());
		JRegisPlatform.getInstance(HistoryRepository.class).delete(history);
		return history;
	}
}

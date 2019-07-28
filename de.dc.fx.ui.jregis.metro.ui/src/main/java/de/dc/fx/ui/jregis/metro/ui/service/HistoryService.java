package de.dc.fx.ui.jregis.metro.ui.service;

import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.control.binding.DocumentContext;
import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;

public class HistoryService {

	public History create(DocumentContext context) {
		LocalDateTime createdOn = LocalDateTime.now();
		History history = new History(context.documentComment.get(), createdOn , createdOn, context.current.get().getId());
		long id = JRegisPlatform.getInstance(HistoryRepository.class).save(history);
		history.setId(id);
		return history;
	}
}

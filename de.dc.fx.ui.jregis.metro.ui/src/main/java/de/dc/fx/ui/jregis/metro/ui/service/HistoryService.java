package de.dc.fx.ui.jregis.metro.ui.service;

import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;

public class HistoryService {

	public History create(Document document, String name) {
		LocalDateTime createdOn = LocalDateTime.now();
		History history = new History(name, createdOn , createdOn, document.getId());
		long id = JRegisPlatform.getInstance(HistoryRepository.class).save(history);
		history.setId(id);
		return history;
	}
}

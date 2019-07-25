package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

public class DocumentFlatDetails extends BaseDocumentFlatDetails {

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	private Document document;
	
	public DocumentFlatDetails() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/dc/fx/ui/jregis/metro/ui/DocumentFlatDetails.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml ", exception);
		}
	}

	public void setSelection(Document document) {
		this.document = document;
	}
	
	@Override
	protected void onLinkBackAction(ActionEvent event) {
		root.toBack();
	}

	@Override
	protected void onButtonSubmitComment(ActionEvent event) {
		String comment = textAreaComment.getText();
		textAreaComment.clear();
		
		History history = new History(comment, document.getId(), LocalDateTime.now());
		JRegisPlatform.getInstance(HistoryRepository.class).save(history);
	}
	
	
}

package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

public class DocumentFlatDetails extends BaseDocumentFlatDetails {

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	
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

	@Override
	protected void onLinkBackAction(ActionEvent event) {
		root.toBack();
	}
	
	
}

package de.dc.spring.fx.ui.jregis.metro.ui.document;

import static de.dc.spring.fx.ui.jregis.metro.ui.main.UIConstants.FXML_DOCUMENT_DETAILS;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.controlsfx.control.Rating;

import javafx.fxml.FXMLLoader;

public abstract class BaseDocumentDetails extends AbstractFxmlDocumentDetails{
	
	protected Logger log = Logger.getLogger(getClass().getSimpleName());
	protected Rating rating = new Rating(5);
	
	public BaseDocumentDetails() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_DOCUMENT_DETAILS));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.error("Failed to load fxml ", exception);
		}
		
		hboxTitle.getChildren().add(rating);
	}
}

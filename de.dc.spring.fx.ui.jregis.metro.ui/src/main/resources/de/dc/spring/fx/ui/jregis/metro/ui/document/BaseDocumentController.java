package de.dc.spring.fx.ui.jregis.metro.ui.document;

import org.apache.log4j.Logger;

import de.dc.spring.fx.ui.jregis.metro.ui.document.controller.DocumentDetails;
import javafx.scene.layout.AnchorPane;

public abstract class BaseDocumentController extends AbstractFxmlDocumentController {

	protected Logger log = Logger.getLogger(getClass().getSimpleName());
	
	protected DocumentDetails documentDetails = new DocumentDetails();
	
	public void initialize() {
		AnchorPane.setTopAnchor(documentDetails, 0d);
		AnchorPane.setBottomAnchor(documentDetails, 0d);
		AnchorPane.setLeftAnchor(documentDetails, 0d);
		AnchorPane.setRightAnchor(documentDetails, 0d);
		root.getChildren().add(0, documentDetails);
		
		closeNewDocumentPane();
	}
	
	public void closeNewDocumentPane() {
		vboxDocumentOverviewContent.getChildren().remove(paneAddNewDocument);
	}

	public void openNewDocumentPane() {
		vboxDocumentOverviewContent.getChildren().add(paneAddNewDocument);
	}
	
}

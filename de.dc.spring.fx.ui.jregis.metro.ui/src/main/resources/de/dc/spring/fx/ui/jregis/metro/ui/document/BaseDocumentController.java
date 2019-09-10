package de.dc.spring.fx.ui.jregis.metro.ui.document;

import org.apache.log4j.Logger;

import de.dc.spring.fx.ui.jregis.metro.ui.document.controller.DocumentDetails;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.layout.AnchorPane;

public abstract class BaseDocumentController extends AbstractFxmlDocumentController {

	protected Logger log = Logger.getLogger(getClass().getSimpleName());
	
	protected DocumentDetails documentDetails = new DocumentDetails();
	
	protected ObservableList<Document> documentData = FXCollections.observableArrayList();
	protected FilteredList<Document> filteredDocuments = new FilteredList<>(documentData, p -> true);
	
	public void initialize() {
		AnchorPane.setTopAnchor(documentDetails, 0d);
		AnchorPane.setBottomAnchor(documentDetails, 0d);
		AnchorPane.setLeftAnchor(documentDetails, 0d);
		AnchorPane.setRightAnchor(documentDetails, 0d);
		root.getChildren().add(0, documentDetails);
		
		closeNewDocumentPane();
		
		tableViewDocument.setItems(filteredDocuments);
	}
	
	public void closeNewDocumentPane() {
		if (vboxDocumentOverviewContent.getChildren().contains(paneAddNewDocument)) {
			vboxDocumentOverviewContent.getChildren().remove(paneAddNewDocument);
		}
	}

	public void openNewDocumentPane() {
		if (!vboxDocumentOverviewContent.getChildren().contains(paneAddNewDocument)) {
			vboxDocumentOverviewContent.getChildren().add(paneAddNewDocument);
		}
	}
	
}

package de.dc.spring.fx.ui.jregis.metro.ui.document.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.spring.fx.ui.jregis.metro.ui.document.BaseReferenceControl;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentReference;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

public class ReferenceControl extends BaseReferenceControl {

	private Logger log = Logger.getLogger(ReferenceControl.class.getSimpleName());
	public static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/document/References.fxml";
	private DocumentReference reference;
	private boolean isParent;

	public ReferenceControl(DocumentReference reference, boolean isParent) {
		this.isParent = isParent;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml "+FXML, exception);
		}
		this.setReference(reference);
	}

	@Override
	protected void onImageIconDeleteClicked(MouseEvent event) {
	}

	@Override
	protected void onLabelFilenameClicked(MouseEvent event) {
		long id = isParent? reference.getFirstId() : reference.getSecondId();
		EventBroker.getDefault().post(new EventContext<>("/set/current/doccument", id));		
	}

	public DocumentReference getReference() {return reference;}

	public void setReference(DocumentReference reference) {
		this.reference = reference;
		long id = isParent? reference.getFirstId() : reference.getSecondId();
		String referenceType =isParent? "Parent" : "Child";
		String color = isParent ? "darkred" : "gray";
		labelDocumentName.setText(String.format("JREG-%05d: %s", id, reference.getName()));
		labelReferenceType.setText(referenceType+" Reference");
		labelReferenceType.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: white; -fx-background-radius: 2;", color));
	}
}
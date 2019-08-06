package de.dc.fx.ui.jregis.metro.ui.control.document.management;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.model.Reference;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentRepository;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

public class ReferenceControl extends BaseReferenceControl {

	private Logger log = Logger.getLogger(ReferenceControl.class.getSimpleName());
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/References.fxml";
	private Reference reference;
	private boolean isParent;

	public ReferenceControl(Reference reference, boolean isParent) {
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
		Optional<Document> optionalDocument = JRegisPlatform.getInstance(DocumentRepository.class).findById(id);
		optionalDocument.ifPresent(d->JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<Document>("/set/current/doccument", d)));		
	}

	public Reference getReference() {return reference;}

	public void setReference(Reference reference) {
		this.reference = reference;
		long id = isParent? reference.getFirstId() : reference.getSecondId();
		String referenceType =isParent? "Parent" : "Child";
		String color = isParent ? "darkred" : "gray";
		Optional<Document> optionalDocument = JRegisPlatform.getInstance(DocumentRepository.class).findById(id);
		optionalDocument.ifPresent(d->{
			labelDocumentName.setText(String.format("JREG-%05d: %s", d.getId(), d.getName()));
			labelReferenceType.setText(referenceType+" Reference");
			labelReferenceType.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: white; -fx-background-radius: 2;", color));
		});
	}
}
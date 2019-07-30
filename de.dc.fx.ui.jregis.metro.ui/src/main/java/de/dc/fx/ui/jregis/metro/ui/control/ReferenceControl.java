package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.model.Reference;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentRepository;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

public class ReferenceControl extends BaseReferenceControl {

	private Logger log = Logger.getLogger(ReferenceControl.class.getSimpleName());
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/References.fxml";
	private Reference reference;

	public ReferenceControl(Reference reference) {
		this.setReference(reference);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml " + FXML, exception);
		}
	}

	@Override
	protected void onImageIconDeleteClicked(MouseEvent event) {
	}

	@Override
	protected void onLabelFilenameClicked(MouseEvent event) {
	}

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
		Optional<Document> optionalDocument = JRegisPlatform.getInstance(DocumentRepository.class)
				.findById(reference.getSecondId());
		optionalDocument.ifPresent(d -> {
			labelDocumentName.setText(String.format("JREG-%05d: %s", d.getId(), d.getName()));
		});
	}
}
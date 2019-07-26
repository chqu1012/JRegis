package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import javafx.fxml.FXMLLoader;

public class AttachmentControl extends BaseAttachmentControl {

	private Logger log = Logger.getLogger(AttachmentControl.class.getSimpleName());
	
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/Attachment.fxml";

	public AttachmentControl(Attachment attachment) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml "+FXML, exception);
		}
		
		setAttachent(attachment);
	}
	
	public void setAttachent(Attachment attachment) {
		labelFilename.setText(attachment.getName());
		imageViewFileType.setImage(DocumentFileItem.getFileIcon(attachment.getName()));
	}
}

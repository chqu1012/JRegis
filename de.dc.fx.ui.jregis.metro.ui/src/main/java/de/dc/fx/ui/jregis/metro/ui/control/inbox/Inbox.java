package de.dc.fx.ui.jregis.metro.ui.control.inbox;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.fx.ui.jregis.metro.ui.control.document.management.AttachmentControl;
import javafx.fxml.FXMLLoader;

public class Inbox extends BaseInbox {

	private Logger log = Logger.getLogger(AttachmentControl.class.getSimpleName());
	
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/inbox/Inbox.fxml";

	public Inbox() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml "+FXML, exception);
		}
		
		for (int i = 0; i < 20; i++) {
			vboxInbox.getChildren().add(new InboxItem());
		}
	}
}

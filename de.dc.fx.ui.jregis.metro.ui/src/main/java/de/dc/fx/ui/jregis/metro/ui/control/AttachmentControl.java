package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.Notifications;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import de.dc.fx.ui.jregis.metro.ui.util.DialogUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

public class AttachmentControl extends BaseAttachmentControl {

	private Logger log = Logger.getLogger(AttachmentControl.class.getSimpleName());
	
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/Attachment.fxml";

	private Attachment attachment;

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
	
	public Attachment getAttachment() {
		return attachment;
	}
	
	public void setAttachent(Attachment attachment) {
		this.attachment = attachment;
		labelFilename.setText(attachment.getName());
		imageViewFileType.setImage(DocumentFileItem.getFileIcon(attachment.getName()));
		tooltip.setText(attachment.getName());
	}

	@Override
	protected void onImageIconDeleteClicked(MouseEvent event) {
		Optional<ButtonType> dialog = DialogUtil.openQuestion("Delete Attachment", "Do you really want to delete the Attachment with ID: "+attachment.getId(), "Delete Attachment "+ attachment.getName());
		dialog.ifPresent(e->{
			if (e.getButtonData()==ButtonData.OK_DONE) {
				JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<>("/attachment/delete", attachment));
				Notifications.create().darkStyle().text("Deleted Attachment "+attachment.getName()).title("Deleted").showInformation();
			}
		});
		
	}

	@Override
	protected void onLabelFilenameClicked(MouseEvent event) {
		JRegisPlatform.getInstance(IEventBroker.class).post(new EventContext<>("/open/file/attachment", labelFilename.getText()));		
	}
}

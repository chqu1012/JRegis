package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.Notifications;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;
import de.dc.fx.ui.jregis.metro.ui.util.ClipboardHelper;
import de.dc.fx.ui.jregis.metro.ui.util.DocumentUtil;
import de.dc.fx.ui.jregis.metro.ui.util.ImageHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;

public class DocumentClipboardPane extends BaseDocumentClipboardPane{

	private Logger log = Logger.getLogger(DocumentClipboardPane.class.getSimpleName());
	
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/DocumentClipboardPane.fxml";

	private Document selection;

	public DocumentClipboardPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to fxml "+FXML, exception);
		}
	}
	
	public void setSelection(Document selection) {
		this.selection = selection;
		ClipboardHelper.getImage().ifPresent(image->clipboardImage.setImage(image));
		documentClipboardPane.toFront();
	}

	@Override
	protected void onCloseDocumentClipboardPaneClicked(MouseEvent event) {
		documentClipboardPane.toBack();
	}

	@Override
	protected void onDocumentClipboardCancelButtonClicked(ActionEvent event) {
		documentClipboardPane.toBack();
	}

	@Override
	protected void onDocumentClipboardImageMouseClicked(MouseEvent event) {
		clipboardImage.setImage(null);
		ClipboardHelper.getImage().ifPresent(img->clipboardImage.setImage(img));
		transactionMessageText.setText("Save clipboard image.");		
	}

	@Override
	protected void onDocumentClipboardPasteButtonClicked(ActionEvent event) {
		String destinationPath = JRegisPlatform.getInstance(DocumentUtil.class).getFolderBy(selection).getAbsolutePath();
		String name = fileNameSuggesstionCombo.getSelectionModel().getSelectedItem()+".png";
		if (useFileIdButton.isSelected()) {
			name = String.format("%02d", Integer.parseInt(fileIdText.getText()))+"-"+name;
		}
		
		ImageHelper.saveToFile(destinationPath + "/" + name, clipboardImage.getImage());
		Notifications.create().title("Clipboard Notification").text("Save image to destination path: " + destinationPath + "/" + name).showInformation();	
		
		String message = transactionMessageText.getText();
		History history = new History(message, selection.getId(), LocalDateTime.now());
		JRegisPlatform.getInstance(HistoryRepository.class).save(history);
		
		documentClipboardPane.toBack();
	}

	@Override
	protected void onEditFileNameSuggestionClicked(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onFileNameSuggestionDeleteClicked(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onNewFileNameSuggesttionClicked(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}

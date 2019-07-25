package de.dc.fx.ui.jregis.metro.ui.control;

import static de.dc.fx.ui.jregis.metro.ui.control.DocumentFileItem.getFileIcon;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.Notifications;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DocumentFlatDetails extends BaseDocumentFlatDetails {

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	private Document document;

	public DocumentFlatDetails() {
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("/de/dc/fx/ui/jregis/metro/ui/DocumentFlatDetails.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml ", exception);
		}
	}

	public void setSelection(Document document) {
		this.document = document;
		vboxComment.getChildren().clear();
        vboxComment.getChildren().add(vboxCommentEditBox);
        
		List<History> histories = JRegisPlatform.getInstance(HistoryRepository.class).findAll();
		histories.stream().filter(e -> e.getDocumentId() == document.getId()).forEach(this::addHistory);
		
		root.requestFocus();
	}

	private void addHistory(History history) {
		DocumentHistoryItem item = new DocumentHistoryItem();
		item.setHistory(history, t -> {
//		String path = parentPath+"/"+t;
//		openFileExecuter.accept(path);
		});
		vboxComment.getChildren().add(item);
	}

	@Override
	protected void onLinkBackAction(ActionEvent event) {
		root.toBack();
	}

	@Override
	protected void onButtonSubmitComment(ActionEvent event) {
		String comment = textAreaComment.getText();
		textAreaComment.clear();
		
		History history = new History(comment, document.getId(), LocalDateTime.now());
		JRegisPlatform.getInstance(HistoryRepository.class).save(history);
		
		Notifications.create().title("New Comment").text("Created new comment with attachments!").darkStyle().show();
		
		addHistory(history);
	}

	@Override
	protected void onButtonAttachmentsAction(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		List<File> files = chooser.showOpenMultipleDialog(new Stage());
		if (files!=null) {
			flowPaneFiles.getChildren().clear();
			files.stream().forEach(e->flowPaneFiles.getChildren().add(new Hyperlink(e.getName(), new ImageView(getFileIcon(e.getName())))));
		}		
	}

	@Override
	protected void onScrollPaneKeyPressed(KeyEvent e) {
		if (e.getCode().equals(KeyCode.ESCAPE)) {
			root.toBack();
		}
	}
}

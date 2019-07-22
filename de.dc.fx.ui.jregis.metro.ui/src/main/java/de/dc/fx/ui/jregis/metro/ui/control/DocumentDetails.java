package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.controlsfx.control.Notifications;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class DocumentDetails extends BaseDocumentDetails {

	private DocumentClipboardPane documentClipboardPane = new DocumentClipboardPane();
	private Document document;

	public DocumentDetails() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/dc/fx/ui/jregis/metro/ui/DocumentDetails.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
		
		stackPaneContent.getChildren().add(documentClipboardPane);
		documentClipboardPane.toBack();
	}
	
	private void addHistory(History history) {
		DocumentHistoryItem item = new DocumentHistoryItem();
		item.setHistory(history, t -> {
//			String path = parentPath+"/"+t;
//			openFileExecuter.accept(path);
		});
		vboxContent.getChildren().add(item);
	}
	
	public void setDocument(Document document) {
		this.document = document;
		
		vboxContent.getChildren().clear();
		
		List<History> histories = JRegisPlatform.getInstance(HistoryRepository.class).findAll();
		histories.stream()
			.filter(p->p.getDocumentId().equals(document.getId()))
			.forEach(this::addHistory);
		
	}

	@Override
	protected void onDocumentDetailsCloseAction(ActionEvent event) {
		root.toBack();
	}
	
	@Override
	protected void onFileListDragDropped(DragEvent event) {
		Dragboard db = event.getDragboard();
		boolean success = false;
		if (db.hasFiles() && document!=null) {
//			DialogUtil.openInput("Transaction Message Dialog", "Dragged files.", "Dragged Files into document folder.", "Dragged Files into document folder.", message ->{
//				populateFilesData(db.getFiles());
//				String fileNames = db.getFiles().stream().map(e->e.getName()).reduce("", ( s1, s2 ) -> (s1.isEmpty()) ? s2 : s1 + "," + s2 );
//				DocumentHistory history = historyList.createNewHistoryFile(selection, fileNames, message);
//				documentHistoryRepository.save(history);
//			});
			success = true;
			Optional<String> files = db.getFiles().stream().map(e-> e.getName()).reduce((e1, e2)->e1+", "+e2);
			files.ifPresent(s->Notifications.create().title("Clipboard Notification").text("Import file(s): " + s + " sucessfully!").showInformation());
		}
		labelDraggingFiledIntoField.getStyleClass().clear();
		labelDraggingFiledIntoField.getStyleClass().add("dragged-file-label");
		event.setDropCompleted(success);
		event.consume();		
	}

	@Override
	protected void onFileListDragOver(DragEvent event) {
		labelDraggingFiledIntoField.getStyleClass().clear();
		labelDraggingFiledIntoField.getStyleClass().add("dragged-file-label-dragged");
		if (event.getGestureSource() != listViewDocumentContentFiles && event.getDragboard().hasFiles()) {
			event.acceptTransferModes(TransferMode.COPY);
		}
		event.consume();		
	}

	@Override
	protected void onButtonOpenDirectoryAction(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onButtonOpenFileChooserToCopyAction(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onButtonAddFromClipboardAction(ActionEvent event) {
		documentClipboardPane.setSelection(document);
	}

	@Override
	protected void onButtonDownloadViaUrlAction(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}

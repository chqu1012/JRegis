package de.dc.fx.ui.jregis.metro.ui.control.document.management;

import static de.dc.fx.ui.jregis.metro.ui.control.document.management.DocumentFlatDetails.ID_DELETE_HISTORY;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventContext;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import de.dc.fx.ui.jregis.metro.ui.model.History;
import de.dc.fx.ui.jregis.metro.ui.model.HistoryStatus;
import de.dc.fx.ui.jregis.metro.ui.util.DialogUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class DocumentHistoryItem extends AnchorPane {

	@FXML
	protected VBox fileContainer;

	@FXML
	protected Label message;

	@FXML
	protected Label createdTimestamp;

	@FXML
	protected Tooltip tooltip;

	@FXML
	protected ImageView tooltipImageView;
	
	@FXML
	protected Label labelColor;

	private Map<Attachment, DocumentFileItem> attachmentLinks = new HashMap<>(); 
	
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/DocumentsHistoryItem.fxml";

	private History history;

	public DocumentHistoryItem() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	public History getHistory() {
		return history;
	}
	
	public boolean isHistory(History history) {
		return this.history.getId()==history.getId();
	}
	
	public void setHistory(History history, Consumer<String> executer) {
		this.history = history;
		
		createdTimestamp.setText(history.getCreatedOn().toString());
		message.setText(history.getName());
		history.getAttachments().stream().forEach(e -> {
			DocumentFileItem item = new DocumentFileItem();
			item.set(e.getName(), executer);
			fileContainer.getChildren().add(item);
			
			attachmentLinks.put(e, item);
		});
		
		String style = history.getStatus()==HistoryStatus.ADD.getStatusValue()? "add" : "delete";
		
		labelColor.getStyleClass().clear();
		labelColor.getStyleClass().add("labelColor-"+style);
	}
	
	public void findAndDeactivateAttachment(Attachment attachment) {
		DocumentFileItem item = attachmentLinks.get(attachment);
		if (item!=null) {
			item.setDisable(true);
		}
	}
	
	@FXML
	protected void onImageViewZipClicked(MouseEvent e) {
		
	}

	@FXML
	protected void onImageViewDeleteClicked(MouseEvent e) {
		DialogUtil.openQuestion("Delete History", "Do you really want to delete history with ID: "+history.getId(), "Delete history "+history.getName()).ifPresent(e1->{
			if (e1.getButtonData()==ButtonData.OK_DONE) {
				EventContext<History> context = new EventContext<>(ID_DELETE_HISTORY, history);
				JRegisPlatform.getInstance(IEventBroker.class).post(context);
			}
		});
	}
}

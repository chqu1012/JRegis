package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.util.function.Consumer;

import de.dc.fx.ui.jregis.metro.ui.model.History;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
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

	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/DocumentsHistoryItem.fxml";

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

	public void setHistory(History history, Consumer<String> executer) {
		createdTimestamp.setText(history.getCreatedOn().toString());
		message.setText(history.getName());
		history.getAttachments().stream().forEach(e -> {
			DocumentFileItem item = new DocumentFileItem();
			item.set(e.getName(), executer);
			fileContainer.getChildren().add(item);
		});
	}
}

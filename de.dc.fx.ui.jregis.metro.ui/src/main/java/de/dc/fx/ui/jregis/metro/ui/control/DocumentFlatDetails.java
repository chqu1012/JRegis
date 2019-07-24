package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class DocumentFlatDetails extends BaseDocumentFlatDetails {

	public DocumentFlatDetails() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/de/dc/fx/ui/jregis/metro/ui/DocumentFlatDetails.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
		
		for (int i = 0; i < 20; i++) {
			vboxComment.getChildren().add(new Button("It is a small Button on my side!"));
		}
	}
}

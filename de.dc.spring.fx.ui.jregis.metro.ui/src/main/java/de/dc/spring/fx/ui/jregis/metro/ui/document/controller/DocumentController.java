package de.dc.spring.fx.ui.jregis.metro.ui.document.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import de.dc.spring.fx.ui.jregis.metro.ui.document.BaseFxmlDocumentController;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

@Controller
public class DocumentController extends BaseFxmlDocumentController {

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	
	private DocumentDetails documentDetails = new DocumentDetails();
	
	public void initialize() {
		AnchorPane.setTopAnchor(documentDetails, 0d);
		AnchorPane.setBottomAnchor(documentDetails, 0d);
		AnchorPane.setLeftAnchor(documentDetails, 0d);
		AnchorPane.setRightAnchor(documentDetails, 0d);
		root.getChildren().add(0, documentDetails);
	}
	
	@Override
	protected void onButtonAction(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onTableMenuItemAction(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onTableViewDocumentClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			Document selection = tableViewDocument.getSelectionModel().getSelectedItem();
			if (selection != null) {
				Task<Void> task = new Task<Void>() {
					@Override
					protected Void call() throws Exception {
						// TODO: Should be implemented!
//						Platform.runLater(() -> documentDetails.setSelection(selection));
						return null;
					}
				};
				new Thread(task).start();
				documentDetails.toFront();
			}
		}		
	}

	@Override
	protected void onTreeContextMenuAction(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}

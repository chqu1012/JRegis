package de.dc.spring.fx.ui.jregis.metro.ui.document.controller;

import org.springframework.stereotype.Controller;

import de.dc.spring.fx.ui.jregis.metro.ui.document.BaseDocumentController;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

@Controller
public class DocumentController extends BaseDocumentController {

	@Override
	protected void onButtonAction(ActionEvent event) {
		Object source = event.getSource();
		if (source == linkCancelDocument) {
			closeNewDocumentPane();
		}else if (source == buttonCreateDocument) {
			log.trace("Create new document");
			closeNewDocumentPane();
		}
	}

	@Override
	protected void onTableMenuItemAction(ActionEvent event) {
		Object source = event.getSource();
		if (source==tableMenuItemNew) {
			openNewDocumentPane();
		}
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

package de.dc.spring.fx.ui.jregis.metro.ui.document.controller;

import java.time.LocalDateTime;

import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.dc.spring.fx.ui.jregis.metro.ui.document.BaseDocumentController;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import de.dc.spring.fx.ui.jregis.metro.ui.document.repository.DocumentRepository;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

@Controller
public class DocumentController extends BaseDocumentController {

	@Autowired DocumentRepository documentReposity;
	
	@Override
	public void initialize() {
		super.initialize();
		documentData.addAll(documentReposity.findAll());
	}
	
	@Override
	protected void onButtonAction(ActionEvent event) {
		Object source = event.getSource();
		if (source == linkCancelDocument) {
			closeNewDocumentPane();
		}else if (source == buttonCreateDocument) {
			String name = textDocumentName.getText();
			String description = textDescription.getText();
			LocalDateTime createdOn = LocalDateTime.now();

			Document document = new Document(name, description, -1L, createdOn, createdOn);
			documentReposity.save(document);
//			Category category = comboBoxCategory.getSelectionModel().getSelectedItem();
//			if (category != null) {
//				document.setCategoryId(category.getId());
//			}

			documentData.add(0,document);
			
			textDocumentName.setText("");
			textDescription.setText("");
			textUrl.setText("");
			Notifications.create().darkStyle().title("Document item created!").text("Created document "+name+"!").show();			
			
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
				Platform.runLater(() -> documentDetails.setSelection(selection));
				documentDetails.toFront();
			}
		}		
	}

	@Override
	protected void onTreeContextMenuAction(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}

package de.dc.spring.fx.ui.jregis.metro.ui.document.controller;

import java.time.LocalDateTime;

import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.dc.spring.fx.ui.jregis.metro.ui.document.BaseDocumentController;
import de.dc.spring.fx.ui.jregis.metro.ui.document.factory.CategoryComboCell;
import de.dc.spring.fx.ui.jregis.metro.ui.document.factory.CategoryComboConvertor;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentCategory;
import de.dc.spring.fx.ui.jregis.metro.ui.document.repository.DocumentCategoryRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.document.repository.DocumentRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.util.DialogUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;

@Controller
public class DocumentController extends BaseDocumentController {

	@Autowired DocumentRepository documentReposity;
	@Autowired DocumentCategoryRepository categoryRepository;
	
	@Override
	public void initialize() {
		super.initialize();
		initTreeView(categoryRepository);
		initControls();
	}
	
	private void initControls() {
		comboBoxCategory.setItems(categoryData);
		comboBoxCategory.setCellFactory(e->new CategoryComboCell());
		comboBoxCategory.setConverter(new CategoryComboConvertor());
	}

	@Override
	protected void initRepositoryData() {
		documentData.addAll(documentReposity.findAllByOrderByIdDesc());
		categoryData.addAll(categoryRepository.findAllByOrderByNameAsc());
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
			DocumentCategory category = comboBoxCategory.getSelectionModel().getSelectedItem();
			if (category != null) {
				document.setCategoryId(category.getId());
			}

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
		TreeItem<DocumentCategory> selection = treeView.getSelectionModel().getSelectedItem();
		if (selection != null) {
			Object source = event.getSource();
			DocumentCategory category = selection.getValue();
			if (source == menuItemTreeDelete) {
				categoryRepository.delete(category);
				selection.getParent().getChildren().remove(selection);
			} else if (source == menuItemTreeEdit) {
				throw new UnsupportedOperationException("Not implemented yet!");
			} else if (source == menuItemTreeNew) {
				DialogUtil.openInput("New Category", "New Category", "Please give a name for the new category", "Please give a name for the new category", e->{
					if (e!=null) {
						LocalDateTime createdOn = LocalDateTime.now();
						DocumentCategory newCategory = new DocumentCategory(e, createdOn, createdOn, category.getId());
						categoryRepository.save(newCategory);
						selection.getChildren().add(new TreeItem<DocumentCategory>(newCategory));
						selection.setExpanded(true);
					}
				});
			}
		}		
	}
}

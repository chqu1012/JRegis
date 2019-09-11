package de.dc.spring.fx.ui.jregis.metro.ui.document.controller;

import java.time.LocalDateTime;
import java.util.Optional;

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
import de.dc.spring.fx.ui.jregis.metro.ui.document.service.DocumentFolderService;
import de.dc.spring.fx.ui.jregis.metro.ui.util.DialogUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;

@Controller
public class DocumentController extends BaseDocumentController {

	@Autowired DocumentRepository documentReposity;
	@Autowired DocumentCategoryRepository categoryRepository;
	@Autowired DocumentFolderService folderService;
	
	@Override
	public void initialize() {
		super.initialize();
		initTreeView(categoryRepository);
		initControls();
		
		folderService.createIfNotExist();
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
			dispatchCreateDocument();
		}else if (source == buttonCategoryEdit) {
			DocumentCategory selection = comboBoxCategory.getSelectionModel().getSelectedItem();
			dispatchEditCategory(selection);
		}
	}

	private void dispatchEditCategory(DocumentCategory selection) {
		if (selection != null) {
			DialogUtil.openInput("Edit Category", selection.getName(), "Edit Category", "", e -> {
				selection.setName(e);
				categoryRepository.save(selection);
				categoryData.clear();
				categoryData.addAll(categoryRepository.findAll());
				comboBoxCategory.getSelectionModel().select(selection);
			});
		}		
	}

	@Override
	protected void onTableMenuItemAction(ActionEvent event) {
		Object source = event.getSource();
		if (source==tableMenuItemNew) {
			openNewDocumentPane();
		}else if (source==tableMenuItemDelete) {
			dispatchDeleteDocument();
		}else if (source==tableMenuItemOpenDirectory) {
			dispatchOpenDocumentFolder();
		}
	}

	private void dispatchOpenDocumentFolder() {
		Document selection = tableViewDocument.getSelectionModel().getSelectedItem();
		try {
			folderService.openFolder(selection);
		} catch (Exception e) {
			log.error("Failed to open document folder "+selection.getName(), e);
			Notifications.create().darkStyle().title("File Error").text("Failed to open document folder "+selection.getName()).show();
		}
	}

	private void dispatchDeleteDocument() {
		Document selection = tableViewDocument.getSelectionModel().getSelectedItem();
		if (selection != null) {
			String message = "Do you really want to delete \"" + selection.getName() + "\"";
			Optional<ButtonType> dialog = DialogUtil.openQuestion("Delete Selection",
					"Delete selected document with ID: " + selection.getId(), message);
			dialog.ifPresent(e -> {
				if (e.getButtonData().equals(ButtonData.OK_DONE)) {
					documentReposity.delete(selection);
					Notifications.create().darkStyle().title("Delete selection").text(message).show();
					documentData.remove(selection);
				}
			});
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
				dispatchEditCategory(selection.getValue());
			} else if (source == menuItemTreeNew) {
				dispatchCreateCategory(selection, category);
			}
		}		
	}

	private void dispatchCreateCategory(TreeItem<DocumentCategory> selection, DocumentCategory category) {
		DialogUtil.openInput("New Category", "New Category", "Please give a name for the new category", "Please give a name for the new category", e->{
			if (e!=null) {
				LocalDateTime createdOn = LocalDateTime.now();
				DocumentCategory newCategory = new DocumentCategory(e, createdOn, createdOn, category.getId());
				categoryRepository.save(newCategory);
				categoryData.add(newCategory);
				comboBoxCategory.getSelectionModel().select(category);
				selection.getChildren().add(new TreeItem<DocumentCategory>(newCategory));
				selection.setExpanded(true);
			}
		});
	}
	
	private void dispatchCreateDocument() {
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

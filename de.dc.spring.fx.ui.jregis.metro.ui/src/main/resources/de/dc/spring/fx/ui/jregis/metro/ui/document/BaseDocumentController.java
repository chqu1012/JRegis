package de.dc.spring.fx.ui.jregis.metro.ui.document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.controlsfx.control.table.TableFilter;

import de.dc.spring.fx.ui.jregis.metro.ui.document.controller.DocumentDetails;
import de.dc.spring.fx.ui.jregis.metro.ui.document.factory.ColumnJRegisIdFeature;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentCategory;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;

public abstract class BaseDocumentController extends AbstractFxmlDocumentController {

	protected Logger log = Logger.getLogger(getClass().getSimpleName());
	
	protected DocumentDetails documentDetails = new DocumentDetails();
	
	protected ObservableList<Document> documentData = FXCollections.observableArrayList();
	protected FilteredList<Document> filteredDocuments = new FilteredList<>(documentData, p -> true);

	protected ObservableList<DocumentCategory> categoryData = FXCollections.observableArrayList();
	protected FilteredList<DocumentCategory> filteredCategories = new FilteredList<>(categoryData, p -> true);
	
	protected TableFilter<Document> tableFilter;
	protected TreeItem<DocumentCategory> rootItem;
	private Map<Long, DocumentCategory> categoryRegistry = new TreeMap<>();
	
	public void initialize() {
		initRepositoryData();
		
		AnchorPane.setTopAnchor(documentDetails, 0d);
		AnchorPane.setBottomAnchor(documentDetails, 0d);
		AnchorPane.setLeftAnchor(documentDetails, 0d);
		AnchorPane.setRightAnchor(documentDetails, 0d);
		root.getChildren().add(0, documentDetails);
		
		closeNewDocumentPane();
		
		initTableView();
	}

	protected abstract void initRepositoryData();

	private void initTableView() {
		columnId.setCellValueFactory(e -> new SimpleObjectProperty<>(e.getValue()));
		columnId.setCellFactory(e -> new ColumnJRegisIdFeature());
		setupCellValueFactory(columnName, e -> new SimpleObjectProperty<>(e.getName()));
		setupCellValueFactory(columnCreated, e -> new SimpleObjectProperty<>(e.getCreatedOn().toString()));
		setupCellValueFactory(columnUpdated, e -> new SimpleObjectProperty<>(e.getUpdatedOn().toString()));
		columnCategory.setCellValueFactory(param -> {
			Optional<DocumentCategory> optionalCategory = categoryData.stream().filter(e-> e.getId().equals(param.getValue().getCategoryId())).findFirst();
			if (optionalCategory.isPresent()) {
				return new SimpleObjectProperty<>(optionalCategory.get().getName());
			}
			return new SimpleObjectProperty<>("");
		});
		
		tableViewDocument.setItems(filteredDocuments);
		
		tableFilter = TableFilter.forTableView(tableViewDocument).apply();
		tableFilter.setSearchStrategy((input, target) -> {
			try {
				return target.toLowerCase().contains(input.toLowerCase());
			} catch (Exception e) {
				return false;
			}
		});
	}
	
	protected void initTreeView(List<DocumentCategory> categories) {
		if (!categories.isEmpty()) {
			Optional<List<DocumentCategory>> optionalCategories = Optional.ofNullable(categories);
			optionalCategories.ifPresent(e -> {
				DocumentCategory root = buildTree(categories);
				rootItem = new TreeItem<>(root);
				root.getChildren().stream().forEach(c->buildTreeItems(rootItem, c));
			});
		}else {
//			LocalDateTime createdOn = LocalDateTime.now();
//			DocumentCategory root = new DocumentCategory("Root", createdOn, createdOn, -1);
//			long newId = JRegisPlatform.getInstance(CategoryRepository.class).save(root);
//			root.setId(newId);
//			rootItem = new TreeItem<>(root);
//			masterCategoryData.add(root);
		}
		treeView.setRoot(rootItem);
		treeView.setCellFactory(param -> new TreeCell<DocumentCategory>() {
			@Override
			protected void updateItem(DocumentCategory item, boolean empty) {
				super.updateItem(item, empty);
				if (item == null || empty) {
					setText(null);
				} else {
					setText(item.getName());
				}
			}
		});
		rootItem.setExpanded(true);
		treeView.setShowRoot(true);
		treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			comboBoxCategory.getSelectionModel().select(newValue.getValue());
			if (newValue.getValue().getName().equals("Root")) {
				filteredDocuments.setPredicate(p -> true);
			} else {
				filteredDocuments.setPredicate(p -> p.getCategoryId().equals(newValue.getValue().getId()));
			}
		});
	}
	
	protected DocumentCategory buildTree(List<DocumentCategory> models) {
		categoryRegistry.clear();
		Long firstElement = null;
		for (DocumentCategory model : models) {
			if (firstElement == null) {
				firstElement = model.getId();
			}
			categoryRegistry.put(model.getId(), model);
		}
		categoryRegistry.values().forEach(nav -> {
			Long parentId = nav.getId();
			List<DocumentCategory> filteredList = models.stream().filter(e -> e.getParentId() == parentId)
					.collect(Collectors.toList());
			filteredList.sort((DocumentCategory o1, DocumentCategory o2) -> o1.getName().compareTo(o2.getName()));
			nav.getChildren().addAll(filteredList);
		});

		return categoryRegistry.get(firstElement);
	}

	protected void buildTreeItems(TreeItem<DocumentCategory> parentItem, DocumentCategory element) {
		TreeItem<DocumentCategory> newItem = new TreeItem<>(element);
		parentItem.getChildren().add(newItem);
		if (!element.getChildren().isEmpty()) {
			List<DocumentCategory> children = element.getChildren();
			for (DocumentCategory category : children) {
				if (category != element) {
					buildTreeItems(newItem, category);
				}
			}
		}
	}

	public void closeNewDocumentPane() {
		if (vboxDocumentOverviewContent.getChildren().contains(paneAddNewDocument)) {
			vboxDocumentOverviewContent.getChildren().remove(paneAddNewDocument);
		}
	}

	public void openNewDocumentPane() {
		if (!vboxDocumentOverviewContent.getChildren().contains(paneAddNewDocument)) {
			vboxDocumentOverviewContent.getChildren().add(paneAddNewDocument);
		}
	}
	
	public static <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
	
}

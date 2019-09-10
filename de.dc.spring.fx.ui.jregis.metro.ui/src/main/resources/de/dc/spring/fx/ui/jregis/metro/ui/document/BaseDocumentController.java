package de.dc.spring.fx.ui.jregis.metro.ui.document;

import java.util.function.Function;

import org.apache.log4j.Logger;
import org.controlsfx.control.table.TableFilter;

import de.dc.spring.fx.ui.jregis.metro.ui.document.controller.DocumentDetails;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;

public abstract class BaseDocumentController extends AbstractFxmlDocumentController {

	protected Logger log = Logger.getLogger(getClass().getSimpleName());
	
	protected DocumentDetails documentDetails = new DocumentDetails();
	
	protected ObservableList<Document> documentData = FXCollections.observableArrayList();
	protected FilteredList<Document> filteredDocuments = new FilteredList<>(documentData, p -> true);
	
	protected TableFilter<Document> tableFilter;
	
	public void initialize() {
		AnchorPane.setTopAnchor(documentDetails, 0d);
		AnchorPane.setBottomAnchor(documentDetails, 0d);
		AnchorPane.setLeftAnchor(documentDetails, 0d);
		AnchorPane.setRightAnchor(documentDetails, 0d);
		root.getChildren().add(0, documentDetails);
		
		closeNewDocumentPane();
		
		initTableView();
	}

	private void initTableView() {
//		columnId.setCellValueFactory(e -> new SimpleObjectProperty<>(e.getValue()));
//		columnId.setCellFactory(e -> new ColumnJRegisIdFeature());
		setupCellValueFactory(columnName, e -> new SimpleObjectProperty<>(e.getName()));
		setupCellValueFactory(columnCreated, e -> new SimpleObjectProperty<>(e.getCreatedOn().toString()));
		setupCellValueFactory(columnUpdated, e -> new SimpleObjectProperty<>(e.getUpdatedOn().toString()));
//		columnCategory.setCellValueFactory(param -> {
//			long id = param.getValue().getCategoryId();
//			Optional<Category> category = JRegisPlatform.getInstance(CategoryRepository.class).findById(id);
//			if (category.isPresent()) {
//				return new SimpleObjectProperty<>(category.get().getName());
//			}
//			return new SimpleObjectProperty<>("");
//		});
		
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

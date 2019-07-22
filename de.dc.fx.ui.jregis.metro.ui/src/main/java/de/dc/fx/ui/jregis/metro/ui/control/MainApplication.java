package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.controlsfx.control.table.TableFilter;

import com.google.common.base.Function;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.Category;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.repository.CategoryRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentRepository;
import de.dc.fx.ui.jregis.metro.ui.util.DialogUtil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

public class MainApplication extends BaseMainApplication {

	private ObservableList<Document> masterDocumentData = FXCollections.observableArrayList();
	private FilteredList<Document> filteredDocumentData = new FilteredList<>(masterDocumentData, p -> true);

	private ObservableList<Category> masterCategoryData = FXCollections.observableArrayList();
	
	private DocumentDetails documentDetails = new DocumentDetails();
	
	public MainApplication() {
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource("/de/dc/fx/ui/jregis/metro/ui/MainApplication.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	public void initialize() {
		setupCellValueFactory(columnId, e -> new SimpleObjectProperty(e.getId()));
		setupCellValueFactory(columnName, e -> new SimpleObjectProperty(e.getName()));
		setupCellValueFactory(columnCreated, e -> new SimpleObjectProperty(e.getCreatedOn()));
		setupCellValueFactory(columnUpdated, e -> new SimpleObjectProperty(e.getUpdatedOn()));
		columnCategory.setCellValueFactory(param -> {
			return new SimpleObjectProperty<>(param.getValue().getCategoryId()+"");
		});		
		
		DocumentRepository documentRepository = JRegisPlatform.getInstance(DocumentRepository.class);
		List<Document> documents = documentRepository.findAll();
		masterDocumentData.addAll(documents);
		tableViewDocument.setItems(filteredDocumentData);

		CategoryRepository categoryRepository = JRegisPlatform.getInstance(CategoryRepository.class);
		List<Category> categories = categoryRepository.findAll();
		masterCategoryData.addAll(categories);
		comboBoxCategory.setItems(masterCategoryData);
		comboBoxCategory.setConverter(new StringConverter<Category>() {
			@Override
			public String toString(Category c) {
				return c.getName();
			}
			
			@Override
			public Category fromString(String name) {
				return new Category(-1, name, -1);
			}
		});
		
		TableFilter<Document> filter = new TableFilter<>(tableViewDocument);
		filter.setSearchStrategy((input,target) -> {
		    try {
		        return target.toLowerCase().contains(input.toLowerCase());
		    } catch (Exception e) {
		        return false;
		    }
		});
		
		mainStackPane.getChildren().add(documentDetails);
	}

	@Override
	protected void onButtonLoginAction(ActionEvent event) {
		textCreatedOn.setText(LocalDateTime.now().toString());
		paneDocumentTableView.toFront();
	}

	@Override
	protected void onLinkCreateNewUserAction(ActionEvent event) {
	}

	@Override
	protected void onLinkForgottenPasswordAction(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onMenuItemDeleteDocumentAction(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onMenuItemEditDocumentAction(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onMenuItemNewDocumentAction(ActionEvent event) {
		paneAddDocument.toFront();
	}

	@Override
	protected void onMenuItemOpenDocumentAction(ActionEvent event) {
		// TODO Auto-generated method stub

	}

	public static <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}

	@Override
	protected void onTableViewDocumentClicked(MouseEvent event) {
		if (event.getClickCount()==2) {
			Document selection = tableViewDocument.getSelectionModel().getSelectedItem();
			if (selection!=null) {
				documentDetails.toFront();
				documentDetails.setDocument(selection);
			}
		}
	}

	@Override
	protected void onButtonCancelAction(ActionEvent event) {
		paneAddDocument.toBack();
	}

	@Override
	protected void onButtonCreateAction(ActionEvent event) {
		Document document = new Document();
		document.setCategoryId(0);
		document.setName(textDocumentName.getText());
		document.setDescription(textDescription.getText());
		document.setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
		document.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
		
		Category category = comboBoxCategory.getSelectionModel().getSelectedItem();
		if (category!=null) {
			document.setCategoryId(category.getId());
		}else {
			category = new Category();
			category.setName(comboBoxCategory.getEditor().getText());
			long newId = JRegisPlatform.getInstance(CategoryRepository.class).save(category);
			document.setCategoryId(newId);
		}
		
		JRegisPlatform.getInstance(DocumentRepository.class).save(document);
		
		masterDocumentData.add(document);
		
		paneAddDocument.toBack();
	}

	@Override
	protected void onButtonAddCategoryAction(ActionEvent event) {
		DialogUtil.openInput("New Category", "Category*","Create new Category", "", e->{
			Category category = new Category();
			category.setName(e);
			category.setCreatedOn(LocalDateTime.now());
			category.setUpdatedOn(LocalDateTime.now());
			long newId = JRegisPlatform.getInstance(CategoryRepository.class).save(category);
			category.setId(newId);
			masterCategoryData.add(category);
		});
	}

	@Override
	protected void onButtonEditCategoryAction(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onButtonRemoveCategoryAction(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}

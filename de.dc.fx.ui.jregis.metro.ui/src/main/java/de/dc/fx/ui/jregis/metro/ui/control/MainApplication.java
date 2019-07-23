package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.table.TableFilter;

import com.google.common.base.Function;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.Category;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.repository.CategoryRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentRepository;
import de.dc.fx.ui.jregis.metro.ui.util.DialogUtil;
import impl.org.controlsfx.autocompletion.AutoCompletionTextFieldBinding;
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

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	
	private static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/MainApplication.fxml";

	private ObservableList<Document> masterDocumentData = FXCollections.observableArrayList();
	private FilteredList<Document> filteredDocumentData = new FilteredList<>(masterDocumentData, p -> true);
	
	private ObservableList<Category> masterCategoryData = FXCollections.observableArrayList();
	private DocumentDetails documentDetails = new DocumentDetails();
	
	private ObservableList<String> masterSuggestionData = FXCollections.observableArrayList();
	private FilteredList<String> filteredSuggestionData = new FilteredList<>(masterSuggestionData, p->true);
	
	public MainApplication() {
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml "+FXML, exception);
		}
	}

	public void initialize() {
		initTableView();
		initCategoryComboBox();
		initControls();
		initBindings();
		mainStackPane.getChildren().add(documentDetails);
		paneDocumentTableView.toFront();
	}

	private void initControls() {
		new AutoCompletionTextFieldBinding<>(textDocumentName, param -> {
			filteredSuggestionData.setPredicate(p->p.toLowerCase().contains(param.getUserText().toLowerCase()));
			return filteredSuggestionData;
		});
	}

	private void initCategoryComboBox() {
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
	}

	private void initTableView() {
		setupCellValueFactory(columnId, e -> new SimpleObjectProperty(e.getId()));
		setupCellValueFactory(columnName, e -> new SimpleObjectProperty(e.getName()));
		setupCellValueFactory(columnCreated, e -> new SimpleObjectProperty(e.getCreatedOn()));
		setupCellValueFactory(columnUpdated, e -> new SimpleObjectProperty(e.getUpdatedOn()));
		columnCategory.setCellValueFactory(param -> {
			long id = param.getValue().getCategoryId();
			Optional<Category> category = JRegisPlatform.getInstance(CategoryRepository.class).findById(id);
			if (category.isPresent()) {
				return new SimpleObjectProperty<>(category.get().getName());
			}
			return new SimpleObjectProperty<>("");
		});		
		
		DocumentRepository documentRepository = JRegisPlatform.getInstance(DocumentRepository.class);
		List<Document> documents = documentRepository.findAll();
		masterDocumentData.addAll(documents);
		tableViewDocument.setItems(filteredDocumentData);
		
		TableFilter.forTableView(tableViewDocument).apply().setSearchStrategy((input,target) -> {
		    try {
		        return target.toLowerCase().contains(input.toLowerCase());
		    } catch (Exception e) {
		        return false;
		    }
		});
	}

	private void initBindings() {
		buttonAddDocumentNameSuggestion.disableProperty().bind(textDocumentName.textProperty().isEmpty());
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
		textCreatedOn.setText(LocalDateTime.now().toString());
		comboBoxCategory.getSelectionModel().selectFirst();
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
		}
		
		long newDocumentId = JRegisPlatform.getInstance(DocumentRepository.class).save(document);
		document.setId(newDocumentId);
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
		Category selection = comboBoxCategory.getSelectionModel().getSelectedItem();
		if (selection != null) {
			DialogUtil.openInput("Edit Category", selection.getName(),"Edit Category", "", e->{
				selection.setName(e);
//				long newId = JRegisPlatform.getInstance(CategoryRepository.class).save(category);
				masterCategoryData.clear();
				masterCategoryData.addAll(JRegisPlatform.getInstance(CategoryRepository.class).findAll());
			});
		}
	}

	@Override
	protected void onButtonRemoveCategoryAction(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onButtonAddDocumentNameSuggestionAction(ActionEvent event) {
		String name = textDocumentName.getText();		
		
		
	}
}

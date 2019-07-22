package de.dc.fx.ui.jregis.metro.ui.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.controlsfx.control.table.TableFilter;

import com.google.common.base.Function;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.Category;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.repository.CategoryRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentRepository;
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
		setupCellValueFactory(columnCreated, e -> new SimpleObjectProperty(e.getTimestamp()));
		columnCategory.setCellValueFactory(param -> {
			String name = masterCategoryData.stream()
					.filter(p-> p.getId()==param.getValue().getCategoryId()).findAny()
					.get().getName();
			
			return new SimpleObjectProperty<>(name);
		});		
		
		DocumentRepository documentRepository = JRegisPlatform.getInstance(DocumentRepository.class);
		List<Document> documents = documentRepository.findAll();
		masterDocumentData.addAll(documents);
		tableViewDocument.setItems(filteredDocumentData);

		CategoryRepository categoryRepository = JRegisPlatform.getInstance(CategoryRepository.class);
		List<Category> categories = categoryRepository.findAll();
		masterCategoryData.addAll(categories);
		
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
		paneDocumentTableView.toFront();
	}

	@Override
	protected void onLinkCreateNewUserAction(ActionEvent event) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:h2:file:./data/reg_db;DB_CLOSE_ON_EXIT=true;", "SA", "SA");

			conn.createStatement().executeQuery("SELECT * FROM DOCUMENT");
			conn.close();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
}

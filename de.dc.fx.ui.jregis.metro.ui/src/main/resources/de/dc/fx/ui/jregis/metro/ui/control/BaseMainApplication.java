package de.dc.fx.ui.jregis.metro.ui.control;

import de.dc.fx.ui.jregis.metro.ui.model.Category;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public abstract class BaseMainApplication extends BorderPane{

	@FXML
	protected TextField textSearch;
	
	@FXML
	protected HBox vboxDocumentOverviewContent;
	
	@FXML
	protected Label labelEntriesSize;
	
    @FXML
    protected TableColumn<Document, String> columnId;

    @FXML
    protected TableColumn<Document, String> columnName;

    @FXML
    protected TableColumn<Document, String> columnCreated;

    @FXML
    protected TableColumn<Document, String> columnCategory;

    @FXML
    protected TableColumn<Document, String> columnUpdated;
	
	@FXML
	protected BorderPane root;
	
	@FXML
	protected TableView<Document> tableViewDocument;
	
    @FXML
    protected StackPane mainStackPane;

    @FXML
    protected AnchorPane paneDocumentTableView;

    @FXML
    protected BorderPane main;

    @FXML
    protected AnchorPane paneAddNewDocument;
    
    @FXML
    protected BorderPane paneOverview;

    @FXML
    protected BorderPane paneLogin;

    @FXML
    protected TextField textUsername;

    @FXML
    protected ImageView imageViewUser;

    @FXML
    protected Button buttonLogin;

    @FXML
    protected PasswordField textPassword;

    @FXML
    protected TextField textDocumentId;

    @FXML
    protected TextField textDocumentName;

    @FXML
    protected TextField textUrl;

    @FXML
    protected ComboBox<Category> comboBoxCategory;

    @FXML
    protected TextField textCreatedOn;

    @FXML
    protected TextArea textDescription;
    
    @FXML
    protected Button buttonAddDocumentNameSuggestion;
    
    @FXML
    protected Button buttonCreateDocument;

    @FXML
    protected abstract void onButtonCancelAction(ActionEvent event);

    @FXML
    protected abstract void onButtonCreateAction(ActionEvent event);
    
    @FXML
    protected abstract void onButtonLoginAction(ActionEvent event);

    @FXML
    protected abstract void onLinkCreateNewUserAction(ActionEvent event);

    @FXML
    protected abstract void onLinkForgottenPasswordAction(ActionEvent event);

    @FXML
    protected abstract void onMenuItemDeleteDocumentAction(ActionEvent event);

    @FXML
    protected abstract void onMenuItemEditDocumentAction(ActionEvent event);

    @FXML
    protected abstract void onMenuItemNewDocumentAction(ActionEvent event);

    @FXML
    protected abstract void onMenuItemOpenDocumentAction(ActionEvent event);

    @FXML
    protected abstract void onTableViewDocumentClicked(MouseEvent event);

    @FXML
    protected abstract void onMenuItemShowAllAction(MouseEvent event);
    
    @FXML
    protected abstract void onButtonAddCategoryAction(ActionEvent event);

    @FXML
    protected abstract void onButtonEditCategoryAction(ActionEvent event);

    @FXML
    protected abstract void onButtonRemoveCategoryAction(ActionEvent event);

    @FXML
    protected abstract void onButtonAddDocumentNameSuggestionAction(ActionEvent event);

    @FXML
    protected abstract void onNavigationPreferencesClicked(MouseEvent event);

    @FXML
    protected abstract void onNavigationDocumentClicked(MouseEvent event);
}

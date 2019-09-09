package de.dc.spring.fx.ui.jregis.metro.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public abstract class BaseJRegisMainPane extends BorderPane{

    @FXML
    protected MenuItem menuItemTreeNew;

    @FXML
    protected MenuItem menuItemTreeEdit;

    @FXML
    protected MenuItem menuItemTreeDelete;
	
	@FXML
	protected ImageView imageViewAdbook;
	
	@FXML
	protected TreeView<?> treeView;
	
	@FXML
	protected HBox panelUser;
	
	@FXML
	protected ImageView imageViewPreferences;

	@FXML
	protected ImageView imageViewNotification;
	
	@FXML
	protected TextField textSearch;
	
	@FXML
	protected HBox vboxDocumentOverviewContent;
	
	@FXML
	protected Label labelEntriesSize;
	
    @FXML
    protected TableColumn<?, ?> columnId;

    @FXML
    protected TableColumn<?, String> columnName;

    @FXML
    protected TableColumn<?, String> columnCreated;

    @FXML
    protected TableColumn<?, String> columnCategory;

    @FXML
    protected TableColumn<?, String> columnUpdated;
	
	@FXML
	protected BorderPane root;
	
	@FXML
	protected TableView<?> tableViewDocument;
	
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
    protected ComboBox<?> comboBoxCategory;

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
    protected abstract void onMenuItemShowAllAction(ActionEvent event);
    
    @FXML
    protected abstract void onButtonAddCategoryAction(ActionEvent event);

    @FXML
    protected abstract void onButtonEditCategoryAction(ActionEvent event);

    @FXML
    protected abstract void onButtonRemoveCategoryAction(ActionEvent event);

    @FXML
    protected abstract void onButtonAddDocumentNameSuggestionAction(ActionEvent event);

    @FXML
    protected abstract void onImageViewNotificationClicked(MouseEvent event);
    
    @FXML
    protected abstract void onImageViewPreferencesClicked(MouseEvent event);

    @FXML
    protected abstract void onHBoxUserClicked(MouseEvent event);

    @FXML
    protected abstract void onNavigationItemClicked(MouseEvent event);

    @FXML
    protected abstract void onImageViewAdbookClicked(MouseEvent event);
    
    @FXML
    protected abstract void onImageViewCalendarClicked(MouseEvent event);
    
    @FXML
    protected abstract void onTreeContextMenuAction(ActionEvent event);
}

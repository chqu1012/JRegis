package de.dc.spring.fx.ui.jregis.metro.ui.document;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public abstract class BaseFxmlDocumentController {

    @FXML
    protected AnchorPane paneDocumentTableView;

    @FXML
    protected HBox vboxDocumentOverviewContent;

    @FXML
    protected TreeView<?> treeView;

    @FXML
    protected MenuItem menuItemTreeNew;

    @FXML
    protected MenuItem menuItemTreeEdit;

    @FXML
    protected MenuItem menuItemTreeDelete;

    @FXML
    protected TableView<?> tableViewDocument;

    @FXML
    protected TableColumn<?, ?> columnId;

    @FXML
    protected TableColumn<?, ?> columnName;

    @FXML
    protected TableColumn<?, ?> columnCategory;

    @FXML
    protected TableColumn<?, ?> columnCreated;

    @FXML
    protected TableColumn<?, ?> columnUpdated;

    @FXML
    protected MenuItem tableMenuItemOpenDirectory;

    @FXML
    protected MenuItem tableMenuItemNew;

    @FXML
    protected MenuItem tableMenuItemEdit;

    @FXML
    protected MenuItem tableMenuItemDelete;

    @FXML
    protected MenuItem tableMenuItemShowAll;

    @FXML
    protected TextField textSearch;

    @FXML
    protected Label labelEntriesSize;

    @FXML
    protected AnchorPane paneAddNewDocument;

    @FXML
    protected TextField textDocumentName;

    @FXML
    protected TextField textUrl;

    @FXML
    protected ComboBox<?> comboBoxCategory;

    @FXML
    protected Button buttonCategoryAdd;

    @FXML
    protected Button buttonCategoryEdit;

    @FXML
    protected Button buttonCategoryRemove;

    @FXML
    protected TextArea textDescription;

    @FXML
    protected Button buttonCreateDocument;

    @FXML
    protected Hyperlink linkCancelDocument;

    @FXML
    protected Button buttonAddDocumentNameSuggestion;

    @FXML
    protected abstract void onButtonAction(ActionEvent event);

    @FXML
    protected abstract void onTableMenuItemAction(ActionEvent event);

    @FXML
    protected abstract void onTableViewDocumentClicked(MouseEvent event);

    @FXML
    protected abstract void onTreeContextMenuAction(ActionEvent event);

}

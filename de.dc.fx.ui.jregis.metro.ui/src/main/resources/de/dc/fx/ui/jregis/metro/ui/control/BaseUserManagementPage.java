package de.dc.fx.ui.jregis.metro.ui.control;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public abstract class BaseUserManagementPage extends AnchorPane{

    @FXML
    protected AnchorPane paneTableView;

    @FXML
    protected TableView<?> tableView;

    @FXML
    protected TableColumn<?, ?> columnId;

    @FXML
    protected TableColumn<?, ?> columnName;

    @FXML
    protected TableColumn<?, ?> columnCreated;

    @FXML
    protected TableColumn<?, ?> columnRole;

    @FXML
    protected TableColumn<?, ?> columnStatus;

    @FXML
    protected TableColumn<?, ?> columnAction;

    @FXML
    protected ComboBox<?> comboBoxStatus;

    @FXML
    protected TextField textSearch;

}

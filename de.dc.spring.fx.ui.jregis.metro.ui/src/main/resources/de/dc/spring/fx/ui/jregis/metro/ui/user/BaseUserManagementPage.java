package de.dc.spring.fx.ui.jregis.metro.ui.user;
import de.dc.spring.fx.ui.jregis.metro.ui.user.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public abstract class BaseUserManagementPage extends AnchorPane {

	@FXML
	protected AnchorPane addUserDialog;
	
	@FXML
	protected AnchorPane paneTableView;

	@FXML
	protected TableView<User> tableView;

	@FXML
	protected TableColumn<User, String> columnId;

	@FXML
	protected TableColumn<User, User> columnName;

	@FXML
	protected TableColumn<User, String> columnCreated;

	@FXML
	protected TableColumn<User, String> columnRole;

	@FXML
	protected TableColumn<User, String> columnStatus;

	@FXML
	protected TableColumn<User, String> columnAction;

	@FXML
	protected ComboBox<?> comboBoxStatus;

	@FXML
	protected TextField textSearch;

	@FXML
	protected TextField textFirstname;

	@FXML
	protected TextField textLastname;

	@FXML
	protected TextField textMobile;

	@FXML
	protected TextField textAddress;

	@FXML
	protected TextField textCity;

	@FXML
	protected TextField textState;

	@FXML
	protected TextField textCountry;

	@FXML
	protected TextField textEmail;

	@FXML
	protected TextField textUsername;

	@FXML
	protected CheckBox checkBoxCondition;

	@FXML
	protected Button buttonCreateUser;

	@FXML
	protected TextField textPassword;

	@FXML
	protected TextField textBirthday;

	@FXML
	protected abstract void onButtonCreateUser(ActionEvent event);

	@FXML
	protected abstract void onButtonOpenAddDIalog(ActionEvent event);

	@FXML
	protected abstract void onLinkCancelCreateUser(ActionEvent event);

}

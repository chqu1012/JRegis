package de.dc.fx.ui.jregis.metro.ui.control.user.management;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.Notifications;

import com.google.common.base.Function;
import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.control.binding.UserContext;
import de.dc.fx.ui.jregis.metro.ui.control.document.management.AttachmentControl;
import de.dc.fx.ui.jregis.metro.ui.control.features.ColumnUsername;
import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.model.User;
import de.dc.fx.ui.jregis.metro.ui.repository.UserRepository;
import de.dc.fx.ui.jregis.metro.ui.service.UserService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserManagementPage extends BaseUserManagementPage {

	private Logger log = Logger.getLogger(AttachmentControl.class.getSimpleName());
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/UserManagement.fxml";

	private ObservableList<User> masterData = FXCollections.observableArrayList();
	private FilteredList<User> filteredMasterData = new FilteredList<>(masterData, p->true);
	
	private UserContext context = new UserContext();
	
	@Inject
	public UserManagementPage(UserService userService) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml "+FXML, exception);
		}
		
		textUsername.textProperty().bindBidirectional(context.username);
		textPassword.textProperty().bindBidirectional(context.password);
		textFirstname.textProperty().bindBidirectional(context.firstname);
		textLastname.textProperty().bindBidirectional(context.lastname);
		textEmail.textProperty().bindBidirectional(context.email);
		textAddress.textProperty().bindBidirectional(context.address);
		textCity.textProperty().bindBidirectional(context.city);
		textState.textProperty().bindBidirectional(context.state);
		textCountry.textProperty().bindBidirectional(context.country);
		textMobile.textProperty().bindBidirectional(context.mobile);
		
		context.username.setValue("jim.west");
		context.password.setValue("jimmy.weston!#");
		context.firstname.setValue("Jim");
		context.lastname.setValue("West");
		context.email.setValue("jim.west@mail.com");
		context.address.setValue("Donaustraße 11");
		context.city.setValue("Stuttgart");
		context.state.setValue("Baden Württemberg");
		context.country.setValue("Deutschland");
		context.mobile.setValue("0178 22 33 44 55");
		
		setupCellValueFactory(columnCreated, e-> new SimpleObjectProperty<>(e.getCreatedOnAsString()));
		setupCellValueFactory(columnId, e-> new SimpleObjectProperty<>(String.valueOf(e.getId())));
		columnName.setCellValueFactory(param -> new SimpleObjectProperty<User>(param.getValue()));
		columnName.setCellFactory(e-> new ColumnUsername());
		setupCellValueFactory(columnRole, e-> new SimpleObjectProperty<>(String.valueOf(e.getRoleId())));
		setupCellValueFactory(columnStatus, e-> new SimpleObjectProperty<>(String.valueOf(e.getStatus())));
		tableView.setItems(filteredMasterData);
		
		masterData.addAll(userService.findAll());
	}

	public static <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
	
	@Override
	protected void onButtonCreateUser(ActionEvent event) {
		User user = JRegisPlatform.getInstance(UserService.class).create(context);
		
		masterData.add(user);
		Notifications.create().darkStyle().title("New User created!").text("Create new user "+context.username.getValue()).show();
		
		addUserDialog.setVisible(false);
		addUserDialog.toBack();
	}

	@Override
	protected void onButtonOpenAddDIalog(ActionEvent event) {
		addUserDialog.setVisible(true);
		addUserDialog.toFront();
	}

	@Override
	protected void onLinkCancelCreateUser(ActionEvent event) {
		addUserDialog.setVisible(false);
		addUserDialog.toBack();
	}
}

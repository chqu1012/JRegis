package de.dc.spring.fx.ui.jregis.metro.ui.user;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.base.Function;

import de.dc.spring.fx.ui.jregis.metro.ui.user.factory.ColumnUsername;
import de.dc.spring.fx.ui.jregis.metro.ui.user.model.User;
import de.dc.spring.fx.ui.jregis.metro.ui.user.model.UserContext;
import de.dc.spring.fx.ui.jregis.metro.ui.user.repository.UserRepository;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;

@Controller
public class UserManagementPage extends BaseUserManagementPage {

	private Logger log = Logger.getLogger(getClass().getSimpleName());
	
	public static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/user/UserManagement.fxml";

	private ObservableList<User> masterData = FXCollections.observableArrayList();
	private FilteredList<User> filteredMasterData = new FilteredList<>(masterData, p->true);
	
	private UserContext context = new UserContext();
	
	@Autowired UserRepository userRepository;
	
	public UserManagementPage() {
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
		
		setupCellValueFactory(columnCreated, e-> new SimpleObjectProperty<>(e.getCreatedOn().toString()));
		setupCellValueFactory(columnId, e-> new SimpleObjectProperty<>(String.valueOf(e.getId())));
		columnName.setCellValueFactory(param -> new SimpleObjectProperty<User>(param.getValue()));
		columnName.setCellFactory(e-> new ColumnUsername());
		setupCellValueFactory(columnRole, e-> new SimpleObjectProperty<>(String.valueOf(e.getRoleId())));
		setupCellValueFactory(columnStatus, e-> new SimpleObjectProperty<>(String.valueOf(e.getStatus())));
		tableView.setItems(filteredMasterData);
	}

	public void initialize() {
		masterData.addAll(userRepository.findAll());
	}
	
	public static <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
	
	@Override
	protected void onButtonCreateUser(ActionEvent event) {
//		User user = JRegisPlatform.getInstance(UserService.class).create(context);
		// TODO: Replaced by real implementaton
		LocalDateTime updatedOn = null;
		LocalDateTime createdOn= null;
		String name= null;
		Long roleId= null;
		LocalDateTime birthday= null;
		String mobile= null;
		String country= null;
		String state= null;
		String city= null;
		String address= null;
		String email= null;
		String lastname= null;
		String firstname= null;
		String password= null;
		String username= null;
		User user = new User(username, password, firstname, lastname, email, address, city, state, country, mobile, birthday, roleId, name, createdOn, updatedOn);
		userRepository.save(user);
		
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

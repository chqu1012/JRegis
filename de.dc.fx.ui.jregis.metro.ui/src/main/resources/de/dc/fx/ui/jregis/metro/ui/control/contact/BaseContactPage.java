package de.dc.fx.ui.jregis.metro.ui.control.contact;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public abstract class BaseContactPage extends SplitPane{

	@FXML
	protected Label labelAllContactsName;
	
	@FXML
	protected Label labelDeletedContactName;
	
	@FXML
	protected ImageView imageViewDeleteContacts;
	
	@FXML
	protected Label labelDeletedContactSize;
	
	@FXML
	protected Label labelContactsSize;
	
	@FXML
	protected VBox panePreview;
	
	@FXML
	protected ImageView imageViewAddAddress;
	
	@FXML
	protected ImageView imageViewAddDates;

	@FXML
	protected ImageView imageViewAddPhonenumbers;

	@FXML
	protected ImageView imageViewAddEmail;
	
	@FXML
	protected Separator separatorDates;

	@FXML
	protected Separator separatorEmail;

	@FXML
	protected Separator separatorAddress;
	
	@FXML
	protected ListView<Contact> listViewContacts;
	
    @FXML
    protected TreeView<?> treeViewEmail;

    @FXML
    protected VBox vboxContactList;

    @FXML
    protected ComboBox<?> comboInboxType;

    @FXML
    protected TextField textSearchContact;

    @FXML
    protected ImageView imageViewUser;

    @FXML
    protected Label labelName;

    @FXML
    protected Label labelNickname;

    @FXML
    protected VBox vboxEmail;

    @FXML
    protected VBox vboxPhoneNumbers;

    @FXML
    protected VBox vboxDates;

    @FXML
    protected VBox vboxAddresses;

    @FXML
    protected abstract void onImageViewNewUser(MouseEvent event);

    @FXML
    protected abstract void onImageViewPreferences(MouseEvent event);

    @FXML
    protected abstract void onImageViewAddClicked(MouseEvent event);

    @FXML
    protected abstract void onImageViewUserClicked(MouseEvent event);

    @FXML
    protected abstract void onMenuItemDeleteContact(ActionEvent event);

    @FXML
    protected abstract void onButtonClicked(MouseEvent event);

}

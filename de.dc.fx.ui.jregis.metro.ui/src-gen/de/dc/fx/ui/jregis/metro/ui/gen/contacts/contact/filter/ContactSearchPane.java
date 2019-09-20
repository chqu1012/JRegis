package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.filter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class ContactSearchPane extends VBox{

    @FXML
    protected VBox paneContent;

    @FXML
    protected Button buttonAccept;

    @FXML
    protected Hyperlink linkCancel;

    @FXML
    protected VBox root;
    @FXML
    protected HBox hboxFirstname;

    @FXML
    protected CheckBox checkboxFirstname;

    @FXML
    protected ComboBox<ContactSearchType> comboboxFirstname;

    @FXML
    protected TextField textFirstname;
    @FXML
    protected HBox hboxLastname;

    @FXML
    protected CheckBox checkboxLastname;

    @FXML
    protected ComboBox<ContactSearchType> comboboxLastname;

    @FXML
    protected TextField textLastname;
    @FXML
    protected HBox hboxUsername;

    @FXML
    protected CheckBox checkboxUsername;

    @FXML
    protected ComboBox<ContactSearchType> comboboxUsername;

    @FXML
    protected TextField textUsername;
    @FXML
    protected HBox hboxContactImageId;

    @FXML
    protected CheckBox checkboxContactImageId;

    @FXML
    protected ComboBox<ContactSearchType> comboboxContactImageId;

    @FXML
    protected TextField textContactImageId;
    @FXML
    protected HBox hboxContactGroupId;

    @FXML
    protected CheckBox checkboxContactGroupId;

    @FXML
    protected ComboBox<ContactSearchType> comboboxContactGroupId;

    @FXML
    protected TextField textContactGroupId;
    @FXML
    protected HBox hboxStatus;

    @FXML
    protected CheckBox checkboxStatus;

    @FXML
    protected ComboBox<ContactSearchType> comboboxStatus;

    @FXML
    protected TextField textStatus;
    @FXML
    protected HBox hboxCreatedOn;

    @FXML
    protected CheckBox checkboxCreatedOn;

    @FXML
    protected ComboBox<ContactSearchType> comboboxCreatedOn;

    @FXML
    protected TextField textCreatedOn;
    @FXML
    protected HBox hboxUpdatedOn;

    @FXML
    protected CheckBox checkboxUpdatedOn;

    @FXML
    protected ComboBox<ContactSearchType> comboboxUpdatedOn;

    @FXML
    protected TextField textUpdatedOn;
    @FXML
    protected HBox hboxEmails;

    @FXML
    protected CheckBox checkboxEmails;

    @FXML
    protected ComboBox<ContactSearchType> comboboxEmails;

    @FXML
    protected TextField textEmails;
    @FXML
    protected HBox hboxAddressList;

    @FXML
    protected CheckBox checkboxAddressList;

    @FXML
    protected ComboBox<ContactSearchType> comboboxAddressList;

    @FXML
    protected TextField textAddressList;
    @FXML
    protected HBox hboxPhoneList;

    @FXML
    protected CheckBox checkboxPhoneList;

    @FXML
    protected ComboBox<ContactSearchType> comboboxPhoneList;

    @FXML
    protected TextField textPhoneList;
    @FXML
    protected HBox hboxDateList;

    @FXML
    protected CheckBox checkboxDateList;

    @FXML
    protected ComboBox<ContactSearchType> comboboxDateList;

    @FXML
    protected TextField textDateList;
    
    private ObservableList<ContactSearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/gen/contacts/contact/filter/ContactSearchPane.fxml";

	public ContactSearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
		fxmlLoader.load();
		} catch (IOException exception) {
		exception.printStackTrace();
		}
		hboxFirstname.disableProperty().bind(checkboxFirstname.selectedProperty().not());
		comboboxFirstname.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
		hboxLastname.disableProperty().bind(checkboxLastname.selectedProperty().not());
		comboboxLastname.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
		hboxUsername.disableProperty().bind(checkboxUsername.selectedProperty().not());
		comboboxUsername.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
		hboxContactImageId.disableProperty().bind(checkboxContactImageId.selectedProperty().not());
		comboboxContactImageId.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
		hboxContactGroupId.disableProperty().bind(checkboxContactGroupId.selectedProperty().not());
		comboboxContactGroupId.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
		hboxStatus.disableProperty().bind(checkboxStatus.selectedProperty().not());
		comboboxStatus.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
		hboxCreatedOn.disableProperty().bind(checkboxCreatedOn.selectedProperty().not());
		comboboxCreatedOn.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
		hboxUpdatedOn.disableProperty().bind(checkboxUpdatedOn.selectedProperty().not());
		comboboxUpdatedOn.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
		hboxEmails.disableProperty().bind(checkboxEmails.selectedProperty().not());
		comboboxEmails.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
		hboxAddressList.disableProperty().bind(checkboxAddressList.selectedProperty().not());
		comboboxAddressList.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
		hboxPhoneList.disableProperty().bind(checkboxPhoneList.selectedProperty().not());
		comboboxPhoneList.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
		hboxDateList.disableProperty().bind(checkboxDateList.selectedProperty().not());
		comboboxDateList.setItems(FXCollections.observableArrayList(ContactSearchType.values()));
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxFirstname.isSelected()){
				String value = textFirstname.getText();
				String name = checkboxFirstname.getText();
				ContactSearchType type = comboboxFirstname.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			if(checkboxLastname.isSelected()){
				String value = textLastname.getText();
				String name = checkboxLastname.getText();
				ContactSearchType type = comboboxLastname.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			if(checkboxUsername.isSelected()){
				String value = textUsername.getText();
				String name = checkboxUsername.getText();
				ContactSearchType type = comboboxUsername.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			if(checkboxContactImageId.isSelected()){
				String value = textContactImageId.getText();
				String name = checkboxContactImageId.getText();
				ContactSearchType type = comboboxContactImageId.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			if(checkboxContactGroupId.isSelected()){
				String value = textContactGroupId.getText();
				String name = checkboxContactGroupId.getText();
				ContactSearchType type = comboboxContactGroupId.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			if(checkboxStatus.isSelected()){
				String value = textStatus.getText();
				String name = checkboxStatus.getText();
				ContactSearchType type = comboboxStatus.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			if(checkboxCreatedOn.isSelected()){
				String value = textCreatedOn.getText();
				String name = checkboxCreatedOn.getText();
				ContactSearchType type = comboboxCreatedOn.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			if(checkboxUpdatedOn.isSelected()){
				String value = textUpdatedOn.getText();
				String name = checkboxUpdatedOn.getText();
				ContactSearchType type = comboboxUpdatedOn.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			if(checkboxEmails.isSelected()){
				String value = textEmails.getText();
				String name = checkboxEmails.getText();
				ContactSearchType type = comboboxEmails.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			if(checkboxAddressList.isSelected()){
				String value = textAddressList.getText();
				String name = checkboxAddressList.getText();
				ContactSearchType type = comboboxAddressList.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			if(checkboxPhoneList.isSelected()){
				String value = textPhoneList.getText();
				String name = checkboxPhoneList.getText();
				ContactSearchType type = comboboxPhoneList.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			if(checkboxDateList.isSelected()){
				String value = textDateList.getText();
				String name = checkboxDateList.getText();
				ContactSearchType type = comboboxDateList.getSelectionModel().getSelectedItem();
				content.add(new ContactSearchContent(name, value, type));
			}
			content.stream().forEach(System.out::println);
		}
    	root.toBack();
    }
}

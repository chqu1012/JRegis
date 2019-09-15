package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.filter;

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
import java.util.Optional;

public class ContactAddressSearchPane extends VBox{

    @FXML
    protected VBox paneContent;

    @FXML
    protected Button buttonAccept;

    @FXML
    protected Hyperlink linkCancel;

    @FXML
    protected VBox root;
    @FXML
    protected HBox hboxContactId;

    @FXML
    protected CheckBox checkboxContactId;

    @FXML
    protected ComboBox<ContactAddressSearchType> comboboxContactId;

    @FXML
    protected TextField textContactId;
    @FXML
    protected HBox hboxAddressType;

    @FXML
    protected CheckBox checkboxAddressType;

    @FXML
    protected ComboBox<ContactAddressSearchType> comboboxAddressType;

    @FXML
    protected TextField textAddressType;
    @FXML
    protected HBox hboxStreet;

    @FXML
    protected CheckBox checkboxStreet;

    @FXML
    protected ComboBox<ContactAddressSearchType> comboboxStreet;

    @FXML
    protected TextField textStreet;
    @FXML
    protected HBox hboxCountry;

    @FXML
    protected CheckBox checkboxCountry;

    @FXML
    protected ComboBox<ContactAddressSearchType> comboboxCountry;

    @FXML
    protected TextField textCountry;
    @FXML
    protected HBox hboxState;

    @FXML
    protected CheckBox checkboxState;

    @FXML
    protected ComboBox<ContactAddressSearchType> comboboxState;

    @FXML
    protected TextField textState;
    @FXML
    protected HBox hboxZipCode;

    @FXML
    protected CheckBox checkboxZipCode;

    @FXML
    protected ComboBox<ContactAddressSearchType> comboboxZipCode;

    @FXML
    protected TextField textZipCode;
    @FXML
    protected HBox hboxStatus;

    @FXML
    protected CheckBox checkboxStatus;

    @FXML
    protected ComboBox<ContactAddressSearchType> comboboxStatus;

    @FXML
    protected TextField textStatus;
    @FXML
    protected HBox hboxCreatedOn;

    @FXML
    protected CheckBox checkboxCreatedOn;

    @FXML
    protected ComboBox<ContactAddressSearchType> comboboxCreatedOn;

    @FXML
    protected TextField textCreatedOn;
    @FXML
    protected HBox hboxUpdatedOn;

    @FXML
    protected CheckBox checkboxUpdatedOn;

    @FXML
    protected ComboBox<ContactAddressSearchType> comboboxUpdatedOn;

    @FXML
    protected TextField textUpdatedOn;
    
    private ObservableList<ContactAddressSearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/gen/contacts/address/filter/ContactAddressSearchPane.fxml";

	public ContactAddressSearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		hboxContactId.disableProperty().bind(checkboxContactId.selectedProperty().not());
		comboboxContactId.setItems(FXCollections.observableArrayList(ContactAddressSearchType.values()));
		comboboxContactId.getSelectionModel().selectFirst();
		hboxAddressType.disableProperty().bind(checkboxAddressType.selectedProperty().not());
		comboboxAddressType.setItems(FXCollections.observableArrayList(ContactAddressSearchType.values()));
		comboboxAddressType.getSelectionModel().selectFirst();
		hboxStreet.disableProperty().bind(checkboxStreet.selectedProperty().not());
		comboboxStreet.setItems(FXCollections.observableArrayList(ContactAddressSearchType.values()));
		comboboxStreet.getSelectionModel().selectFirst();
		hboxCountry.disableProperty().bind(checkboxCountry.selectedProperty().not());
		comboboxCountry.setItems(FXCollections.observableArrayList(ContactAddressSearchType.values()));
		comboboxCountry.getSelectionModel().selectFirst();
		hboxState.disableProperty().bind(checkboxState.selectedProperty().not());
		comboboxState.setItems(FXCollections.observableArrayList(ContactAddressSearchType.values()));
		comboboxState.getSelectionModel().selectFirst();
		hboxZipCode.disableProperty().bind(checkboxZipCode.selectedProperty().not());
		comboboxZipCode.setItems(FXCollections.observableArrayList(ContactAddressSearchType.values()));
		comboboxZipCode.getSelectionModel().selectFirst();
		hboxStatus.disableProperty().bind(checkboxStatus.selectedProperty().not());
		comboboxStatus.setItems(FXCollections.observableArrayList(ContactAddressSearchType.values()));
		comboboxStatus.getSelectionModel().selectFirst();
		hboxCreatedOn.disableProperty().bind(checkboxCreatedOn.selectedProperty().not());
		comboboxCreatedOn.setItems(FXCollections.observableArrayList(ContactAddressSearchType.values()));
		comboboxCreatedOn.getSelectionModel().selectFirst();
		hboxUpdatedOn.disableProperty().bind(checkboxUpdatedOn.selectedProperty().not());
		comboboxUpdatedOn.setItems(FXCollections.observableArrayList(ContactAddressSearchType.values()));
		comboboxUpdatedOn.getSelectionModel().selectFirst();
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxContactId.isSelected()){
				String value = textContactId.getText();
				String name = checkboxContactId.getText();
				ContactAddressSearchType type = comboboxContactId.getSelectionModel().getSelectedItem();
				content.add(new ContactAddressSearchContent(name, value, type));
			}
			if(checkboxAddressType.isSelected()){
				String value = textAddressType.getText();
				String name = checkboxAddressType.getText();
				ContactAddressSearchType type = comboboxAddressType.getSelectionModel().getSelectedItem();
				content.add(new ContactAddressSearchContent(name, value, type));
			}
			if(checkboxStreet.isSelected()){
				String value = textStreet.getText();
				String name = checkboxStreet.getText();
				ContactAddressSearchType type = comboboxStreet.getSelectionModel().getSelectedItem();
				content.add(new ContactAddressSearchContent(name, value, type));
			}
			if(checkboxCountry.isSelected()){
				String value = textCountry.getText();
				String name = checkboxCountry.getText();
				ContactAddressSearchType type = comboboxCountry.getSelectionModel().getSelectedItem();
				content.add(new ContactAddressSearchContent(name, value, type));
			}
			if(checkboxState.isSelected()){
				String value = textState.getText();
				String name = checkboxState.getText();
				ContactAddressSearchType type = comboboxState.getSelectionModel().getSelectedItem();
				content.add(new ContactAddressSearchContent(name, value, type));
			}
			if(checkboxZipCode.isSelected()){
				String value = textZipCode.getText();
				String name = checkboxZipCode.getText();
				ContactAddressSearchType type = comboboxZipCode.getSelectionModel().getSelectedItem();
				content.add(new ContactAddressSearchContent(name, value, type));
			}
			if(checkboxStatus.isSelected()){
				String value = textStatus.getText();
				String name = checkboxStatus.getText();
				ContactAddressSearchType type = comboboxStatus.getSelectionModel().getSelectedItem();
				content.add(new ContactAddressSearchContent(name, value, type));
			}
			if(checkboxCreatedOn.isSelected()){
				String value = textCreatedOn.getText();
				String name = checkboxCreatedOn.getText();
				ContactAddressSearchType type = comboboxCreatedOn.getSelectionModel().getSelectedItem();
				content.add(new ContactAddressSearchContent(name, value, type));
			}
			if(checkboxUpdatedOn.isSelected()){
				String value = textUpdatedOn.getText();
				String name = checkboxUpdatedOn.getText();
				ContactAddressSearchType type = comboboxUpdatedOn.getSelectionModel().getSelectedItem();
				content.add(new ContactAddressSearchContent(name, value, type));
			}
			
			String select = "SELECT * FROM CONTACT WHERE ";
			Optional<String> result = content.stream().map(e-> e.getName()+" = '"+e.getValue()+"'").reduce((e1,e2) -> e1 +" OR "+e2);
			result.ifPresent(e-> System.out.println(select+e));
		}
    	root.toBack();
    }
}

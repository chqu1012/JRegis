package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.filter;

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

public class AddressSearchPane extends VBox{

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
    protected ComboBox<AddressSearchType> comboboxContactId;

    @FXML
    protected TextField textContactId;
    @FXML
    protected HBox hboxAddressType;

    @FXML
    protected CheckBox checkboxAddressType;

    @FXML
    protected ComboBox<AddressSearchType> comboboxAddressType;

    @FXML
    protected TextField textAddressType;
    @FXML
    protected HBox hboxStreet;

    @FXML
    protected CheckBox checkboxStreet;

    @FXML
    protected ComboBox<AddressSearchType> comboboxStreet;

    @FXML
    protected TextField textStreet;
    @FXML
    protected HBox hboxCountry;

    @FXML
    protected CheckBox checkboxCountry;

    @FXML
    protected ComboBox<AddressSearchType> comboboxCountry;

    @FXML
    protected TextField textCountry;
    @FXML
    protected HBox hboxState;

    @FXML
    protected CheckBox checkboxState;

    @FXML
    protected ComboBox<AddressSearchType> comboboxState;

    @FXML
    protected TextField textState;
    @FXML
    protected HBox hboxZipCode;

    @FXML
    protected CheckBox checkboxZipCode;

    @FXML
    protected ComboBox<AddressSearchType> comboboxZipCode;

    @FXML
    protected TextField textZipCode;
    @FXML
    protected HBox hboxStatus;

    @FXML
    protected CheckBox checkboxStatus;

    @FXML
    protected ComboBox<AddressSearchType> comboboxStatus;

    @FXML
    protected TextField textStatus;
    @FXML
    protected HBox hboxCreatedOn;

    @FXML
    protected CheckBox checkboxCreatedOn;

    @FXML
    protected ComboBox<AddressSearchType> comboboxCreatedOn;

    @FXML
    protected TextField textCreatedOn;
    @FXML
    protected HBox hboxUpdatedOn;

    @FXML
    protected CheckBox checkboxUpdatedOn;

    @FXML
    protected ComboBox<AddressSearchType> comboboxUpdatedOn;

    @FXML
    protected TextField textUpdatedOn;
    
    private ObservableList<AddressSearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/gen/contacts/address/filter/AddressSearchPane.fxml";

	public AddressSearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		hboxContactId.disableProperty().bind(checkboxContactId.selectedProperty().not());
		comboboxContactId.setItems(FXCollections.observableArrayList(AddressSearchType.values()));
		comboboxContactId.getSelectionModel().selectFirst();
		hboxAddressType.disableProperty().bind(checkboxAddressType.selectedProperty().not());
		comboboxAddressType.setItems(FXCollections.observableArrayList(AddressSearchType.values()));
		comboboxAddressType.getSelectionModel().selectFirst();
		hboxStreet.disableProperty().bind(checkboxStreet.selectedProperty().not());
		comboboxStreet.setItems(FXCollections.observableArrayList(AddressSearchType.values()));
		comboboxStreet.getSelectionModel().selectFirst();
		hboxCountry.disableProperty().bind(checkboxCountry.selectedProperty().not());
		comboboxCountry.setItems(FXCollections.observableArrayList(AddressSearchType.values()));
		comboboxCountry.getSelectionModel().selectFirst();
		hboxState.disableProperty().bind(checkboxState.selectedProperty().not());
		comboboxState.setItems(FXCollections.observableArrayList(AddressSearchType.values()));
		comboboxState.getSelectionModel().selectFirst();
		hboxZipCode.disableProperty().bind(checkboxZipCode.selectedProperty().not());
		comboboxZipCode.setItems(FXCollections.observableArrayList(AddressSearchType.values()));
		comboboxZipCode.getSelectionModel().selectFirst();
		hboxStatus.disableProperty().bind(checkboxStatus.selectedProperty().not());
		comboboxStatus.setItems(FXCollections.observableArrayList(AddressSearchType.values()));
		comboboxStatus.getSelectionModel().selectFirst();
		hboxCreatedOn.disableProperty().bind(checkboxCreatedOn.selectedProperty().not());
		comboboxCreatedOn.setItems(FXCollections.observableArrayList(AddressSearchType.values()));
		comboboxCreatedOn.getSelectionModel().selectFirst();
		hboxUpdatedOn.disableProperty().bind(checkboxUpdatedOn.selectedProperty().not());
		comboboxUpdatedOn.setItems(FXCollections.observableArrayList(AddressSearchType.values()));
		comboboxUpdatedOn.getSelectionModel().selectFirst();
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxContactId.isSelected()){
				String value = textContactId.getText();
				String name = checkboxContactId.getText();
				AddressSearchType type = comboboxContactId.getSelectionModel().getSelectedItem();
				content.add(new AddressSearchContent(name, value, type));
			}
			if(checkboxAddressType.isSelected()){
				String value = textAddressType.getText();
				String name = checkboxAddressType.getText();
				AddressSearchType type = comboboxAddressType.getSelectionModel().getSelectedItem();
				content.add(new AddressSearchContent(name, value, type));
			}
			if(checkboxStreet.isSelected()){
				String value = textStreet.getText();
				String name = checkboxStreet.getText();
				AddressSearchType type = comboboxStreet.getSelectionModel().getSelectedItem();
				content.add(new AddressSearchContent(name, value, type));
			}
			if(checkboxCountry.isSelected()){
				String value = textCountry.getText();
				String name = checkboxCountry.getText();
				AddressSearchType type = comboboxCountry.getSelectionModel().getSelectedItem();
				content.add(new AddressSearchContent(name, value, type));
			}
			if(checkboxState.isSelected()){
				String value = textState.getText();
				String name = checkboxState.getText();
				AddressSearchType type = comboboxState.getSelectionModel().getSelectedItem();
				content.add(new AddressSearchContent(name, value, type));
			}
			if(checkboxZipCode.isSelected()){
				String value = textZipCode.getText();
				String name = checkboxZipCode.getText();
				AddressSearchType type = comboboxZipCode.getSelectionModel().getSelectedItem();
				content.add(new AddressSearchContent(name, value, type));
			}
			if(checkboxStatus.isSelected()){
				String value = textStatus.getText();
				String name = checkboxStatus.getText();
				AddressSearchType type = comboboxStatus.getSelectionModel().getSelectedItem();
				content.add(new AddressSearchContent(name, value, type));
			}
			if(checkboxCreatedOn.isSelected()){
				String value = textCreatedOn.getText();
				String name = checkboxCreatedOn.getText();
				AddressSearchType type = comboboxCreatedOn.getSelectionModel().getSelectedItem();
				content.add(new AddressSearchContent(name, value, type));
			}
			if(checkboxUpdatedOn.isSelected()){
				String value = textUpdatedOn.getText();
				String name = checkboxUpdatedOn.getText();
				AddressSearchType type = comboboxUpdatedOn.getSelectionModel().getSelectedItem();
				content.add(new AddressSearchContent(name, value, type));
			}
			
			String select = "SELECT * FROM CONTACT WHERE ";
			Optional<String> result = content.stream().map(e-> e.getName()+" = '"+e.getValue()+"'").reduce((e1,e2) -> e1 +" OR "+e2);
			result.ifPresent(e-> System.out.println(select+e));
		}
    	root.toBack();
    }
}

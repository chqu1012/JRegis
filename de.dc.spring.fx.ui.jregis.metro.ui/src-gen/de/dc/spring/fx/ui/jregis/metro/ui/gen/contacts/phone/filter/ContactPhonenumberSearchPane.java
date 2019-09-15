package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.filter;

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

public class ContactPhonenumberSearchPane extends VBox{

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
    protected ComboBox<ContactPhonenumberSearchType> comboboxContactId;

    @FXML
    protected TextField textContactId;
    @FXML
    protected HBox hboxName;

    @FXML
    protected CheckBox checkboxName;

    @FXML
    protected ComboBox<ContactPhonenumberSearchType> comboboxName;

    @FXML
    protected TextField textName;
    @FXML
    protected HBox hboxNumber;

    @FXML
    protected CheckBox checkboxNumber;

    @FXML
    protected ComboBox<ContactPhonenumberSearchType> comboboxNumber;

    @FXML
    protected TextField textNumber;
    @FXML
    protected HBox hboxNumberType;

    @FXML
    protected CheckBox checkboxNumberType;

    @FXML
    protected ComboBox<ContactPhonenumberSearchType> comboboxNumberType;

    @FXML
    protected TextField textNumberType;
    @FXML
    protected HBox hboxStatus;

    @FXML
    protected CheckBox checkboxStatus;

    @FXML
    protected ComboBox<ContactPhonenumberSearchType> comboboxStatus;

    @FXML
    protected TextField textStatus;
    @FXML
    protected HBox hboxCreatedOn;

    @FXML
    protected CheckBox checkboxCreatedOn;

    @FXML
    protected ComboBox<ContactPhonenumberSearchType> comboboxCreatedOn;

    @FXML
    protected TextField textCreatedOn;
    @FXML
    protected HBox hboxUpdatedOn;

    @FXML
    protected CheckBox checkboxUpdatedOn;

    @FXML
    protected ComboBox<ContactPhonenumberSearchType> comboboxUpdatedOn;

    @FXML
    protected TextField textUpdatedOn;
    
    private ObservableList<ContactPhonenumberSearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/gen/contacts/phone/filter/ContactPhonenumberSearchPane.fxml";

	public ContactPhonenumberSearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		hboxContactId.disableProperty().bind(checkboxContactId.selectedProperty().not());
		comboboxContactId.setItems(FXCollections.observableArrayList(ContactPhonenumberSearchType.values()));
		comboboxContactId.getSelectionModel().selectFirst();
		hboxName.disableProperty().bind(checkboxName.selectedProperty().not());
		comboboxName.setItems(FXCollections.observableArrayList(ContactPhonenumberSearchType.values()));
		comboboxName.getSelectionModel().selectFirst();
		hboxNumber.disableProperty().bind(checkboxNumber.selectedProperty().not());
		comboboxNumber.setItems(FXCollections.observableArrayList(ContactPhonenumberSearchType.values()));
		comboboxNumber.getSelectionModel().selectFirst();
		hboxNumberType.disableProperty().bind(checkboxNumberType.selectedProperty().not());
		comboboxNumberType.setItems(FXCollections.observableArrayList(ContactPhonenumberSearchType.values()));
		comboboxNumberType.getSelectionModel().selectFirst();
		hboxStatus.disableProperty().bind(checkboxStatus.selectedProperty().not());
		comboboxStatus.setItems(FXCollections.observableArrayList(ContactPhonenumberSearchType.values()));
		comboboxStatus.getSelectionModel().selectFirst();
		hboxCreatedOn.disableProperty().bind(checkboxCreatedOn.selectedProperty().not());
		comboboxCreatedOn.setItems(FXCollections.observableArrayList(ContactPhonenumberSearchType.values()));
		comboboxCreatedOn.getSelectionModel().selectFirst();
		hboxUpdatedOn.disableProperty().bind(checkboxUpdatedOn.selectedProperty().not());
		comboboxUpdatedOn.setItems(FXCollections.observableArrayList(ContactPhonenumberSearchType.values()));
		comboboxUpdatedOn.getSelectionModel().selectFirst();
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxContactId.isSelected()){
				String value = textContactId.getText();
				String name = checkboxContactId.getText();
				ContactPhonenumberSearchType type = comboboxContactId.getSelectionModel().getSelectedItem();
				content.add(new ContactPhonenumberSearchContent(name, value, type));
			}
			if(checkboxName.isSelected()){
				String value = textName.getText();
				String name = checkboxName.getText();
				ContactPhonenumberSearchType type = comboboxName.getSelectionModel().getSelectedItem();
				content.add(new ContactPhonenumberSearchContent(name, value, type));
			}
			if(checkboxNumber.isSelected()){
				String value = textNumber.getText();
				String name = checkboxNumber.getText();
				ContactPhonenumberSearchType type = comboboxNumber.getSelectionModel().getSelectedItem();
				content.add(new ContactPhonenumberSearchContent(name, value, type));
			}
			if(checkboxNumberType.isSelected()){
				String value = textNumberType.getText();
				String name = checkboxNumberType.getText();
				ContactPhonenumberSearchType type = comboboxNumberType.getSelectionModel().getSelectedItem();
				content.add(new ContactPhonenumberSearchContent(name, value, type));
			}
			if(checkboxStatus.isSelected()){
				String value = textStatus.getText();
				String name = checkboxStatus.getText();
				ContactPhonenumberSearchType type = comboboxStatus.getSelectionModel().getSelectedItem();
				content.add(new ContactPhonenumberSearchContent(name, value, type));
			}
			if(checkboxCreatedOn.isSelected()){
				String value = textCreatedOn.getText();
				String name = checkboxCreatedOn.getText();
				ContactPhonenumberSearchType type = comboboxCreatedOn.getSelectionModel().getSelectedItem();
				content.add(new ContactPhonenumberSearchContent(name, value, type));
			}
			if(checkboxUpdatedOn.isSelected()){
				String value = textUpdatedOn.getText();
				String name = checkboxUpdatedOn.getText();
				ContactPhonenumberSearchType type = comboboxUpdatedOn.getSelectionModel().getSelectedItem();
				content.add(new ContactPhonenumberSearchContent(name, value, type));
			}
			
			String select = "SELECT * FROM CONTACT WHERE ";
			Optional<String> result = content.stream().map(e-> e.getName()+" = '"+e.getValue()+"'").reduce((e1,e2) -> e1 +" OR "+e2);
			result.ifPresent(e-> System.out.println(select+e));
		}
    	root.toBack();
    }
}

package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.filter;

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

public class ContactDatesSearchPane extends VBox{

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
    protected ComboBox<ContactDatesSearchType> comboboxContactId;

    @FXML
    protected TextField textContactId;
    @FXML
    protected HBox hboxName;

    @FXML
    protected CheckBox checkboxName;

    @FXML
    protected ComboBox<ContactDatesSearchType> comboboxName;

    @FXML
    protected TextField textName;
    @FXML
    protected HBox hboxDate;

    @FXML
    protected CheckBox checkboxDate;

    @FXML
    protected ComboBox<ContactDatesSearchType> comboboxDate;

    @FXML
    protected TextField textDate;
    @FXML
    protected HBox hboxStatus;

    @FXML
    protected CheckBox checkboxStatus;

    @FXML
    protected ComboBox<ContactDatesSearchType> comboboxStatus;

    @FXML
    protected TextField textStatus;
    @FXML
    protected HBox hboxCreatedOn;

    @FXML
    protected CheckBox checkboxCreatedOn;

    @FXML
    protected ComboBox<ContactDatesSearchType> comboboxCreatedOn;

    @FXML
    protected TextField textCreatedOn;
    @FXML
    protected HBox hboxUpdatedOn;

    @FXML
    protected CheckBox checkboxUpdatedOn;

    @FXML
    protected ComboBox<ContactDatesSearchType> comboboxUpdatedOn;

    @FXML
    protected TextField textUpdatedOn;
    
    private ObservableList<ContactDatesSearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/gen/contacts/dates/filter/ContactDatesSearchPane.fxml";

	public ContactDatesSearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		hboxContactId.disableProperty().bind(checkboxContactId.selectedProperty().not());
		comboboxContactId.setItems(FXCollections.observableArrayList(ContactDatesSearchType.values()));
		comboboxContactId.getSelectionModel().selectFirst();
		hboxName.disableProperty().bind(checkboxName.selectedProperty().not());
		comboboxName.setItems(FXCollections.observableArrayList(ContactDatesSearchType.values()));
		comboboxName.getSelectionModel().selectFirst();
		hboxDate.disableProperty().bind(checkboxDate.selectedProperty().not());
		comboboxDate.setItems(FXCollections.observableArrayList(ContactDatesSearchType.values()));
		comboboxDate.getSelectionModel().selectFirst();
		hboxStatus.disableProperty().bind(checkboxStatus.selectedProperty().not());
		comboboxStatus.setItems(FXCollections.observableArrayList(ContactDatesSearchType.values()));
		comboboxStatus.getSelectionModel().selectFirst();
		hboxCreatedOn.disableProperty().bind(checkboxCreatedOn.selectedProperty().not());
		comboboxCreatedOn.setItems(FXCollections.observableArrayList(ContactDatesSearchType.values()));
		comboboxCreatedOn.getSelectionModel().selectFirst();
		hboxUpdatedOn.disableProperty().bind(checkboxUpdatedOn.selectedProperty().not());
		comboboxUpdatedOn.setItems(FXCollections.observableArrayList(ContactDatesSearchType.values()));
		comboboxUpdatedOn.getSelectionModel().selectFirst();
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxContactId.isSelected()){
				String value = textContactId.getText();
				String name = checkboxContactId.getText();
				ContactDatesSearchType type = comboboxContactId.getSelectionModel().getSelectedItem();
				content.add(new ContactDatesSearchContent(name, value, type));
			}
			if(checkboxName.isSelected()){
				String value = textName.getText();
				String name = checkboxName.getText();
				ContactDatesSearchType type = comboboxName.getSelectionModel().getSelectedItem();
				content.add(new ContactDatesSearchContent(name, value, type));
			}
			if(checkboxDate.isSelected()){
				String value = textDate.getText();
				String name = checkboxDate.getText();
				ContactDatesSearchType type = comboboxDate.getSelectionModel().getSelectedItem();
				content.add(new ContactDatesSearchContent(name, value, type));
			}
			if(checkboxStatus.isSelected()){
				String value = textStatus.getText();
				String name = checkboxStatus.getText();
				ContactDatesSearchType type = comboboxStatus.getSelectionModel().getSelectedItem();
				content.add(new ContactDatesSearchContent(name, value, type));
			}
			if(checkboxCreatedOn.isSelected()){
				String value = textCreatedOn.getText();
				String name = checkboxCreatedOn.getText();
				ContactDatesSearchType type = comboboxCreatedOn.getSelectionModel().getSelectedItem();
				content.add(new ContactDatesSearchContent(name, value, type));
			}
			if(checkboxUpdatedOn.isSelected()){
				String value = textUpdatedOn.getText();
				String name = checkboxUpdatedOn.getText();
				ContactDatesSearchType type = comboboxUpdatedOn.getSelectionModel().getSelectedItem();
				content.add(new ContactDatesSearchContent(name, value, type));
			}
			
			String select = "SELECT * FROM CONTACT WHERE ";
			Optional<String> result = content.stream().map(e-> e.getName()+" = '"+e.getValue()+"'").reduce((e1,e2) -> e1 +" OR "+e2);
			result.ifPresent(e-> System.out.println(select+e));
		}
    	root.toBack();
    }
}

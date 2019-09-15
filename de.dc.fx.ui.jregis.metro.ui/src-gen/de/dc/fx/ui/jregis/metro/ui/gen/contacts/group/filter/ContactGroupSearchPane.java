package de.dc.fx.ui.jregis.metro.ui.gen.contacts.group.filter;

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

public class ContactGroupSearchPane extends VBox{

    @FXML
    protected VBox paneContent;

    @FXML
    protected Button buttonAccept;

    @FXML
    protected Hyperlink linkCancel;

    @FXML
    protected VBox root;
    @FXML
    protected HBox hboxName;

    @FXML
    protected CheckBox checkboxName;

    @FXML
    protected ComboBox<ContactGroupSearchType> comboboxName;

    @FXML
    protected TextField textName;
    @FXML
    protected HBox hboxStatus;

    @FXML
    protected CheckBox checkboxStatus;

    @FXML
    protected ComboBox<ContactGroupSearchType> comboboxStatus;

    @FXML
    protected TextField textStatus;
    @FXML
    protected HBox hboxColor;

    @FXML
    protected CheckBox checkboxColor;

    @FXML
    protected ComboBox<ContactGroupSearchType> comboboxColor;

    @FXML
    protected TextField textColor;
    @FXML
    protected HBox hboxHoverColor;

    @FXML
    protected CheckBox checkboxHoverColor;

    @FXML
    protected ComboBox<ContactGroupSearchType> comboboxHoverColor;

    @FXML
    protected TextField textHoverColor;
    @FXML
    protected HBox hboxCreatedOn;

    @FXML
    protected CheckBox checkboxCreatedOn;

    @FXML
    protected ComboBox<ContactGroupSearchType> comboboxCreatedOn;

    @FXML
    protected TextField textCreatedOn;
    @FXML
    protected HBox hboxUpdatedOn;

    @FXML
    protected CheckBox checkboxUpdatedOn;

    @FXML
    protected ComboBox<ContactGroupSearchType> comboboxUpdatedOn;

    @FXML
    protected TextField textUpdatedOn;
    @FXML
    protected HBox hboxContactList;

    @FXML
    protected CheckBox checkboxContactList;

    @FXML
    protected ComboBox<ContactGroupSearchType> comboboxContactList;

    @FXML
    protected TextField textContactList;
    
    private ObservableList<ContactGroupSearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/gen/contacts/group/filter/ContactGroupSearchPane.fxml";

	public ContactGroupSearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
		fxmlLoader.load();
		} catch (IOException exception) {
		exception.printStackTrace();
		}
		hboxName.disableProperty().bind(checkboxName.selectedProperty().not());
		comboboxName.setItems(FXCollections.observableArrayList(ContactGroupSearchType.values()));
		hboxStatus.disableProperty().bind(checkboxStatus.selectedProperty().not());
		comboboxStatus.setItems(FXCollections.observableArrayList(ContactGroupSearchType.values()));
		hboxColor.disableProperty().bind(checkboxColor.selectedProperty().not());
		comboboxColor.setItems(FXCollections.observableArrayList(ContactGroupSearchType.values()));
		hboxHoverColor.disableProperty().bind(checkboxHoverColor.selectedProperty().not());
		comboboxHoverColor.setItems(FXCollections.observableArrayList(ContactGroupSearchType.values()));
		hboxCreatedOn.disableProperty().bind(checkboxCreatedOn.selectedProperty().not());
		comboboxCreatedOn.setItems(FXCollections.observableArrayList(ContactGroupSearchType.values()));
		hboxUpdatedOn.disableProperty().bind(checkboxUpdatedOn.selectedProperty().not());
		comboboxUpdatedOn.setItems(FXCollections.observableArrayList(ContactGroupSearchType.values()));
		hboxContactList.disableProperty().bind(checkboxContactList.selectedProperty().not());
		comboboxContactList.setItems(FXCollections.observableArrayList(ContactGroupSearchType.values()));
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxName.isSelected()){
				String value = textName.getText();
				String name = checkboxName.getText();
				ContactGroupSearchType type = comboboxName.getSelectionModel().getSelectedItem();
				content.add(new ContactGroupSearchContent(name, value, type));
			}
			if(checkboxStatus.isSelected()){
				String value = textStatus.getText();
				String name = checkboxStatus.getText();
				ContactGroupSearchType type = comboboxStatus.getSelectionModel().getSelectedItem();
				content.add(new ContactGroupSearchContent(name, value, type));
			}
			if(checkboxColor.isSelected()){
				String value = textColor.getText();
				String name = checkboxColor.getText();
				ContactGroupSearchType type = comboboxColor.getSelectionModel().getSelectedItem();
				content.add(new ContactGroupSearchContent(name, value, type));
			}
			if(checkboxHoverColor.isSelected()){
				String value = textHoverColor.getText();
				String name = checkboxHoverColor.getText();
				ContactGroupSearchType type = comboboxHoverColor.getSelectionModel().getSelectedItem();
				content.add(new ContactGroupSearchContent(name, value, type));
			}
			if(checkboxCreatedOn.isSelected()){
				String value = textCreatedOn.getText();
				String name = checkboxCreatedOn.getText();
				ContactGroupSearchType type = comboboxCreatedOn.getSelectionModel().getSelectedItem();
				content.add(new ContactGroupSearchContent(name, value, type));
			}
			if(checkboxUpdatedOn.isSelected()){
				String value = textUpdatedOn.getText();
				String name = checkboxUpdatedOn.getText();
				ContactGroupSearchType type = comboboxUpdatedOn.getSelectionModel().getSelectedItem();
				content.add(new ContactGroupSearchContent(name, value, type));
			}
			if(checkboxContactList.isSelected()){
				String value = textContactList.getText();
				String name = checkboxContactList.getText();
				ContactGroupSearchType type = comboboxContactList.getSelectionModel().getSelectedItem();
				content.add(new ContactGroupSearchContent(name, value, type));
			}
			content.stream().forEach(System.out::println);
		}
    	root.toBack();
    }
}

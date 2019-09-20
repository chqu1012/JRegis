package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.filter;

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

public class EmailSearchPane extends VBox{

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
    protected ComboBox<EmailSearchType> comboboxContactId;

    @FXML
    protected TextField textContactId;
    @FXML
    protected HBox hboxName;

    @FXML
    protected CheckBox checkboxName;

    @FXML
    protected ComboBox<EmailSearchType> comboboxName;

    @FXML
    protected TextField textName;
    @FXML
    protected HBox hboxAddress;

    @FXML
    protected CheckBox checkboxAddress;

    @FXML
    protected ComboBox<EmailSearchType> comboboxAddress;

    @FXML
    protected TextField textAddress;
    @FXML
    protected HBox hboxStatus;

    @FXML
    protected CheckBox checkboxStatus;

    @FXML
    protected ComboBox<EmailSearchType> comboboxStatus;

    @FXML
    protected TextField textStatus;
    @FXML
    protected HBox hboxCreatedOn;

    @FXML
    protected CheckBox checkboxCreatedOn;

    @FXML
    protected ComboBox<EmailSearchType> comboboxCreatedOn;

    @FXML
    protected TextField textCreatedOn;
    @FXML
    protected HBox hboxUpdatedOn;

    @FXML
    protected CheckBox checkboxUpdatedOn;

    @FXML
    protected ComboBox<EmailSearchType> comboboxUpdatedOn;

    @FXML
    protected TextField textUpdatedOn;
    
    private ObservableList<EmailSearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/gen/contacts/email/filter/EmailSearchPane.fxml";

	public EmailSearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
		fxmlLoader.load();
		} catch (IOException exception) {
		exception.printStackTrace();
		}
		hboxContactId.disableProperty().bind(checkboxContactId.selectedProperty().not());
		comboboxContactId.setItems(FXCollections.observableArrayList(EmailSearchType.values()));
		hboxName.disableProperty().bind(checkboxName.selectedProperty().not());
		comboboxName.setItems(FXCollections.observableArrayList(EmailSearchType.values()));
		hboxAddress.disableProperty().bind(checkboxAddress.selectedProperty().not());
		comboboxAddress.setItems(FXCollections.observableArrayList(EmailSearchType.values()));
		hboxStatus.disableProperty().bind(checkboxStatus.selectedProperty().not());
		comboboxStatus.setItems(FXCollections.observableArrayList(EmailSearchType.values()));
		hboxCreatedOn.disableProperty().bind(checkboxCreatedOn.selectedProperty().not());
		comboboxCreatedOn.setItems(FXCollections.observableArrayList(EmailSearchType.values()));
		hboxUpdatedOn.disableProperty().bind(checkboxUpdatedOn.selectedProperty().not());
		comboboxUpdatedOn.setItems(FXCollections.observableArrayList(EmailSearchType.values()));
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxContactId.isSelected()){
				String value = textContactId.getText();
				String name = checkboxContactId.getText();
				EmailSearchType type = comboboxContactId.getSelectionModel().getSelectedItem();
				content.add(new EmailSearchContent(name, value, type));
			}
			if(checkboxName.isSelected()){
				String value = textName.getText();
				String name = checkboxName.getText();
				EmailSearchType type = comboboxName.getSelectionModel().getSelectedItem();
				content.add(new EmailSearchContent(name, value, type));
			}
			if(checkboxAddress.isSelected()){
				String value = textAddress.getText();
				String name = checkboxAddress.getText();
				EmailSearchType type = comboboxAddress.getSelectionModel().getSelectedItem();
				content.add(new EmailSearchContent(name, value, type));
			}
			if(checkboxStatus.isSelected()){
				String value = textStatus.getText();
				String name = checkboxStatus.getText();
				EmailSearchType type = comboboxStatus.getSelectionModel().getSelectedItem();
				content.add(new EmailSearchContent(name, value, type));
			}
			if(checkboxCreatedOn.isSelected()){
				String value = textCreatedOn.getText();
				String name = checkboxCreatedOn.getText();
				EmailSearchType type = comboboxCreatedOn.getSelectionModel().getSelectedItem();
				content.add(new EmailSearchContent(name, value, type));
			}
			if(checkboxUpdatedOn.isSelected()){
				String value = textUpdatedOn.getText();
				String name = checkboxUpdatedOn.getText();
				EmailSearchType type = comboboxUpdatedOn.getSelectionModel().getSelectedItem();
				content.add(new EmailSearchContent(name, value, type));
			}
			content.stream().forEach(System.out::println);
		}
    	root.toBack();
    }
}

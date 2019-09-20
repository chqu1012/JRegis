package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.filter;

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

public class PhonenumberSearchPane extends VBox{

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
    protected ComboBox<PhonenumberSearchType> comboboxContactId;

    @FXML
    protected TextField textContactId;
    @FXML
    protected HBox hboxName;

    @FXML
    protected CheckBox checkboxName;

    @FXML
    protected ComboBox<PhonenumberSearchType> comboboxName;

    @FXML
    protected TextField textName;
    @FXML
    protected HBox hboxNumber;

    @FXML
    protected CheckBox checkboxNumber;

    @FXML
    protected ComboBox<PhonenumberSearchType> comboboxNumber;

    @FXML
    protected TextField textNumber;
    @FXML
    protected HBox hboxNumberType;

    @FXML
    protected CheckBox checkboxNumberType;

    @FXML
    protected ComboBox<PhonenumberSearchType> comboboxNumberType;

    @FXML
    protected TextField textNumberType;
    @FXML
    protected HBox hboxStatus;

    @FXML
    protected CheckBox checkboxStatus;

    @FXML
    protected ComboBox<PhonenumberSearchType> comboboxStatus;

    @FXML
    protected TextField textStatus;
    @FXML
    protected HBox hboxCreatedOn;

    @FXML
    protected CheckBox checkboxCreatedOn;

    @FXML
    protected ComboBox<PhonenumberSearchType> comboboxCreatedOn;

    @FXML
    protected TextField textCreatedOn;
    @FXML
    protected HBox hboxUpdatedOn;

    @FXML
    protected CheckBox checkboxUpdatedOn;

    @FXML
    protected ComboBox<PhonenumberSearchType> comboboxUpdatedOn;

    @FXML
    protected TextField textUpdatedOn;
    
    private ObservableList<PhonenumberSearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/gen/contacts/phone/filter/PhonenumberSearchPane.fxml";

	public PhonenumberSearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
		fxmlLoader.load();
		} catch (IOException exception) {
		exception.printStackTrace();
		}
		hboxContactId.disableProperty().bind(checkboxContactId.selectedProperty().not());
		comboboxContactId.setItems(FXCollections.observableArrayList(PhonenumberSearchType.values()));
		hboxName.disableProperty().bind(checkboxName.selectedProperty().not());
		comboboxName.setItems(FXCollections.observableArrayList(PhonenumberSearchType.values()));
		hboxNumber.disableProperty().bind(checkboxNumber.selectedProperty().not());
		comboboxNumber.setItems(FXCollections.observableArrayList(PhonenumberSearchType.values()));
		hboxNumberType.disableProperty().bind(checkboxNumberType.selectedProperty().not());
		comboboxNumberType.setItems(FXCollections.observableArrayList(PhonenumberSearchType.values()));
		hboxStatus.disableProperty().bind(checkboxStatus.selectedProperty().not());
		comboboxStatus.setItems(FXCollections.observableArrayList(PhonenumberSearchType.values()));
		hboxCreatedOn.disableProperty().bind(checkboxCreatedOn.selectedProperty().not());
		comboboxCreatedOn.setItems(FXCollections.observableArrayList(PhonenumberSearchType.values()));
		hboxUpdatedOn.disableProperty().bind(checkboxUpdatedOn.selectedProperty().not());
		comboboxUpdatedOn.setItems(FXCollections.observableArrayList(PhonenumberSearchType.values()));
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxContactId.isSelected()){
				String value = textContactId.getText();
				String name = checkboxContactId.getText();
				PhonenumberSearchType type = comboboxContactId.getSelectionModel().getSelectedItem();
				content.add(new PhonenumberSearchContent(name, value, type));
			}
			if(checkboxName.isSelected()){
				String value = textName.getText();
				String name = checkboxName.getText();
				PhonenumberSearchType type = comboboxName.getSelectionModel().getSelectedItem();
				content.add(new PhonenumberSearchContent(name, value, type));
			}
			if(checkboxNumber.isSelected()){
				String value = textNumber.getText();
				String name = checkboxNumber.getText();
				PhonenumberSearchType type = comboboxNumber.getSelectionModel().getSelectedItem();
				content.add(new PhonenumberSearchContent(name, value, type));
			}
			if(checkboxNumberType.isSelected()){
				String value = textNumberType.getText();
				String name = checkboxNumberType.getText();
				PhonenumberSearchType type = comboboxNumberType.getSelectionModel().getSelectedItem();
				content.add(new PhonenumberSearchContent(name, value, type));
			}
			if(checkboxStatus.isSelected()){
				String value = textStatus.getText();
				String name = checkboxStatus.getText();
				PhonenumberSearchType type = comboboxStatus.getSelectionModel().getSelectedItem();
				content.add(new PhonenumberSearchContent(name, value, type));
			}
			if(checkboxCreatedOn.isSelected()){
				String value = textCreatedOn.getText();
				String name = checkboxCreatedOn.getText();
				PhonenumberSearchType type = comboboxCreatedOn.getSelectionModel().getSelectedItem();
				content.add(new PhonenumberSearchContent(name, value, type));
			}
			if(checkboxUpdatedOn.isSelected()){
				String value = textUpdatedOn.getText();
				String name = checkboxUpdatedOn.getText();
				PhonenumberSearchType type = comboboxUpdatedOn.getSelectionModel().getSelectedItem();
				content.add(new PhonenumberSearchContent(name, value, type));
			}
			content.stream().forEach(System.out::println);
		}
    	root.toBack();
    }
}

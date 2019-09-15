package de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.filter;

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

public class ActivitySearchPane extends VBox{

    @FXML
    protected VBox paneContent;

    @FXML
    protected Button buttonAccept;

    @FXML
    protected Hyperlink linkCancel;

    @FXML
    protected VBox root;
    @FXML
    protected HBox hboxTitle;

    @FXML
    protected CheckBox checkboxTitle;

    @FXML
    protected ComboBox<ActivitySearchType> comboboxTitle;

    @FXML
    protected TextField textTitle;
    @FXML
    protected HBox hboxStatus;

    @FXML
    protected CheckBox checkboxStatus;

    @FXML
    protected ComboBox<ActivitySearchType> comboboxStatus;

    @FXML
    protected TextField textStatus;
    @FXML
    protected HBox hboxUserId;

    @FXML
    protected CheckBox checkboxUserId;

    @FXML
    protected ComboBox<ActivitySearchType> comboboxUserId;

    @FXML
    protected TextField textUserId;
    @FXML
    protected HBox hboxDescription;

    @FXML
    protected CheckBox checkboxDescription;

    @FXML
    protected ComboBox<ActivitySearchType> comboboxDescription;

    @FXML
    protected TextField textDescription;
    @FXML
    protected HBox hboxCreatedOn;

    @FXML
    protected CheckBox checkboxCreatedOn;

    @FXML
    protected ComboBox<ActivitySearchType> comboboxCreatedOn;

    @FXML
    protected TextField textCreatedOn;
    @FXML
    protected HBox hboxUpdatedOn;

    @FXML
    protected CheckBox checkboxUpdatedOn;

    @FXML
    protected ComboBox<ActivitySearchType> comboboxUpdatedOn;

    @FXML
    protected TextField textUpdatedOn;
    
    private ObservableList<ActivitySearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/gen/activity/filter/ActivitySearchPane.fxml";

	public ActivitySearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		hboxTitle.disableProperty().bind(checkboxTitle.selectedProperty().not());
		comboboxTitle.setItems(FXCollections.observableArrayList(ActivitySearchType.values()));
		comboboxTitle.getSelectionModel().selectFirst();
		hboxStatus.disableProperty().bind(checkboxStatus.selectedProperty().not());
		comboboxStatus.setItems(FXCollections.observableArrayList(ActivitySearchType.values()));
		comboboxStatus.getSelectionModel().selectFirst();
		hboxUserId.disableProperty().bind(checkboxUserId.selectedProperty().not());
		comboboxUserId.setItems(FXCollections.observableArrayList(ActivitySearchType.values()));
		comboboxUserId.getSelectionModel().selectFirst();
		hboxDescription.disableProperty().bind(checkboxDescription.selectedProperty().not());
		comboboxDescription.setItems(FXCollections.observableArrayList(ActivitySearchType.values()));
		comboboxDescription.getSelectionModel().selectFirst();
		hboxCreatedOn.disableProperty().bind(checkboxCreatedOn.selectedProperty().not());
		comboboxCreatedOn.setItems(FXCollections.observableArrayList(ActivitySearchType.values()));
		comboboxCreatedOn.getSelectionModel().selectFirst();
		hboxUpdatedOn.disableProperty().bind(checkboxUpdatedOn.selectedProperty().not());
		comboboxUpdatedOn.setItems(FXCollections.observableArrayList(ActivitySearchType.values()));
		comboboxUpdatedOn.getSelectionModel().selectFirst();
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxTitle.isSelected()){
				String value = textTitle.getText();
				String name = checkboxTitle.getText();
				ActivitySearchType type = comboboxTitle.getSelectionModel().getSelectedItem();
				content.add(new ActivitySearchContent(name, value, type));
			}
			if(checkboxStatus.isSelected()){
				String value = textStatus.getText();
				String name = checkboxStatus.getText();
				ActivitySearchType type = comboboxStatus.getSelectionModel().getSelectedItem();
				content.add(new ActivitySearchContent(name, value, type));
			}
			if(checkboxUserId.isSelected()){
				String value = textUserId.getText();
				String name = checkboxUserId.getText();
				ActivitySearchType type = comboboxUserId.getSelectionModel().getSelectedItem();
				content.add(new ActivitySearchContent(name, value, type));
			}
			if(checkboxDescription.isSelected()){
				String value = textDescription.getText();
				String name = checkboxDescription.getText();
				ActivitySearchType type = comboboxDescription.getSelectionModel().getSelectedItem();
				content.add(new ActivitySearchContent(name, value, type));
			}
			if(checkboxCreatedOn.isSelected()){
				String value = textCreatedOn.getText();
				String name = checkboxCreatedOn.getText();
				ActivitySearchType type = comboboxCreatedOn.getSelectionModel().getSelectedItem();
				content.add(new ActivitySearchContent(name, value, type));
			}
			if(checkboxUpdatedOn.isSelected()){
				String value = textUpdatedOn.getText();
				String name = checkboxUpdatedOn.getText();
				ActivitySearchType type = comboboxUpdatedOn.getSelectionModel().getSelectedItem();
				content.add(new ActivitySearchContent(name, value, type));
			}
			
			String select = "SELECT * FROM CONTACT WHERE ";
			Optional<String> result = content.stream().map(e-> e.getName()+" = '"+e.getValue()+"'").reduce((e1,e2) -> e1 +" OR "+e2);
			result.ifPresent(e-> System.out.println(select+e));
		}
    	root.toBack();
    }
}

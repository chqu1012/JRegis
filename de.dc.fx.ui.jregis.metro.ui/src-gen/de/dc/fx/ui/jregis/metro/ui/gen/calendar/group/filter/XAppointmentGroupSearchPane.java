package de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.filter;

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

public class XAppointmentGroupSearchPane extends VBox{

    @FXML
    protected VBox paneContent;

    @FXML
    protected Button buttonAccept;

    @FXML
    protected Hyperlink linkCancel;

    @FXML
    protected VBox root;
    @FXML
    protected HBox hboxAppointmentId;

    @FXML
    protected CheckBox checkboxAppointmentId;

    @FXML
    protected ComboBox<XAppointmentGroupSearchType> comboboxAppointmentId;

    @FXML
    protected TextField textAppointmentId;
    @FXML
    protected HBox hboxTopic;

    @FXML
    protected CheckBox checkboxTopic;

    @FXML
    protected ComboBox<XAppointmentGroupSearchType> comboboxTopic;

    @FXML
    protected TextField textTopic;
    @FXML
    protected HBox hboxSummary;

    @FXML
    protected CheckBox checkboxSummary;

    @FXML
    protected ComboBox<XAppointmentGroupSearchType> comboboxSummary;

    @FXML
    protected TextField textSummary;
    @FXML
    protected HBox hboxStart;

    @FXML
    protected CheckBox checkboxStart;

    @FXML
    protected ComboBox<XAppointmentGroupSearchType> comboboxStart;

    @FXML
    protected TextField textStart;
    @FXML
    protected HBox hboxEnd;

    @FXML
    protected CheckBox checkboxEnd;

    @FXML
    protected ComboBox<XAppointmentGroupSearchType> comboboxEnd;

    @FXML
    protected TextField textEnd;
    @FXML
    protected HBox hboxAppointmentGroupId;

    @FXML
    protected CheckBox checkboxAppointmentGroupId;

    @FXML
    protected ComboBox<XAppointmentGroupSearchType> comboboxAppointmentGroupId;

    @FXML
    protected TextField textAppointmentGroupId;
    
    private ObservableList<XAppointmentGroupSearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/gen/calendar/group/filter/XAppointmentGroupSearchPane.fxml";

	public XAppointmentGroupSearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
		fxmlLoader.load();
		} catch (IOException exception) {
		exception.printStackTrace();
		}
		hboxAppointmentId.disableProperty().bind(checkboxAppointmentId.selectedProperty().not());
		comboboxAppointmentId.setItems(FXCollections.observableArrayList(XAppointmentGroupSearchType.values()));
		hboxTopic.disableProperty().bind(checkboxTopic.selectedProperty().not());
		comboboxTopic.setItems(FXCollections.observableArrayList(XAppointmentGroupSearchType.values()));
		hboxSummary.disableProperty().bind(checkboxSummary.selectedProperty().not());
		comboboxSummary.setItems(FXCollections.observableArrayList(XAppointmentGroupSearchType.values()));
		hboxStart.disableProperty().bind(checkboxStart.selectedProperty().not());
		comboboxStart.setItems(FXCollections.observableArrayList(XAppointmentGroupSearchType.values()));
		hboxEnd.disableProperty().bind(checkboxEnd.selectedProperty().not());
		comboboxEnd.setItems(FXCollections.observableArrayList(XAppointmentGroupSearchType.values()));
		hboxAppointmentGroupId.disableProperty().bind(checkboxAppointmentGroupId.selectedProperty().not());
		comboboxAppointmentGroupId.setItems(FXCollections.observableArrayList(XAppointmentGroupSearchType.values()));
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxAppointmentId.isSelected()){
				String value = textAppointmentId.getText();
				String name = checkboxAppointmentId.getText();
				XAppointmentGroupSearchType type = comboboxAppointmentId.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentGroupSearchContent(name, value, type));
			}
			if(checkboxTopic.isSelected()){
				String value = textTopic.getText();
				String name = checkboxTopic.getText();
				XAppointmentGroupSearchType type = comboboxTopic.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentGroupSearchContent(name, value, type));
			}
			if(checkboxSummary.isSelected()){
				String value = textSummary.getText();
				String name = checkboxSummary.getText();
				XAppointmentGroupSearchType type = comboboxSummary.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentGroupSearchContent(name, value, type));
			}
			if(checkboxStart.isSelected()){
				String value = textStart.getText();
				String name = checkboxStart.getText();
				XAppointmentGroupSearchType type = comboboxStart.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentGroupSearchContent(name, value, type));
			}
			if(checkboxEnd.isSelected()){
				String value = textEnd.getText();
				String name = checkboxEnd.getText();
				XAppointmentGroupSearchType type = comboboxEnd.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentGroupSearchContent(name, value, type));
			}
			if(checkboxAppointmentGroupId.isSelected()){
				String value = textAppointmentGroupId.getText();
				String name = checkboxAppointmentGroupId.getText();
				XAppointmentGroupSearchType type = comboboxAppointmentGroupId.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentGroupSearchContent(name, value, type));
			}
			content.stream().forEach(System.out::println);
		}
    	root.toBack();
    }
}

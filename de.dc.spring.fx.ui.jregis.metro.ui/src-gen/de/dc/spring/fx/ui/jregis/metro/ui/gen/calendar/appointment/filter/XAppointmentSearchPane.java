package de.dc.spring.fx.ui.jregis.metro.ui.gen.calendar.appointment.filter;

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

public class XAppointmentSearchPane extends VBox{

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
    protected ComboBox<XAppointmentSearchType> comboboxContactId;

    @FXML
    protected TextField textContactId;
    @FXML
    protected HBox hboxTopic;

    @FXML
    protected CheckBox checkboxTopic;

    @FXML
    protected ComboBox<XAppointmentSearchType> comboboxTopic;

    @FXML
    protected TextField textTopic;
    @FXML
    protected HBox hboxSummary;

    @FXML
    protected CheckBox checkboxSummary;

    @FXML
    protected ComboBox<XAppointmentSearchType> comboboxSummary;

    @FXML
    protected TextField textSummary;
    @FXML
    protected HBox hboxStart;

    @FXML
    protected CheckBox checkboxStart;

    @FXML
    protected ComboBox<XAppointmentSearchType> comboboxStart;

    @FXML
    protected TextField textStart;
    @FXML
    protected HBox hboxEnd;

    @FXML
    protected CheckBox checkboxEnd;

    @FXML
    protected ComboBox<XAppointmentSearchType> comboboxEnd;

    @FXML
    protected TextField textEnd;
    @FXML
    protected HBox hboxAppointmentGroupId;

    @FXML
    protected CheckBox checkboxAppointmentGroupId;

    @FXML
    protected ComboBox<XAppointmentSearchType> comboboxAppointmentGroupId;

    @FXML
    protected TextField textAppointmentGroupId;
    
    private ObservableList<XAppointmentSearchContent> content = FXCollections.observableArrayList();
     
	public static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/gen/calendar/appointment/filter/XAppointmentSearchPane.fxml";

	public XAppointmentSearchPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		hboxContactId.disableProperty().bind(checkboxContactId.selectedProperty().not());
		comboboxContactId.setItems(FXCollections.observableArrayList(XAppointmentSearchType.values()));
		comboboxContactId.getSelectionModel().selectFirst();
		hboxTopic.disableProperty().bind(checkboxTopic.selectedProperty().not());
		comboboxTopic.setItems(FXCollections.observableArrayList(XAppointmentSearchType.values()));
		comboboxTopic.getSelectionModel().selectFirst();
		hboxSummary.disableProperty().bind(checkboxSummary.selectedProperty().not());
		comboboxSummary.setItems(FXCollections.observableArrayList(XAppointmentSearchType.values()));
		comboboxSummary.getSelectionModel().selectFirst();
		hboxStart.disableProperty().bind(checkboxStart.selectedProperty().not());
		comboboxStart.setItems(FXCollections.observableArrayList(XAppointmentSearchType.values()));
		comboboxStart.getSelectionModel().selectFirst();
		hboxEnd.disableProperty().bind(checkboxEnd.selectedProperty().not());
		comboboxEnd.setItems(FXCollections.observableArrayList(XAppointmentSearchType.values()));
		comboboxEnd.getSelectionModel().selectFirst();
		hboxAppointmentGroupId.disableProperty().bind(checkboxAppointmentGroupId.selectedProperty().not());
		comboboxAppointmentGroupId.setItems(FXCollections.observableArrayList(XAppointmentSearchType.values()));
		comboboxAppointmentGroupId.getSelectionModel().selectFirst();
	}
     
    @FXML
    protected void onActionEvent(ActionEvent event) {
    	if (event.getSource()==buttonAccept) {
    		content.clear();
			if(checkboxContactId.isSelected()){
				String value = textContactId.getText();
				String name = checkboxContactId.getText();
				XAppointmentSearchType type = comboboxContactId.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentSearchContent(name, value, type));
			}
			if(checkboxTopic.isSelected()){
				String value = textTopic.getText();
				String name = checkboxTopic.getText();
				XAppointmentSearchType type = comboboxTopic.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentSearchContent(name, value, type));
			}
			if(checkboxSummary.isSelected()){
				String value = textSummary.getText();
				String name = checkboxSummary.getText();
				XAppointmentSearchType type = comboboxSummary.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentSearchContent(name, value, type));
			}
			if(checkboxStart.isSelected()){
				String value = textStart.getText();
				String name = checkboxStart.getText();
				XAppointmentSearchType type = comboboxStart.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentSearchContent(name, value, type));
			}
			if(checkboxEnd.isSelected()){
				String value = textEnd.getText();
				String name = checkboxEnd.getText();
				XAppointmentSearchType type = comboboxEnd.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentSearchContent(name, value, type));
			}
			if(checkboxAppointmentGroupId.isSelected()){
				String value = textAppointmentGroupId.getText();
				String name = checkboxAppointmentGroupId.getText();
				XAppointmentSearchType type = comboboxAppointmentGroupId.getSelectionModel().getSelectedItem();
				content.add(new XAppointmentSearchContent(name, value, type));
			}
			
			String select = "SELECT * FROM CONTACT WHERE ";
			Optional<String> result = content.stream().map(e-> e.getName()+" = '"+e.getValue()+"'").reduce((e1,e2) -> e1 +" OR "+e2);
			result.ifPresent(e-> System.out.println(select+e));
		}
    	root.toBack();
    }
}

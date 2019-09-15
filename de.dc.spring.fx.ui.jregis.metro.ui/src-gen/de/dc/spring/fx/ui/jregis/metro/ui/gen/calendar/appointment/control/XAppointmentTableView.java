package de.dc.spring.fx.ui.jregis.metro.ui.gen.calendar.appointment.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.calendar.appointment.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.calendar.appointment.repository.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javax.annotation.PostConstruct;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

@Component
public class XAppointmentTableView extends TableView<XAppointment>{
	
	@Autowired
	private XAppointmentFX context;

	@PostConstruct
	public void init() {
		TableColumn<XAppointment, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<XAppointment, java.lang.Long> columnContactId = new TableColumn<>("#CONTACTID");
		columnContactId.setPrefWidth(100.0);
		setupCellValueFactory(columnContactId, e->new SimpleObjectProperty<>(e.getContactId()));
		getColumns().add(columnContactId);
		TableColumn<XAppointment, java.lang.String> columnTopic = new TableColumn<>("#TOPIC");
		columnTopic.setPrefWidth(100.0);
		setupCellValueFactory(columnTopic, e->new SimpleObjectProperty<>(e.getTopic()));
		getColumns().add(columnTopic);
		TableColumn<XAppointment, java.lang.String> columnSummary = new TableColumn<>("#SUMMARY");
		columnSummary.setPrefWidth(100.0);
		setupCellValueFactory(columnSummary, e->new SimpleObjectProperty<>(e.getSummary()));
		getColumns().add(columnSummary);
		TableColumn<XAppointment, java.time.LocalDateTime> columnStart = new TableColumn<>("#START");
		columnStart.setPrefWidth(100.0);
		setupCellValueFactory(columnStart, e->new SimpleObjectProperty<>(e.getStart()));
		getColumns().add(columnStart);
		TableColumn<XAppointment, java.time.LocalDateTime> columnEnd = new TableColumn<>("#END");
		columnEnd.setPrefWidth(100.0);
		setupCellValueFactory(columnEnd, e->new SimpleObjectProperty<>(e.getEnd()));
		getColumns().add(columnEnd);
		TableColumn<XAppointment, java.lang.Long> columnAppointmentGroupId = new TableColumn<>("#APPOINTMENTGROUPID");
		columnAppointmentGroupId.setPrefWidth(100.0);
		setupCellValueFactory(columnAppointmentGroupId, e->new SimpleObjectProperty<>(e.getAppointmentGroupId()));
		getColumns().add(columnAppointmentGroupId);
		
		setItems(context.getMasterData());
	}

	public FilteredList<XAppointment> getFilteredList(){
		return context.getFilteredMasterData();
	}
	
	public ObservableList<XAppointment> getMasterData(){
		return context.getMasterData();
	}
	
	public void add(XAppointment... xAppointments) {
		context.getMasterData().addAll(xAppointments);
	}
	
	public void remove(XAppointment... xAppointments) {
		context.getMasterData().removeAll(xAppointments);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

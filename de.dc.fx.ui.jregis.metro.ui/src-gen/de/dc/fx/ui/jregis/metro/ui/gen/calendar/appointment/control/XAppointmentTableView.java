package de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.control;

import java.util.function.Function;
import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.repository.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class XAppointmentTableView extends TableView<XAppointment>{
	
	private ObservableList<XAppointment> masterData = FXCollections.observableArrayList();
	private FilteredList<XAppointment> filteredData = new FilteredList<>(masterData, p->true);
	
	private XAppointmentFX context;
	private XAppointmentRepository xAppointmentRepository;
	
	@Inject
	public XAppointmentTableView(XAppointmentFX context, XAppointmentRepository xAppointmentRepository) {
		this.context = context;
		this.xAppointmentRepository = xAppointmentRepository;
		
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
		
		context.getMasterData().addAll(xAppointmentRepository.findAll());
		setItems(context.getFilteredMasterData());
	}

	public FilteredList<XAppointment> getFilteredList(){
		return filteredData;
	}
	
	public ObservableList<XAppointment> getMasterData(){
		return masterData;
	}
	
	public void add(XAppointment... xAppointments) {
		masterData.addAll(xAppointments);
	}
	
	public void remove(XAppointment... xAppointments) {
		masterData.removeAll(xAppointments);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

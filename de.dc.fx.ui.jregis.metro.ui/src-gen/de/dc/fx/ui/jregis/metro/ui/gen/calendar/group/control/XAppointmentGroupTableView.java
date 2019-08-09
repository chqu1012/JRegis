package de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.control;

import java.util.function.Function;
import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.group.repository.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class XAppointmentGroupTableView extends TableView<XAppointmentGroup>{
	
	private ObservableList<XAppointmentGroup> masterData = FXCollections.observableArrayList();
	private FilteredList<XAppointmentGroup> filteredData = new FilteredList<>(masterData, p->true);
	
	private XAppointmentGroupFX context;
	private XAppointmentGroupRepository xAppointmentGroupRepository;
	
	@Inject
	public XAppointmentGroupTableView(XAppointmentGroupFX context, XAppointmentGroupRepository xAppointmentGroupRepository) {
		this.context = context;
		this.xAppointmentGroupRepository = xAppointmentGroupRepository;
		
		TableColumn<XAppointmentGroup, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<XAppointmentGroup, java.lang.Long> columnAppointmentId = new TableColumn<>("#APPOINTMENTID");
		columnAppointmentId.setPrefWidth(100.0);
		setupCellValueFactory(columnAppointmentId, e->new SimpleObjectProperty<>(e.getAppointmentId()));
		getColumns().add(columnAppointmentId);
		TableColumn<XAppointmentGroup, java.lang.String> columnTopic = new TableColumn<>("#TOPIC");
		columnTopic.setPrefWidth(100.0);
		setupCellValueFactory(columnTopic, e->new SimpleObjectProperty<>(e.getTopic()));
		getColumns().add(columnTopic);
		TableColumn<XAppointmentGroup, java.lang.String> columnSummary = new TableColumn<>("#SUMMARY");
		columnSummary.setPrefWidth(100.0);
		setupCellValueFactory(columnSummary, e->new SimpleObjectProperty<>(e.getSummary()));
		getColumns().add(columnSummary);
		TableColumn<XAppointmentGroup, java.time.LocalDateTime> columnStart = new TableColumn<>("#START");
		columnStart.setPrefWidth(100.0);
		setupCellValueFactory(columnStart, e->new SimpleObjectProperty<>(e.getStart()));
		getColumns().add(columnStart);
		TableColumn<XAppointmentGroup, java.time.LocalDateTime> columnEnd = new TableColumn<>("#END");
		columnEnd.setPrefWidth(100.0);
		setupCellValueFactory(columnEnd, e->new SimpleObjectProperty<>(e.getEnd()));
		getColumns().add(columnEnd);
		TableColumn<XAppointmentGroup, java.lang.Integer> columnAppointmentGroupId = new TableColumn<>("#APPOINTMENTGROUPID");
		columnAppointmentGroupId.setPrefWidth(100.0);
		setupCellValueFactory(columnAppointmentGroupId, e->new SimpleObjectProperty<>(e.getAppointmentGroupId()));
		getColumns().add(columnAppointmentGroupId);
		
		context.getMasterData().addAll(xAppointmentGroupRepository.findAll());
		setItems(context.getFilteredMasterData());
	}

	public FilteredList<XAppointmentGroup> getFilteredList(){
		return filteredData;
	}
	
	public ObservableList<XAppointmentGroup> getMasterData(){
		return masterData;
	}
	
	public void add(XAppointmentGroup... xAppointmentGroups) {
		masterData.addAll(xAppointmentGroups);
	}
	
	public void remove(XAppointmentGroup... xAppointmentGroups) {
		masterData.removeAll(xAppointmentGroups);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

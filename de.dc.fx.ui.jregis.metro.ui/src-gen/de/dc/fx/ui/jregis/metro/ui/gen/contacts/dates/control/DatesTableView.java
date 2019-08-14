package de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.control;

import java.util.function.Function;
import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.dates.repository.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class DatesTableView extends TableView<Dates>{
	
	private ObservableList<Dates> masterData = FXCollections.observableArrayList();
	private FilteredList<Dates> filteredData = new FilteredList<>(masterData, p->true);
	
	private DatesFX context;
	private DatesRepository datesRepository;
	
	@Inject
	public DatesTableView(DatesFX context, DatesRepository datesRepository) {
		this.context = context;
		this.datesRepository = datesRepository;
		
		TableColumn<Dates, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<Dates, java.lang.Long> columnContactId = new TableColumn<>("#CONTACTID");
		columnContactId.setPrefWidth(100.0);
		setupCellValueFactory(columnContactId, e->new SimpleObjectProperty<>(e.getContactId()));
		getColumns().add(columnContactId);
		TableColumn<Dates, java.lang.String> columnName = new TableColumn<>("#NAME");
		columnName.setPrefWidth(200.0);
		setupCellValueFactory(columnName, e->new SimpleObjectProperty<>(e.getName()));
		getColumns().add(columnName);
		TableColumn<Dates, java.time.LocalDateTime> columnDate = new TableColumn<>("#DATE");
		columnDate.setPrefWidth(100.0);
		setupCellValueFactory(columnDate, e->new SimpleObjectProperty<>(e.getDate()));
		getColumns().add(columnDate);
		TableColumn<Dates, java.lang.Integer> columnStatus = new TableColumn<>("#STATUS");
		columnStatus.setPrefWidth(100.0);
		setupCellValueFactory(columnStatus, e->new SimpleObjectProperty<>(e.getStatus()));
		getColumns().add(columnStatus);
		TableColumn<Dates, java.time.LocalDateTime> columnCreatedOn = new TableColumn<>("#CREATEDON");
		columnCreatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnCreatedOn, e->new SimpleObjectProperty<>(e.getCreatedOn()));
		getColumns().add(columnCreatedOn);
		TableColumn<Dates, java.time.LocalDateTime> columnUpdatedOn = new TableColumn<>("#UPDATEDON");
		columnUpdatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnUpdatedOn, e->new SimpleObjectProperty<>(e.getUpdatedOn()));
		getColumns().add(columnUpdatedOn);
		
		context.getMasterData().addAll(datesRepository.findAll());
		setItems(context.getFilteredMasterData());
	}

	public FilteredList<Dates> getFilteredList(){
		return filteredData;
	}
	
	public ObservableList<Dates> getMasterData(){
		return masterData;
	}
	
	public void add(Dates... datess) {
		masterData.addAll(datess);
	}
	
	public void remove(Dates... datess) {
		masterData.removeAll(datess);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

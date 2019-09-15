package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.repository.*;
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
public class ContactDatesTableView extends TableView<ContactDates>{
	
	@Autowired
	private ContactDatesFX context;

	@PostConstruct
	public void init() {
		TableColumn<ContactDates, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<ContactDates, java.lang.Long> columnContactId = new TableColumn<>("#CONTACTID");
		columnContactId.setPrefWidth(100.0);
		setupCellValueFactory(columnContactId, e->new SimpleObjectProperty<>(e.getContactId()));
		getColumns().add(columnContactId);
		TableColumn<ContactDates, java.lang.String> columnName = new TableColumn<>("#NAME");
		columnName.setPrefWidth(200.0);
		setupCellValueFactory(columnName, e->new SimpleObjectProperty<>(e.getName()));
		getColumns().add(columnName);
		TableColumn<ContactDates, java.time.LocalDateTime> columnDate = new TableColumn<>("#DATE");
		columnDate.setPrefWidth(100.0);
		setupCellValueFactory(columnDate, e->new SimpleObjectProperty<>(e.getDate()));
		getColumns().add(columnDate);
		TableColumn<ContactDates, java.lang.Integer> columnStatus = new TableColumn<>("#STATUS");
		columnStatus.setPrefWidth(100.0);
		setupCellValueFactory(columnStatus, e->new SimpleObjectProperty<>(e.getStatus()));
		getColumns().add(columnStatus);
		TableColumn<ContactDates, java.time.LocalDateTime> columnCreatedOn = new TableColumn<>("#CREATEDON");
		columnCreatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnCreatedOn, e->new SimpleObjectProperty<>(e.getCreatedOn()));
		getColumns().add(columnCreatedOn);
		TableColumn<ContactDates, java.time.LocalDateTime> columnUpdatedOn = new TableColumn<>("#UPDATEDON");
		columnUpdatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnUpdatedOn, e->new SimpleObjectProperty<>(e.getUpdatedOn()));
		getColumns().add(columnUpdatedOn);
		
		setItems(context.getMasterData());
	}

	public FilteredList<ContactDates> getFilteredList(){
		return context.getFilteredMasterData();
	}
	
	public ObservableList<ContactDates> getMasterData(){
		return context.getMasterData();
	}
	
	public void add(ContactDates... contactDatess) {
		context.getMasterData().addAll(contactDatess);
	}
	
	public void remove(ContactDates... contactDatess) {
		context.getMasterData().removeAll(contactDatess);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

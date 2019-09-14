package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.repository.*;
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
public class PhonenumberTableView extends TableView<Phonenumber>{
	
	@Autowired
	private PhonenumberFX context;

	@PostConstruct
	public void init() {
		TableColumn<Phonenumber, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<Phonenumber, java.lang.Long> columnContactId = new TableColumn<>("#CONTACTID");
		columnContactId.setPrefWidth(100.0);
		setupCellValueFactory(columnContactId, e->new SimpleObjectProperty<>(e.getContactId()));
		getColumns().add(columnContactId);
		TableColumn<Phonenumber, java.lang.String> columnName = new TableColumn<>("#NAME");
		columnName.setPrefWidth(100.0);
		setupCellValueFactory(columnName, e->new SimpleObjectProperty<>(e.getName()));
		getColumns().add(columnName);
		TableColumn<Phonenumber, java.lang.String> columnNumber = new TableColumn<>("#NUMBER");
		columnNumber.setPrefWidth(100.0);
		setupCellValueFactory(columnNumber, e->new SimpleObjectProperty<>(e.getNumber()));
		getColumns().add(columnNumber);
		TableColumn<Phonenumber, java.lang.String> columnNumberType = new TableColumn<>("#NUMBERTYPE");
		columnNumberType.setPrefWidth(100.0);
		setupCellValueFactory(columnNumberType, e->new SimpleObjectProperty<>(e.getNumberType()));
		getColumns().add(columnNumberType);
		TableColumn<Phonenumber, java.lang.Integer> columnStatus = new TableColumn<>("#STATUS");
		columnStatus.setPrefWidth(100.0);
		setupCellValueFactory(columnStatus, e->new SimpleObjectProperty<>(e.getStatus()));
		getColumns().add(columnStatus);
		TableColumn<Phonenumber, java.time.LocalDateTime> columnCreatedOn = new TableColumn<>("#CREATEDON");
		columnCreatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnCreatedOn, e->new SimpleObjectProperty<>(e.getCreatedOn()));
		getColumns().add(columnCreatedOn);
		TableColumn<Phonenumber, java.time.LocalDateTime> columnUpdatedOn = new TableColumn<>("#UPDATEDON");
		columnUpdatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnUpdatedOn, e->new SimpleObjectProperty<>(e.getUpdatedOn()));
		getColumns().add(columnUpdatedOn);
		
		setItems(context.getMasterData());
	}

	public FilteredList<Phonenumber> getFilteredList(){
		return context.getFilteredMasterData();
	}
	
	public ObservableList<Phonenumber> getMasterData(){
		return context.getMasterData();
	}
	
	public void add(Phonenumber... phonenumbers) {
		context.getMasterData().addAll(phonenumbers);
	}
	
	public void remove(Phonenumber... phonenumbers) {
		context.getMasterData().removeAll(phonenumbers);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

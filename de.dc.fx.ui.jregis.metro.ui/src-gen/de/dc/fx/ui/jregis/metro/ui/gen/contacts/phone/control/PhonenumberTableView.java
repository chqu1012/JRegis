package de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.control;

import java.util.function.Function;
import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.phone.repository.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class PhonenumberTableView extends TableView<Phonenumber>{
	
	private ObservableList<Phonenumber> masterData = FXCollections.observableArrayList();
	private FilteredList<Phonenumber> filteredData = new FilteredList<>(masterData, p->true);
	
	private PhonenumberFX context;
	private PhonenumberRepository phonenumberRepository;
	
	@Inject
	public PhonenumberTableView(PhonenumberFX context, PhonenumberRepository phonenumberRepository) {
		this.context = context;
		this.phonenumberRepository = phonenumberRepository;
		
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
		
		context.getMasterData().addAll(phonenumberRepository.findAll());
		setItems(context.getFilteredMasterData());
	}

	public FilteredList<Phonenumber> getFilteredList(){
		return filteredData;
	}
	
	public ObservableList<Phonenumber> getMasterData(){
		return masterData;
	}
	
	public void add(Phonenumber... phonenumbers) {
		masterData.addAll(phonenumbers);
	}
	
	public void remove(Phonenumber... phonenumbers) {
		masterData.removeAll(phonenumbers);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

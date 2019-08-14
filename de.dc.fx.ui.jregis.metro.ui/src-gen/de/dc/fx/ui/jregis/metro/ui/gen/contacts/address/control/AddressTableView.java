package de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.control;

import java.util.function.Function;
import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.repository.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class AddressTableView extends TableView<Address>{
	
	private ObservableList<Address> masterData = FXCollections.observableArrayList();
	private FilteredList<Address> filteredData = new FilteredList<>(masterData, p->true);
	
	private AddressFX context;
	private AddressRepository addressRepository;
	
	@Inject
	public AddressTableView(AddressFX context, AddressRepository addressRepository) {
		this.context = context;
		this.addressRepository = addressRepository;
		
		TableColumn<Address, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<Address, java.lang.Long> columnContactId = new TableColumn<>("#CONTACTID");
		columnContactId.setPrefWidth(100.0);
		setupCellValueFactory(columnContactId, e->new SimpleObjectProperty<>(e.getContactId()));
		getColumns().add(columnContactId);
		TableColumn<Address, java.lang.String> columnAddressType = new TableColumn<>("#ADDRESSTYPE");
		columnAddressType.setPrefWidth(100.0);
		setupCellValueFactory(columnAddressType, e->new SimpleObjectProperty<>(e.getAddressType()));
		getColumns().add(columnAddressType);
		TableColumn<Address, java.lang.String> columnStreet = new TableColumn<>("#STREET");
		columnStreet.setPrefWidth(200.0);
		setupCellValueFactory(columnStreet, e->new SimpleObjectProperty<>(e.getStreet()));
		getColumns().add(columnStreet);
		TableColumn<Address, java.lang.String> columnCountry = new TableColumn<>("#COUNTRY");
		columnCountry.setPrefWidth(100.0);
		setupCellValueFactory(columnCountry, e->new SimpleObjectProperty<>(e.getCountry()));
		getColumns().add(columnCountry);
		TableColumn<Address, java.lang.String> columnState = new TableColumn<>("#STATE");
		columnState.setPrefWidth(100.0);
		setupCellValueFactory(columnState, e->new SimpleObjectProperty<>(e.getState()));
		getColumns().add(columnState);
		TableColumn<Address, java.lang.Integer> columnZipCode = new TableColumn<>("#ZIPCODE");
		columnZipCode.setPrefWidth(100.0);
		setupCellValueFactory(columnZipCode, e->new SimpleObjectProperty<>(e.getZipCode()));
		getColumns().add(columnZipCode);
		TableColumn<Address, java.lang.Integer> columnStatus = new TableColumn<>("#STATUS");
		columnStatus.setPrefWidth(100.0);
		setupCellValueFactory(columnStatus, e->new SimpleObjectProperty<>(e.getStatus()));
		getColumns().add(columnStatus);
		TableColumn<Address, java.time.LocalDateTime> columnCreatedOn = new TableColumn<>("#CREATEDON");
		columnCreatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnCreatedOn, e->new SimpleObjectProperty<>(e.getCreatedOn()));
		getColumns().add(columnCreatedOn);
		TableColumn<Address, java.time.LocalDateTime> columnUpdatedOn = new TableColumn<>("#UPDATEDON");
		columnUpdatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnUpdatedOn, e->new SimpleObjectProperty<>(e.getUpdatedOn()));
		getColumns().add(columnUpdatedOn);
		
		context.getMasterData().addAll(addressRepository.findAll());
		setItems(context.getFilteredMasterData());
	}

	public FilteredList<Address> getFilteredList(){
		return filteredData;
	}
	
	public ObservableList<Address> getMasterData(){
		return masterData;
	}
	
	public void add(Address... addresss) {
		masterData.addAll(addresss);
	}
	
	public void remove(Address... addresss) {
		masterData.removeAll(addresss);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

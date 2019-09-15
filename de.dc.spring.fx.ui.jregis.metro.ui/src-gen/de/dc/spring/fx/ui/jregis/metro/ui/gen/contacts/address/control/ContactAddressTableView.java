package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.repository.*;
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
public class ContactAddressTableView extends TableView<ContactAddress>{
	
	@Autowired
	private ContactAddressFX context;

	@PostConstruct
	public void init() {
		TableColumn<ContactAddress, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<ContactAddress, java.lang.Long> columnContactId = new TableColumn<>("#CONTACTID");
		columnContactId.setPrefWidth(100.0);
		setupCellValueFactory(columnContactId, e->new SimpleObjectProperty<>(e.getContactId()));
		getColumns().add(columnContactId);
		TableColumn<ContactAddress, java.lang.String> columnAddressType = new TableColumn<>("#ADDRESSTYPE");
		columnAddressType.setPrefWidth(100.0);
		setupCellValueFactory(columnAddressType, e->new SimpleObjectProperty<>(e.getAddressType()));
		getColumns().add(columnAddressType);
		TableColumn<ContactAddress, java.lang.String> columnStreet = new TableColumn<>("#STREET");
		columnStreet.setPrefWidth(200.0);
		setupCellValueFactory(columnStreet, e->new SimpleObjectProperty<>(e.getStreet()));
		getColumns().add(columnStreet);
		TableColumn<ContactAddress, java.lang.String> columnCountry = new TableColumn<>("#COUNTRY");
		columnCountry.setPrefWidth(100.0);
		setupCellValueFactory(columnCountry, e->new SimpleObjectProperty<>(e.getCountry()));
		getColumns().add(columnCountry);
		TableColumn<ContactAddress, java.lang.String> columnState = new TableColumn<>("#STATE");
		columnState.setPrefWidth(100.0);
		setupCellValueFactory(columnState, e->new SimpleObjectProperty<>(e.getState()));
		getColumns().add(columnState);
		TableColumn<ContactAddress, java.lang.Integer> columnZipCode = new TableColumn<>("#ZIPCODE");
		columnZipCode.setPrefWidth(100.0);
		setupCellValueFactory(columnZipCode, e->new SimpleObjectProperty<>(e.getZipCode()));
		getColumns().add(columnZipCode);
		TableColumn<ContactAddress, java.lang.Integer> columnStatus = new TableColumn<>("#STATUS");
		columnStatus.setPrefWidth(100.0);
		setupCellValueFactory(columnStatus, e->new SimpleObjectProperty<>(e.getStatus()));
		getColumns().add(columnStatus);
		TableColumn<ContactAddress, java.time.LocalDateTime> columnCreatedOn = new TableColumn<>("#CREATEDON");
		columnCreatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnCreatedOn, e->new SimpleObjectProperty<>(e.getCreatedOn()));
		getColumns().add(columnCreatedOn);
		TableColumn<ContactAddress, java.time.LocalDateTime> columnUpdatedOn = new TableColumn<>("#UPDATEDON");
		columnUpdatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnUpdatedOn, e->new SimpleObjectProperty<>(e.getUpdatedOn()));
		getColumns().add(columnUpdatedOn);
		
		setItems(context.getMasterData());
	}

	public FilteredList<ContactAddress> getFilteredList(){
		return context.getFilteredMasterData();
	}
	
	public ObservableList<ContactAddress> getMasterData(){
		return context.getMasterData();
	}
	
	public void add(ContactAddress... contactAddresss) {
		context.getMasterData().addAll(contactAddresss);
	}
	
	public void remove(ContactAddress... contactAddresss) {
		context.getMasterData().removeAll(contactAddresss);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

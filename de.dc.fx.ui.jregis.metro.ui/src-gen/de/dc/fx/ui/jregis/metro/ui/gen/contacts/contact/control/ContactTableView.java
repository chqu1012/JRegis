package de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.control;

import java.util.function.Function;
import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.repository.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class ContactTableView extends TableView<Contact>{
	
	private ObservableList<Contact> masterData = FXCollections.observableArrayList();
	private FilteredList<Contact> filteredData = new FilteredList<>(masterData, p->true);
	
	private ContactFX context;
	private ContactRepository contactRepository;
	
	@Inject
	public ContactTableView(ContactFX context, ContactRepository contactRepository) {
		this.context = context;
		this.contactRepository = contactRepository;
		
		TableColumn<Contact, java.lang.String> columnFirstname = new TableColumn<>("#FIRSTNAME");
		columnFirstname.setPrefWidth(100.0);
		setupCellValueFactory(columnFirstname, e->new SimpleObjectProperty<>(e.getFirstname()));
		getColumns().add(columnFirstname);
		TableColumn<Contact, java.lang.String> columnLastname = new TableColumn<>("#LASTNAME");
		columnLastname.setPrefWidth(100.0);
		setupCellValueFactory(columnLastname, e->new SimpleObjectProperty<>(e.getLastname()));
		getColumns().add(columnLastname);
		TableColumn<Contact, java.lang.String> columnUsername = new TableColumn<>("#USERNAME");
		columnUsername.setPrefWidth(100.0);
		setupCellValueFactory(columnUsername, e->new SimpleObjectProperty<>(e.getUsername()));
		getColumns().add(columnUsername);
		TableColumn<Contact, java.lang.Long> columnContactImageId = new TableColumn<>("#CONTACTIMAGEID");
		columnContactImageId.setPrefWidth(100.0);
		setupCellValueFactory(columnContactImageId, e->new SimpleObjectProperty<>(e.getContactImageId()));
		getColumns().add(columnContactImageId);
		
		context.getMasterData().addAll(contactRepository.findAll());
		setItems(context.getFilteredMasterData());
	}

	public FilteredList<Contact> getFilteredList(){
		return filteredData;
	}
	
	public ObservableList<Contact> getMasterData(){
		return masterData;
	}
	
	public void add(Contact... contacts) {
		masterData.addAll(contacts);
	}
	
	public void remove(Contact... contacts) {
		masterData.removeAll(contacts);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

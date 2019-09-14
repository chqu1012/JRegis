package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.contact.repository.*;
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
public class ContactTableView extends TableView<Contact>{
	
	@Autowired
	private ContactFX context;

	@PostConstruct
	public void init() {
		TableColumn<Contact, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
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
		TableColumn<Contact, java.lang.Long> columnContactGroupId = new TableColumn<>("#CONTACTGROUPID");
		columnContactGroupId.setPrefWidth(100.0);
		setupCellValueFactory(columnContactGroupId, e->new SimpleObjectProperty<>(e.getContactGroupId()));
		getColumns().add(columnContactGroupId);
		TableColumn<Contact, java.lang.Integer> columnStatus = new TableColumn<>("#STATUS");
		columnStatus.setPrefWidth(100.0);
		setupCellValueFactory(columnStatus, e->new SimpleObjectProperty<>(e.getStatus()));
		getColumns().add(columnStatus);
		TableColumn<Contact, java.time.LocalDateTime> columnCreatedOn = new TableColumn<>("#CREATEDON");
		columnCreatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnCreatedOn, e->new SimpleObjectProperty<>(e.getCreatedOn()));
		getColumns().add(columnCreatedOn);
		TableColumn<Contact, java.time.LocalDateTime> columnUpdatedOn = new TableColumn<>("#UPDATEDON");
		columnUpdatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnUpdatedOn, e->new SimpleObjectProperty<>(e.getUpdatedOn()));
		getColumns().add(columnUpdatedOn);
		
		setItems(context.getMasterData());
	}

	public FilteredList<Contact> getFilteredList(){
		return context.getFilteredMasterData();
	}
	
	public ObservableList<Contact> getMasterData(){
		return context.getMasterData();
	}
	
	public void add(Contact... contacts) {
		context.getMasterData().addAll(contacts);
	}
	
	public void remove(Contact... contacts) {
		context.getMasterData().removeAll(contacts);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

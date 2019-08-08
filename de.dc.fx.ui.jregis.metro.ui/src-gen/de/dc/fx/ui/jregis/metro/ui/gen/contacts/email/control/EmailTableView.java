package de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.control;

import java.util.function.Function;
import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.repository.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class EmailTableView extends TableView<Email>{
	
	private ObservableList<Email> masterData = FXCollections.observableArrayList();
	private FilteredList<Email> filteredData = new FilteredList<>(masterData, p->true);
	
	private EmailFX context;
	private EmailRepository emailRepository;
	
	@Inject
	public EmailTableView(EmailFX context, EmailRepository emailRepository) {
		this.context = context;
		this.emailRepository = emailRepository;
		
		TableColumn<Email, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<Email, java.lang.Long> columnContactId = new TableColumn<>("#CONTACTID");
		columnContactId.setPrefWidth(100.0);
		setupCellValueFactory(columnContactId, e->new SimpleObjectProperty<>(e.getContactId()));
		getColumns().add(columnContactId);
		TableColumn<Email, java.lang.String> columnName = new TableColumn<>("#NAME");
		columnName.setPrefWidth(100.0);
		setupCellValueFactory(columnName, e->new SimpleObjectProperty<>(e.getName()));
		getColumns().add(columnName);
		TableColumn<Email, java.lang.String> columnAddress = new TableColumn<>("#ADDRESS");
		columnAddress.setPrefWidth(100.0);
		setupCellValueFactory(columnAddress, e->new SimpleObjectProperty<>(e.getAddress()));
		getColumns().add(columnAddress);
		
		context.getMasterData().addAll(emailRepository.findAll());
		setItems(context.getFilteredMasterData());
	}

	public FilteredList<Email> getFilteredList(){
		return filteredData;
	}
	
	public ObservableList<Email> getMasterData(){
		return masterData;
	}
	
	public void add(Email... emails) {
		masterData.addAll(emails);
	}
	
	public void remove(Email... emails) {
		masterData.removeAll(emails);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

package de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.control;

import java.util.function.Function;
import com.google.inject.Inject;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.model.*;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.image.repository.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class ContactImageTableView extends TableView<ContactImage>{
	
	private ObservableList<ContactImage> masterData = FXCollections.observableArrayList();
	private FilteredList<ContactImage> filteredData = new FilteredList<>(masterData, p->true);
	
	private ContactImageFX context;
	private ContactImageRepository contactImageRepository;
	
	@Inject
	public ContactImageTableView(ContactImageFX context, ContactImageRepository contactImageRepository) {
		this.context = context;
		this.contactImageRepository = contactImageRepository;
		
		TableColumn<ContactImage, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<ContactImage, java.lang.String> columnName = new TableColumn<>("#NAME");
		columnName.setPrefWidth(100.0);
		setupCellValueFactory(columnName, e->new SimpleObjectProperty<>(e.getName()));
		getColumns().add(columnName);
		TableColumn<ContactImage, java.lang.Integer> columnStatus = new TableColumn<>("#STATUS");
		columnStatus.setPrefWidth(100.0);
		setupCellValueFactory(columnStatus, e->new SimpleObjectProperty<>(e.getStatus()));
		getColumns().add(columnStatus);
		TableColumn<ContactImage, java.time.LocalDateTime> columnCreatedOn = new TableColumn<>("#CREATEDON");
		columnCreatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnCreatedOn, e->new SimpleObjectProperty<>(e.getCreatedOn()));
		getColumns().add(columnCreatedOn);
		TableColumn<ContactImage, java.time.LocalDateTime> columnUpdatedOn = new TableColumn<>("#UPDATEDON");
		columnUpdatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnUpdatedOn, e->new SimpleObjectProperty<>(e.getUpdatedOn()));
		getColumns().add(columnUpdatedOn);
		
		context.getMasterData().addAll(contactImageRepository.findAll());
		setItems(context.getFilteredMasterData());
	}

	public FilteredList<ContactImage> getFilteredList(){
		return filteredData;
	}
	
	public ObservableList<ContactImage> getMasterData(){
		return masterData;
	}
	
	public void add(ContactImage... contactImages) {
		masterData.addAll(contactImages);
	}
	
	public void remove(ContactImage... contactImages) {
		masterData.removeAll(contactImages);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

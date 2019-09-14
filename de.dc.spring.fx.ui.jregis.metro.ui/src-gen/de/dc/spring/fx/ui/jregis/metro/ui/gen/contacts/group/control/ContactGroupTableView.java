package de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.group.repository.*;
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
public class ContactGroupTableView extends TableView<ContactGroup>{
	
	@Autowired
	private ContactGroupFX context;

	@PostConstruct
	public void init() {
		TableColumn<ContactGroup, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<ContactGroup, java.lang.String> columnName = new TableColumn<>("#NAME");
		columnName.setPrefWidth(100.0);
		setupCellValueFactory(columnName, e->new SimpleObjectProperty<>(e.getName()));
		getColumns().add(columnName);
		TableColumn<ContactGroup, java.lang.Integer> columnStatus = new TableColumn<>("#STATUS");
		columnStatus.setPrefWidth(100.0);
		setupCellValueFactory(columnStatus, e->new SimpleObjectProperty<>(e.getStatus()));
		getColumns().add(columnStatus);
		TableColumn<ContactGroup, java.lang.String> columnColor = new TableColumn<>("#COLOR");
		columnColor.setPrefWidth(100.0);
		setupCellValueFactory(columnColor, e->new SimpleObjectProperty<>(e.getColor()));
		getColumns().add(columnColor);
		TableColumn<ContactGroup, java.lang.String> columnHoverColor = new TableColumn<>("#HOVERCOLOR");
		columnHoverColor.setPrefWidth(100.0);
		setupCellValueFactory(columnHoverColor, e->new SimpleObjectProperty<>(e.getHoverColor()));
		getColumns().add(columnHoverColor);
		TableColumn<ContactGroup, java.time.LocalDateTime> columnCreatedOn = new TableColumn<>("#CREATEDON");
		columnCreatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnCreatedOn, e->new SimpleObjectProperty<>(e.getCreatedOn()));
		getColumns().add(columnCreatedOn);
		TableColumn<ContactGroup, java.time.LocalDateTime> columnUpdatedOn = new TableColumn<>("#UPDATEDON");
		columnUpdatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnUpdatedOn, e->new SimpleObjectProperty<>(e.getUpdatedOn()));
		getColumns().add(columnUpdatedOn);
		
		setItems(context.getMasterData());
	}

	public FilteredList<ContactGroup> getFilteredList(){
		return context.getFilteredMasterData();
	}
	
	public ObservableList<ContactGroup> getMasterData(){
		return context.getMasterData();
	}
	
	public void add(ContactGroup... contactGroups) {
		context.getMasterData().addAll(contactGroups);
	}
	
	public void remove(ContactGroup... contactGroups) {
		context.getMasterData().removeAll(contactGroups);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

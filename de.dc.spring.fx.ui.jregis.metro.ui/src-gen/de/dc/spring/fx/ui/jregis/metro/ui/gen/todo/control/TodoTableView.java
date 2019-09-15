package de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.repository.*;
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
public class TodoTableView extends TableView<Todo>{
	
	@Autowired
	private TodoFX context;

	@PostConstruct
	public void init() {
		TableColumn<Todo, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<Todo, java.lang.String> columnName = new TableColumn<>("#NAME");
		columnName.setPrefWidth(100.0);
		setupCellValueFactory(columnName, e->new SimpleObjectProperty<>(e.getName()));
		getColumns().add(columnName);
		TableColumn<Todo, java.lang.Integer> columnStatus = new TableColumn<>("#STATUS");
		columnStatus.setPrefWidth(100.0);
		setupCellValueFactory(columnStatus, e->new SimpleObjectProperty<>(e.getStatus()));
		getColumns().add(columnStatus);
		TableColumn<Todo, java.time.LocalDateTime> columnCreatedOn = new TableColumn<>("#CREATEDON");
		columnCreatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnCreatedOn, e->new SimpleObjectProperty<>(e.getCreatedOn()));
		getColumns().add(columnCreatedOn);
		TableColumn<Todo, java.time.LocalDateTime> columnUpdatedOn = new TableColumn<>("#UPDATEDON");
		columnUpdatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnUpdatedOn, e->new SimpleObjectProperty<>(e.getUpdatedOn()));
		getColumns().add(columnUpdatedOn);
		
		setItems(context.getMasterData());
	}

	public FilteredList<Todo> getFilteredList(){
		return context.getFilteredMasterData();
	}
	
	public ObservableList<Todo> getMasterData(){
		return context.getMasterData();
	}
	
	public void add(Todo... todos) {
		context.getMasterData().addAll(todos);
	}
	
	public void remove(Todo... todos) {
		context.getMasterData().removeAll(todos);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

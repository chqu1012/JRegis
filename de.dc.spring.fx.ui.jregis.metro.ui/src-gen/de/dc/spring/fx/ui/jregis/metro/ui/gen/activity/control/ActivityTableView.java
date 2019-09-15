package de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.model.*;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.repository.*;
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
public class ActivityTableView extends TableView<Activity>{
	
	@Autowired
	private ActivityFX context;

	@PostConstruct
	public void init() {
		TableColumn<Activity, Long> columnId = new TableColumn<>("#ID");
		columnId.setPrefWidth(100);
		setupCellValueFactory(columnId, e->new SimpleObjectProperty<>(e.getId()));
		getColumns().add(columnId);
		TableColumn<Activity, java.lang.String> columnTitle = new TableColumn<>("#TITLE");
		columnTitle.setPrefWidth(100.0);
		setupCellValueFactory(columnTitle, e->new SimpleObjectProperty<>(e.getTitle()));
		getColumns().add(columnTitle);
		TableColumn<Activity, java.lang.Integer> columnStatus = new TableColumn<>("#STATUS");
		columnStatus.setPrefWidth(100.0);
		setupCellValueFactory(columnStatus, e->new SimpleObjectProperty<>(e.getStatus()));
		getColumns().add(columnStatus);
		TableColumn<Activity, java.lang.Long> columnUserId = new TableColumn<>("#USERID");
		columnUserId.setPrefWidth(100.0);
		setupCellValueFactory(columnUserId, e->new SimpleObjectProperty<>(e.getUserId()));
		getColumns().add(columnUserId);
		TableColumn<Activity, java.lang.String> columnDescription = new TableColumn<>("#DESCRIPTION");
		columnDescription.setPrefWidth(100.0);
		setupCellValueFactory(columnDescription, e->new SimpleObjectProperty<>(e.getDescription()));
		getColumns().add(columnDescription);
		TableColumn<Activity, java.time.LocalDateTime> columnCreatedOn = new TableColumn<>("#CREATEDON");
		columnCreatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnCreatedOn, e->new SimpleObjectProperty<>(e.getCreatedOn()));
		getColumns().add(columnCreatedOn);
		TableColumn<Activity, java.time.LocalDateTime> columnUpdatedOn = new TableColumn<>("#UPDATEDON");
		columnUpdatedOn.setPrefWidth(100.0);
		setupCellValueFactory(columnUpdatedOn, e->new SimpleObjectProperty<>(e.getUpdatedOn()));
		getColumns().add(columnUpdatedOn);
		
		setItems(context.getMasterData());
	}

	public FilteredList<Activity> getFilteredList(){
		return context.getFilteredMasterData();
	}
	
	public ObservableList<Activity> getMasterData(){
		return context.getMasterData();
	}
	
	public void add(Activity... activitys) {
		context.getMasterData().addAll(activitys);
	}
	
	public void remove(Activity... activitys) {
		context.getMasterData().removeAll(activitys);
	}

	private <T, U> void setupCellValueFactory(TableColumn<T, U> column, Function<T, ObservableValue<U>> mapper) {
		column.setCellValueFactory((CellDataFeatures<T, U> c) -> mapper.apply(c.getValue()));
	}
}

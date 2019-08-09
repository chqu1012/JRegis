package de.dc.fx.ui.jregis.metro.ui.control.calendar;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import jfxtras.scene.control.LocalDateTimeTextField;
import jfxtras.scene.control.agenda.Agenda;
import jfxtras.scene.control.agenda.AgendaSkinSwitcher;

public class CalendarPage extends StackPane {

	public CalendarPage() {
		Agenda agenda = new Agenda();
		AgendaSkinSwitcher switcher = new AgendaSkinSwitcher(agenda);
		LocalDateTimeTextField lLocalDateTimeTextField = new LocalDateTimeTextField();
				
		agenda.setAllowResize(true);
		agenda.setAllowDragging(true);
		lLocalDateTimeTextField.localDateTimeProperty().bindBidirectional(agenda.displayedLocalDateTime());
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(switcher, lLocalDateTimeTextField,agenda);
		getChildren().add(vbox);
	}
}

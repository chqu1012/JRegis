package de.dc.fx.ui.jregis.metro.ui.control.calendar;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.model.XAppointment;
import de.dc.fx.ui.jregis.metro.ui.gen.calendar.appointment.repository.XAppointmentRepository;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import jfxtras.scene.control.LocalDateTimeTextField;
import jfxtras.scene.control.agenda.Agenda;
import jfxtras.scene.control.agenda.Agenda.Appointment;
import jfxtras.scene.control.agenda.AgendaSkinSwitcher;

public class CalendarPage extends BaseCalendarPage {

	private Logger log = Logger.getLogger(CalendarPage.class.getSimpleName());

	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/calendar/CalendarPage.fxml";

	private Agenda agenda = new Agenda();
	
	public CalendarPage() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			log.log(Level.SEVERE, "Failed to load fxml " + FXML, exception);
		}

		AgendaSkinSwitcher switcher = new AgendaSkinSwitcher(agenda);
		LocalDateTimeTextField lLocalDateTimeTextField = new LocalDateTimeTextField();
				
		agenda.setAllowResize(true);
		agenda.setAllowDragging(true);
		lLocalDateTimeTextField.localDateTimeProperty().bindBidirectional(agenda.displayedLocalDateTime());
		
		VBox vbox = new VBox();
		vbox.setSpacing(10d);
		vbox.getChildren().addAll(switcher, lLocalDateTimeTextField,agenda);
		AnchorPane.setBottomAnchor(vbox, 10d);
		AnchorPane.setTopAnchor(vbox, 10d);
		AnchorPane.setLeftAnchor(vbox, 10d);
		AnchorPane.setRightAnchor(vbox, 10d);
		paneMainContent.getChildren().add(vbox);
		
		initData();
	}
	
	public void initData() {
		// setup appointment groups
        final Map<String, Agenda.AppointmentGroup> lAppointmentGroupMap = new TreeMap<>();
        for (Agenda.AppointmentGroup lAppointmentGroup : agenda.appointmentGroups()) {
        	lAppointmentGroupMap.put(lAppointmentGroup.getDescription(), lAppointmentGroup);
        }

        // accept new appointments
		agenda.newAppointmentCallbackProperty().set(dateTimeRange -> new Agenda.AppointmentImplLocal()
		.withStartLocalDateTime( dateTimeRange.getStartLocalDateTime() )
		.withEndLocalDateTime( dateTimeRange.getEndLocalDateTime() )
		.withSummary("new")
		.withDescription("new")
		.withAppointmentGroup(lAppointmentGroupMap.get("group01")));

		List<XAppointment> appointments = JRegisPlatform.getInstance(XAppointmentRepository.class).findAll();
		
		for (XAppointment xa : appointments) {
			Appointment appointment = new Agenda.AppointmentImplLocal()
					.withStartLocalDateTime(xa.getStart())
					.withEndLocalDateTime(xa.getEnd())
					.withSummary(xa.getSummary())
					.withDescription(xa.getTopic())
					.withAppointmentGroup(lAppointmentGroupMap.get("group07"));
			agenda.appointments().addAll(appointment);
		}
	}
}

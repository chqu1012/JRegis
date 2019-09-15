package de.dc.spring.fx.ui.jregis.metro.ui.calendar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.eventbus.Subscribe;

import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.calendar.appointment.model.XAppointment;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.calendar.appointment.repository.XAppointmentRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.model.ContactDates;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import jfxtras.scene.control.LocalDateTimeTextField;
import jfxtras.scene.control.agenda.Agenda;
import jfxtras.scene.control.agenda.Agenda.Appointment;
import jfxtras.scene.control.agenda.AgendaSkinSwitcher;

@Controller
public class CalendarPage extends BaseCalendarPage {

	@Autowired XAppointmentRepository appointmentRepository;
	
	private Agenda agenda = new Agenda();
	
	private Map<Object, Appointment> dates = new HashMap<>();
	private Map<String, Agenda.AppointmentGroup> lAppointmentGroupMap = new TreeMap<>();
	
	public void initialize() {
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
		
		EventBroker.getDefault().register(this);
	}
	
	@Subscribe
	public void addDateViaEventBroker(EventContext<ContactDates> context) {
		if (context.getEventId().equals("/open/contact/date")) {
			ContactDates input = context.getInput();
			if (dates.get(input)==null) {
				Appointment appointment = new Agenda.AppointmentImplLocal()
						.withStartLocalDateTime(input.getDate())
						.withEndLocalDateTime(input.getDate().plusHours(1))
						.withSummary(input.getName())
						.withDescription(input.getName())
						.withAppointmentGroup(lAppointmentGroupMap.get("group07"));
				agenda.appointments().addAll(appointment);
				dates.put(input, appointment);
			}
			agenda.setDisplayedLocalDateTime(input.getDate());
			agenda.selectedAppointments().add(dates.get(input));
			root.toFront();
		}
	}
	
	
	public void initData() {
		// setup appointment groups
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

		List<XAppointment> appointments = appointmentRepository.findAll();
		
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

package de.dc.fx.ui.jregis.metro.ui.model.contact;

import java.time.LocalDateTime;

import de.dc.fx.ui.jregis.metro.ui.model.IdElement;

public class Appointment extends IdElement{

	public Appointment(String name, LocalDateTime createdOn, LocalDateTime updatedOn) {
		super(name, createdOn, updatedOn);
	}
}

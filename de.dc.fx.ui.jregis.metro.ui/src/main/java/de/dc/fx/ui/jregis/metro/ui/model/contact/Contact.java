package de.dc.fx.ui.jregis.metro.ui.model.contact;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import de.dc.fx.ui.jregis.metro.ui.model.IdElement;

public class Contact extends IdElement{

	private Integer imageId;
	private List<Email> emails = new ArrayList<>();
	private List<PhoneNumber> phonenumbers = new ArrayList<>();
	private List<Address> addressList = new ArrayList<>();
	private List<Appointment> dates = new ArrayList<>();
	
	public Contact(String name, LocalDateTime createdOn, LocalDateTime updatedOn) {
		super(name, createdOn, updatedOn);
	}

}

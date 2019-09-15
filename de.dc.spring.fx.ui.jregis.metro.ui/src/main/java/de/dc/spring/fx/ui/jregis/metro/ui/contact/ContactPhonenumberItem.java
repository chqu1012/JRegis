package de.dc.spring.fx.ui.jregis.metro.ui.contact;

import java.time.LocalDateTime;

import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.model.ContactPhonenumber;
import javafx.event.ActionEvent;

public class ContactPhonenumberItem extends BaseContactItem<ContactPhonenumber> {

	public ContactPhonenumberItem(ContactPhonenumber item) {
		super(item);
	}

	@Override
	protected void onButtonAccept(ActionEvent event) {
		item.setNumber(textValue.getText());
		item.setNumberType(textType.getText());
		item.setCreatedOn(LocalDateTime.now());
		item.setUpdatedOn(LocalDateTime.now());
		item.setStatus(0);
		if (item.getId()!=null) {
			EventBroker.getDefault().post(new EventContext<>("/create/contact/phone", item));
		}else {
			EventBroker.getDefault().post(new EventContext<>("/update/contact/phone", item));
		}
		panePreview.toFront();				
	}

	@Override
	protected void deleteItem(ContactPhonenumber item) {
		EventBroker.getDefault().post(new EventContext<>("/delete/contact/phone", item));
	}

	@Override
	protected Long getItemId(ContactPhonenumber item) {
		return item.getId();
	}

	@Override
	protected String getValue() {
		return item.getNumber();
	}

	@Override
	protected String getType() {
		return item.getNumberType();
	}

	@Override
	protected String getImageName() {
		if (item==null || item.getNumberType()==null) {
			return "icons8-telefon-52.png";
		}
		if (item.getNumberType().equalsIgnoreCase("mobile")) {
			return "icons8-handy-48.png";
		}
		return "icons8-telefon-52.png";
	}

}

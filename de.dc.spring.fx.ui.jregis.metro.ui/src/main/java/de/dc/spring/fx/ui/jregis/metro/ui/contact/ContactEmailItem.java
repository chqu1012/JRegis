package de.dc.spring.fx.ui.jregis.metro.ui.contact;

import java.time.LocalDateTime;

import org.controlsfx.control.Notifications;

import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class ContactEmailItem extends BaseContactItem<Email> {

	public ContactEmailItem(Email item) {
		super(item);
	}

	@Override
	protected void onButtonAccept(ActionEvent event) {
		item.setAddress(textValue.getText());
		item.setName(textType.getText());
		item.setCreatedOn(LocalDateTime.now());
		item.setUpdatedOn(LocalDateTime.now());
		item.setStatus(0);
		if (item.getId()!=null) {
			EventBroker.getDefault().post(new EventContext<>("/update/existing/contact/email", item));
		}else {
			EventBroker.getDefault().post(new EventContext<>("/create/existing/contact/email", item));
		}
		panePreview.toFront();		
	}

	@Override
	protected void deleteItem(Email item) {
		EventBroker.getDefault().post(new EventContext<>("/delete/contact/email", item));
	}

	@Override
	protected Long getItemId(Email item) {
		return item.getId();
	}

	@Override
	protected String getValue() {
		if (item==null) {
			return "";
		}
		return item.getAddress();
	}

	@Override
	protected String getType() {
		if (item==null) {
			return "";
		}
		return item.getName();
	}

	@Override
	protected String getImageName() {
		return "icons8-post-48.png";
	}
}

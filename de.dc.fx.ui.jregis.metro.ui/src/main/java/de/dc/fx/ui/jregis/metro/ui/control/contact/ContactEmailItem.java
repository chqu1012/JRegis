package de.dc.fx.ui.jregis.metro.ui.control.contact;

import org.controlsfx.control.Notifications;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.model.Email;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.email.repository.EmailRepository;
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
		if (item.getId()!=null) {
			JRegisPlatform.getInstance(EmailRepository.class).update(item);
		}else {
			long itemId = JRegisPlatform.getInstance(EmailRepository.class).save(item);
			item.setId(itemId);
		}
		Platform.runLater(() -> Notifications.create().darkStyle().title("Email added!").text("Created "+textValue.getText()+"!").show());
		panePreview.toFront();		
	}

	@Override
	protected void deleteItem(Email item) {
		JRegisPlatform.getInstance(EmailRepository.class).delete(item);
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

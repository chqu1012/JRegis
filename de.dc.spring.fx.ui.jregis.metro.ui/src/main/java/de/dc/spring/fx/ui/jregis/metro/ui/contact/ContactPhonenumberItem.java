package de.dc.spring.fx.ui.jregis.metro.ui.contact;

import java.time.LocalDateTime;

import org.controlsfx.control.Notifications;

import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.phone.model.Phonenumber;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class ContactPhonenumberItem extends BaseContactItem<Phonenumber> {

	public ContactPhonenumberItem(Phonenumber item) {
		super(item);
	}

	@Override
	protected void onButtonAccept(ActionEvent event) {
		item.setNumber(textValue.getText());
		item.setNumberType(textType.getText());
		item.setCreatedOn(LocalDateTime.now());
		item.setUpdatedOn(LocalDateTime.now());
		item.setStatus(0);
//		if (item.getId()!=null) {
//			JRegisPlatform.getInstance(PhonenumberRepository.class).update(item);
//		}else {
//			long itemId = JRegisPlatform.getInstance(PhonenumberRepository.class).save(item);
//			item.setId(itemId);
//		}
		Platform.runLater(() -> Notifications.create().darkStyle().title("Phonenumber added!").text("Created "+textValue.getText()+"!").show());
		panePreview.toFront();				
	}

	@Override
	protected void deleteItem(Phonenumber item) {
//		JRegisPlatform.getInstance(PhonenumberRepository.class).delete(item);
	}

	@Override
	protected Long getItemId(Phonenumber item) {
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

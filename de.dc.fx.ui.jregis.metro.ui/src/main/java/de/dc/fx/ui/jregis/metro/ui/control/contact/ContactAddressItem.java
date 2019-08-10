package de.dc.fx.ui.jregis.metro.ui.control.contact;

import org.controlsfx.control.Notifications;

import de.dc.fx.ui.jregis.metro.ui.di.JRegisPlatform;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.model.Address;
import de.dc.fx.ui.jregis.metro.ui.gen.contacts.address.repository.AddressRepository;
import javafx.application.Platform;
import javafx.event.ActionEvent;

public class ContactAddressItem extends BaseContactItem<Address>{

	public ContactAddressItem(Address t) {
		super(t);
	}

	@Override
	protected void onButtonAccept(ActionEvent event) {
		if (item.getId()!=null) {
			JRegisPlatform.getInstance(AddressRepository.class).update(item);
		}else {
			long itemId = JRegisPlatform.getInstance(AddressRepository.class).save(item);
			item.setId(itemId);
		}
		Platform.runLater(() -> Notifications.create().darkStyle().title(item.getClass().getSimpleName()+" added!").text("Created "+textValue.getText()+"!").show());
		panePreview.toFront();		
	}

	@Override
	protected String getValue() {
		return String.format("%s, %s %s, %s", item.getStreet(), item.getZipCode(), item.getState(), item.getCountry());
	}

	@Override
	protected String getType() {
		return item.getAddressType();
	}

	@Override
	protected String getImageName() {
		return "icons8-adresse-48.png";
	}

	@Override
	protected void deleteItem(Address item) {
		JRegisPlatform.getInstance(AddressRepository.class).delete(item);
	}

	@Override
	protected Long getItemId(Address item) {
		return item.getId();
	}
}

package de.dc.spring.fx.ui.jregis.metro.ui.contact;

import java.time.LocalDateTime;

import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.address.model.ContactAddress;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ContactAddressItem extends BaseContactItem<ContactAddress>{

	private TextField textCountry;
	private TextField textState;
	private TextField textZipCode;
	
	public ContactAddressItem(ContactAddress t) {
		super(t);
	}

	@Override
	protected void initializeEditFields() {
		labelType.textProperty().bindBidirectional(textType.textProperty());
		
		textType.setPromptText("Address Type");
		textValue.setPromptText("Street");
		textValue.textProperty().unbind();
		
		textCountry = new TextField();
		textCountry.setPromptText("Country");
		panelEdit.getChildren().add(2, textCountry);
		
		textState = new TextField();
		textState.setPromptText("State");
		panelEdit.getChildren().add(3, textState);
		
		textZipCode = new TextField();
		textZipCode.setPromptText("Zip Code");
		panelEdit.getChildren().add(4, textZipCode);

		getValue();
		
		labelValue.textProperty().bind(Bindings.format("%s, %s %s, %s", textType.textProperty(), textValue.textProperty(), textCountry.textProperty(), textState.textProperty(), textZipCode.textProperty()));
		
		BooleanBinding isValueEmptyProperty = textValue.textProperty().isEmpty();
		BooleanBinding isTypeEmptyProperty = textType.textProperty().isEmpty();
		BooleanBinding isCountryEmptyProperty = textCountry.textProperty().isEmpty();
		BooleanBinding isStateEmptyProperty = textState.textProperty().isEmpty();
		BooleanBinding isZipCodeEmptyProperty = textZipCode.textProperty().isEmpty();
		buttonAccept.disableProperty().unbind();
		buttonAccept.disableProperty().bind(isValueEmptyProperty.or(isTypeEmptyProperty).or(isCountryEmptyProperty).or(isStateEmptyProperty).or(isZipCodeEmptyProperty));
		
	}
	
	@Override
	protected void onButtonAccept(ActionEvent event) {
		item.setAddressType(textType.getText());
		item.setStreet(textValue.getText());
		item.setCountry(textCountry.getText());
		item.setState(textState.getText());
		item.setZipCode(Integer.parseInt(textZipCode.getText()));
		item.setCreatedOn(LocalDateTime.now());
		item.setUpdatedOn(LocalDateTime.now());
		item.setStatus(0);
		if (item.getId()!=null) {
			EventBroker.getDefault().post(new EventContext<>("/update/contact/address", item));
		}else {
			EventBroker.getDefault().post(new EventContext<>("/create/contact/address", item));
		}
		panePreview.toFront();		
	}

	@Override
	protected String getValue() {
		if (item==null) {
			return "";
		}
		textType.setText(item.getAddressType()==null? "" : item.getAddressType());
		textState.setText(item.getStreet()==null? "" : item.getState());
		textCountry.setText(item.getCountry()==null?"" : item.getCountry());
		textZipCode.setText(item.getZipCode()==null ? "" : String.valueOf(item.getZipCode()));
		textValue.setText(item.getStreet()==null?"" : item.getStreet());
		return String.format("%s, %s %s, %s", item.getStreet(), item.getZipCode(), item.getState(), item.getCountry());
	}

	@Override
	protected void onImageViewEditItem(MouseEvent event) {
		textType.setText(labelType.getText());
		textState.setText(item.getStreet()==null? "" : item.getState());
		textCountry.setText(item.getCountry()==null?"" : item.getCountry());
		textZipCode.setText(item.getZipCode()==null ? "" : String.valueOf(item.getZipCode()));
		textValue.setText(item.getStreet()==null?"" : item.getStreet());
		super.onImageViewEditItem(event);
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
	protected void deleteItem(ContactAddress item) {
		EventBroker.getDefault().post(new EventContext<>("/delete/contact/address", item));
	}

	@Override
	protected Long getItemId(ContactAddress item) {
		return item.getId();
	}
}

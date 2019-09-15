package de.dc.spring.fx.ui.jregis.metro.ui.contact;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import de.dc.spring.fx.ui.jregis.metro.ui.events.EventBroker;
import de.dc.spring.fx.ui.jregis.metro.ui.events.EventContext;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.contacts.dates.model.Dates;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.StringConverter;
import jfxtras.scene.control.LocalDateTimeTextField;

public class ContactDatesItem extends BaseContactItem<Dates>{

	private static final String DATE_PATTERN = "dd.MM.yyyy HH:mm";
	
	private LocalDateTimeTextField textDate;
	
	private DateTimeFormatter formatter;
	
	public ContactDatesItem(Dates item) {
		super(item);
	}

	@Override
	protected void initializeEditFields() {
		labelType.textProperty().bindBidirectional(textType.textProperty());
		labelType.setText(getType()==null? "" : getType());
		
		formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

		textDate = new LocalDateTimeTextField(item.getDate()==null? LocalDateTime.now() : item.getDate());
		HBox.setMargin(textDate, new Insets(7));
		HBox.setHgrow(textDate, Priority.ALWAYS);
		panelEdit.getChildren().add(2, textDate);
		panelEdit.getChildren().remove(textValue);

		getValue();
		labelValue.textProperty().bindBidirectional(textDate.localDateTimeProperty(), new StringConverter<LocalDateTime>() {
			@Override
			public LocalDateTime fromString(String content) {
				return LocalDateTime.parse(content, formatter);
			}

			@Override
			public String toString(LocalDateTime object) {
				return formatter.format(object);
			}
		});
	}
	
	@Override
	protected void onButtonAccept(ActionEvent event) {
		item.setName(textType.getText());
		item.setDate(textDate.getLocalDateTime());
		item.setCreatedOn(LocalDateTime.now());
		item.setUpdatedOn(LocalDateTime.now());
		item.setStatus(0);
		if (item.getId()!=null) {
			EventBroker.getDefault().post(new EventContext<>("/create/contact/date", item));
		}else {
			EventBroker.getDefault().post(new EventContext<>("/update/contact/date", item));
		}
		panePreview.toFront();		
	}

	@Override
	protected void deleteItem(Dates item) {
		EventBroker.getDefault().post(new EventContext<>("/delete/contact/date", item));
	}

	@Override
	protected Long getItemId(Dates item) {
		return item.getId();
	}

	@Override
	protected String getValue() {
		if (item==null || item.getDate()==null) {
			return "";
		}
		return item.getDate().format(DateTimeFormatter.ofPattern(DATE_PATTERN));
	}

	@Override
	protected String getType() {
		return item.getName();
	}

	@Override
	protected String getImageName() {
		if (item==null || item.getName()==null) {
			return "icons8-kalender-48.png";
		}
		if (item.getName().toLowerCase().contains("birthday")) {
			return "icons8-geburtstag-52.png";
		}
		return "icons8-kalender-48.png";
	}

	@Override
	protected void onLinkValueAction(ActionEvent e) {
		EventBroker.getDefault().post(new EventContext<>("/open/contact/date", item));
	}
}

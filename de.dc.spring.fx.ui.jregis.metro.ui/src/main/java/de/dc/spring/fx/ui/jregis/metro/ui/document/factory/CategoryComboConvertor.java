package de.dc.spring.fx.ui.jregis.metro.ui.document.factory;

import java.time.LocalDateTime;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentCategory;
import javafx.util.StringConverter;

public class CategoryComboConvertor extends StringConverter<DocumentCategory> {
	@Override
	public String toString(DocumentCategory object) {
		return object.getName();
	}

	@Override
	public DocumentCategory fromString(String name) {
		return new DocumentCategory(name, LocalDateTime.now(), LocalDateTime.now(), -1);
	}
}
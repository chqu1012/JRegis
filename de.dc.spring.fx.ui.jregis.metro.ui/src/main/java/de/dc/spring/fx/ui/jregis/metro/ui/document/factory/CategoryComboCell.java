package de.dc.spring.fx.ui.jregis.metro.ui.document.factory;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentCategory;
import javafx.scene.control.ListCell;

public class CategoryComboCell extends ListCell<DocumentCategory> {
	
	@Override
	protected void updateItem(DocumentCategory item, boolean empty) {
		super.updateItem(item, empty);
		if (item == null || empty) {
			setText(null);
		} else {
			setText(item.getName());
		}
	}

}

package de.dc.spring.fx.ui.jregis.metro.ui.document.factory;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentCategory;
import javafx.scene.control.TreeCell;

public class CategoryTreeCell extends TreeCell<DocumentCategory>{

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

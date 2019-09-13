package de.dc.spring.fx.ui.jregis.metro.ui.document.factory;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import javafx.scene.control.ListCell;

public class ReferenceListCellFeature extends ListCell<Document>{

	@Override
	protected void updateItem(Document item, boolean empty) {
		super.updateItem(item, empty);
		if (item==null || empty) {
			setText(null);
		}else {
			setText(String.format("JREG-%05d: %s", item.getId(), item.getName()));
		}
	}
}

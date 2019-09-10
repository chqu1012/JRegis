package de.dc.spring.fx.ui.jregis.metro.ui.document.factory;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;

public class ColumnJRegisIdFeature extends TableCell<Document, Document>{

	@Override
	protected void updateItem(Document item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item==null) {
			setText(null);
			setGraphic(null);
		}else {
			Label label = new Label(String.format("JREG-%05d", item.getId()));
			label.setPrefHeight(30);
			label.setMaxWidth(Double.MAX_VALUE);
			label.setAlignment(Pos.CENTER);
			label.setStyle("-fx-background-color: gray; -fx-text-fill: white; -fx-background-radius:5;"); 
			setGraphic(label);
		}
	}
}

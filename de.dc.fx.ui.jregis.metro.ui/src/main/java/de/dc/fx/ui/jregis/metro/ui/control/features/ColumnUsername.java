package de.dc.fx.ui.jregis.metro.ui.control.features;

import java.io.IOException;

import de.dc.fx.ui.jregis.metro.ui.control.BaseColumnUsername;
import de.dc.fx.ui.jregis.metro.ui.model.User;
import javafx.fxml.FXMLLoader;

public class ColumnUsername extends BaseColumnUsername {

	private FXMLLoader mLLoader;

	public ColumnUsername() {
		mLLoader = new FXMLLoader(getClass().getResource("/de/dc/fx/ui/jregis/metro/ui/ColumnUsername.fxml"));
		mLLoader.setController(this);

		try {
			mLLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void updateItem(User item, boolean empty) {
		super.updateItem(item, empty);
		if (item==null && empty) {
			setText(null);
			setGraphic(null);
		}else {
			labelName.setText(item.getUsername());
			setGraphic(root);
		}
	}
}

package de.dc.spring.fx.ui.jregis.metro.ui.user.factory;

import java.io.IOException;

import org.apache.log4j.Logger;

import de.dc.spring.fx.ui.jregis.metro.ui.user.model.User;
import javafx.fxml.FXMLLoader;

public class ColumnUsername extends BaseColumnUsername {

	private FXMLLoader mLLoader;

	private static final String FXML = "/de/dc/spring/fx/ui/jregis/metro/ui/user/factory/ColumnUsername.fxml";
	private Logger log = Logger.getLogger(ColumnUsername.class);
	
	public ColumnUsername() {
		mLLoader = new FXMLLoader(getClass().getResource(FXML));
		mLLoader.setController(this);

		try {
			mLLoader.load();
		} catch (IOException e) {
			log.error("Failed to load fxml "+FXML, e);
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

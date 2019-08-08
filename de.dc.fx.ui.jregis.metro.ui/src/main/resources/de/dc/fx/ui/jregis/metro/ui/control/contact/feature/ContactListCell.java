package de.dc.fx.ui.jregis.metro.ui.control.contact.feature;
import java.io.IOException;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ContactListCell extends ListCell<Contact> {

	@FXML
	protected HBox root;
	
    @FXML
    protected ImageView imageViewUser;

    @FXML
    protected Label labelName;

    @FXML
    protected Label labelUsername;

    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(Contact item, boolean empty) {
        super.updateItem(item, empty);
        if(empty || item == null) {
            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/de/dc/fx/ui/jregis/metro/ui/control/contact/feature/ContactListCell.fxml"));
                mLLoader.setController(this);
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            labelName.setText(item.getFirstname()+" "+item.getLastname());
            labelUsername.setText(item.getUsername());
            setGraphic(root);
        }

    }
}

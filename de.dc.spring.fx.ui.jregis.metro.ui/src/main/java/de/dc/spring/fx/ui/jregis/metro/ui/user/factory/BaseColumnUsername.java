package de.dc.spring.fx.ui.jregis.metro.ui.user.factory;
import de.dc.spring.fx.ui.jregis.metro.ui.user.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public abstract class BaseColumnUsername extends TableCell<User, User>{

	@FXML
	protected HBox root;
	
    @FXML
    protected ImageView imageViewIcon;

    @FXML
    protected Label labelName;
}

package de.dc.spring.fx.ui.jregis.metro.ui.preferences;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public abstract class BasePreferencesPage{

    @FXML
    protected SplitPane splitPaneTodo;
	
    @FXML
    protected SplitPane splitPaneActivity;
    
    @FXML
    protected BorderPane root;

    @FXML
    protected AnchorPane main;

}

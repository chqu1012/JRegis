package de.dc.fx.ui.jregis.metro.ui.control;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public abstract class BaseDocumentDetails extends BorderPane{
	
	@FXML
	protected StackPane stackPaneContent;

    @FXML
    protected BorderPane root;

    @FXML
    protected ListView<?> listViewDocumentContentFiles;

    @FXML
    protected ListView<?> listViewComments;

    @FXML
    protected Hyperlink linkCategoryName;

    @FXML
    protected Hyperlink linkDocumentName;

    @FXML
    protected Label labelCreatedTimestamp;

    @FXML
    protected Label labelLastUpdate;

    @FXML
    protected Label labelEditor;

    @FXML
    protected TextField textTransactionMessage;

    @FXML
    protected Label labelDraggingFiledIntoField;

    @FXML
    protected VBox vboxContent;
    
    @FXML
    protected abstract void onDocumentDetailsCloseAction(ActionEvent event);

    @FXML
    protected abstract void onButtonOpenDirectoryAction(ActionEvent event);

    @FXML
    protected abstract void onButtonOpenFileChooserToCopyAction(ActionEvent event);

    @FXML
    protected abstract void onButtonAddFromClipboardAction(ActionEvent event);

    @FXML
    protected abstract void onButtonDownloadViaUrlAction(ActionEvent event);

    @FXML
    protected abstract void onFileListDragOver(DragEvent event);

    @FXML
    protected abstract void onFileListDragDropped(DragEvent event);

}

package de.dc.fx.ui.jregis.metro.ui.control.document.management;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public abstract class BaseDocumentClipboardPane extends AnchorPane{

    @FXML
    protected AnchorPane documentClipboardPane;

    @FXML
    protected TextField transactionMessageText;

    @FXML
    protected TextField fileIdText;

    @FXML
    protected ComboBox<?> fileNameSuggesstionCombo;

    @FXML
    protected CheckBox useFileIdButton;

    @FXML
    protected Label fileIdLabel;

    @FXML
    protected ImageView clipboardImage;

    @FXML
    protected abstract void onCloseDocumentClipboardPaneClicked(MouseEvent event);

    @FXML
    protected abstract void onDocumentClipboardCancelButtonClicked(ActionEvent event);

    @FXML
    protected abstract void onDocumentClipboardImageMouseClicked(MouseEvent event);

    @FXML
    protected abstract void onDocumentClipboardPasteButtonClicked(ActionEvent event);

    @FXML
    protected abstract void onEditFileNameSuggestionClicked(ActionEvent event);

    @FXML
    protected abstract void onFileNameSuggestionDeleteClicked(ActionEvent event);

    @FXML
    protected abstract void onNewFileNameSuggesttionClicked(ActionEvent event);

}

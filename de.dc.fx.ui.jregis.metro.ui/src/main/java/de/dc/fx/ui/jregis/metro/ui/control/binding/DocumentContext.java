package de.dc.fx.ui.jregis.metro.ui.control.binding;

import java.io.File;

import de.dc.fx.ui.jregis.metro.ui.model.Document;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;

public class DocumentContext {
	
	public ObjectProperty<Document> current = new SimpleObjectProperty<>();
	public ObjectProperty<String> toOpenFile = new SimpleObjectProperty<>();
	
	// Document properties
	public StringProperty documentComment = new SimpleStringProperty("");
	public StringProperty documentName = new SimpleStringProperty("");
	public StringProperty documentId = new SimpleStringProperty("");
	public StringProperty documentDescription = new SimpleStringProperty("");
	public StringProperty documentCreatedOn = new SimpleStringProperty("");
	public StringProperty documentUpdatedOn = new SimpleStringProperty("");
	public StringProperty documentEditor = new SimpleStringProperty("");

	// Counters
	public StringProperty countComment = new SimpleStringProperty("");
	public StringProperty countFile = new SimpleStringProperty("");
	public StringProperty countReference = new SimpleStringProperty("");
	
	public BooleanProperty showDeletedComments = new SimpleBooleanProperty(true);
	public BooleanProperty disableSubmitButton = new SimpleBooleanProperty(true);
	
	// Webdownload Dialog
	public BooleanProperty usingDownloadFileId = new SimpleBooleanProperty(true);
	public StringProperty downloadTransactionMessage = new SimpleStringProperty("");
	public StringProperty downloadFileID = new SimpleStringProperty("");
	public StringProperty downloadFileName = new SimpleStringProperty("");
	public StringProperty downloadUrl = new SimpleStringProperty("");
	public ObjectProperty<Object> downloadContent = new SimpleObjectProperty<>();

	// ClipboardHelper Dialog
	public BooleanProperty usingClipboardFileId = new SimpleBooleanProperty(true);
	public StringProperty clipboardTransactionMessage = new SimpleStringProperty("Save clipboard image.");
	public StringProperty clipboardFileID = new SimpleStringProperty("");
	public StringProperty clipboardFileName = new SimpleStringProperty("Clipboard*");
	public StringProperty clipboardFilePath = new SimpleStringProperty("");
	public ObjectProperty<Image> clipboardImageContent = new SimpleObjectProperty<>();
}

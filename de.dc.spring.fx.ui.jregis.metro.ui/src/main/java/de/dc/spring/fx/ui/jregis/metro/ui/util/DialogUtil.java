package de.dc.spring.fx.ui.jregis.metro.ui.util;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;
import java.util.function.Consumer;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DialogUtil {

	/*
	 * Dialog without header
	 */
	public static void openInfo(String title, String contentText) {
		openInfo(title, null, contentText);
	}

	/*
	 * Dialog with header
	 */
	public static void openInfo(String title, String headerText, String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}

	public static void openWarning(String title, String contentText) {
		openWarning(title,null, contentText);
	}
	
	public static void openWarning(String title, String headerText, String contentText) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}

	public static void openError(String title, String contentText) {
		openError(title, null, contentText);
	}
	
	public static void openException(Exception ex) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Exception Dialog");
		alert.setContentText(ex.getLocalizedMessage());

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String exceptionText = sw.toString();

		Label label = new Label("The exception stacktrace was:");

		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		// Set expandable Exception into the dialog pane.
		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
	}
		
	public static void openError(String title, String headerText, String contentText) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
	
	public static Optional<ButtonType> openQuestion(String title, String headerText, String contentText) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		return alert.showAndWait();
	}
	
	public static void openInput(String title, String defaultValue, String header, String contentText, Consumer<String> action) {
		TextInputDialog dialog = new TextInputDialog(defaultValue);
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setContentText(contentText);
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(action);
	}

	public static String openDirectoryDialog() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedDirectory = directoryChooser.showDialog(new Stage());
		if(selectedDirectory != null){
			return selectedDirectory.getAbsolutePath();
		}
		return "";
	}

	public static File openFileSaveDialog(String name) {
		FileChooser chooser = new FileChooser();
		chooser.setInitialFileName(name);
		chooser.setTitle("Save File to");
		return chooser.showSaveDialog(new Stage());
	}

	public static File openFileDialog(String name) {
		FileChooser chooser = new FileChooser();
		chooser.setInitialFileName(name);
		chooser.setTitle("Open File");
		return chooser.showOpenDialog(new Stage());
	}
}

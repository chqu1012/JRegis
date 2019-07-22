package de.dc.fx.ui.jregis.metro.ui.util;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class ClipboardHelper {
	
	static final Clipboard clipboard = Clipboard.getSystemClipboard();
	static final ClipboardContent content = new ClipboardContent();

	public static void toClipboard(String stringContent) {
		content.putString(stringContent);
        clipboard.setContent(content);
	}
	
	public static String getString() {
		return clipboard.getString();
	}
	
	public static List<File> getFiles(){
		return clipboard.getFiles();
	}
	
	public static Optional<Image> getImage() {
		return Optional.ofNullable(clipboard.getImage());
	}
}

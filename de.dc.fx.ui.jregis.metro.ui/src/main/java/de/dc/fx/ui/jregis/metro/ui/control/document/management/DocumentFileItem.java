package de.dc.fx.ui.jregis.metro.ui.control.document.management;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.function.Consumer;

import javax.swing.filechooser.FileSystemView;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class DocumentFileItem extends HBox{

	static HashMap<String, Image> mapOfFileExtToSmallIcon = new HashMap<>();
	
    @FXML
    protected ImageView imageView;

    @FXML
    protected Hyperlink fileNameLabel;

	public static final String FXML = "/de/dc/fx/ui/jregis/metro/ui/control/document/management/DocumentsFileItem.fxml";

	private Consumer<String> executer;

	public DocumentFileItem() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}
	
	@FXML
    protected void onHyperlinkClicked(ActionEvent event) {
    	if (executer!=null) {
    		String fileName = fileNameLabel.getText();
    		executer.accept(fileName);
		}
    }
	
	public void set(String label, Consumer<String> executer) {
		this.executer = executer;
		Image fileIcon = getFileIcon(label);
		imageView.setImage(fileIcon);
		fileNameLabel.setText(label);
	}
	
	private static String getFileExt(String fname) {
		String ext = ".";
		int p = fname.lastIndexOf('.');
		if (p >= 0) {
			ext = fname.substring(p);
		}
		return ext.toLowerCase();
	}

	public static Image getFileIcon(String fname) {
		String ext = getFileExt(fname);
		Image fileIcon = mapOfFileExtToSmallIcon.get(ext);
		if (fileIcon == null) {

			javax.swing.Icon jswingIcon = null;

			File file = new File(fname);
			if (file.exists()) {
				jswingIcon = getJSwingIconFromFileSystem(file);
			} else {
				File tempFile = null;
				try {
					tempFile = File.createTempFile("icon", ext);
					jswingIcon = getJSwingIconFromFileSystem(tempFile);
				} catch (IOException ignored) {
					// Cannot create temporary file.
				} finally {
					if (tempFile != null)
						tempFile.delete();
				}
			}

			if (jswingIcon != null) {
				fileIcon = jswingIconToImage(jswingIcon);
				mapOfFileExtToSmallIcon.put(ext, fileIcon);
			}
		}

		return fileIcon;
	}
	
    private static javax.swing.Icon getJSwingIconFromFileSystem(File file) {
        FileSystemView view = FileSystemView.getFileSystemView();
        return view.getSystemIcon(file);
    }

	private static Image jswingIconToImage(javax.swing.Icon jswingIcon) {
		BufferedImage bufferedImage = new BufferedImage(jswingIcon.getIconWidth(), jswingIcon.getIconHeight(),
				BufferedImage.TYPE_INT_ARGB);
		jswingIcon.paintIcon(null, bufferedImage.getGraphics(), 0, 0);
		return SwingFXUtils.toFXImage(bufferedImage, null);
	}
}

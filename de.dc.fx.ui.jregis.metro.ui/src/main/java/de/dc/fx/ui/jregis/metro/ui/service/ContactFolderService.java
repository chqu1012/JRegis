package de.dc.fx.ui.jregis.metro.ui.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import de.dc.fx.ui.jregis.metro.ui.gen.contacts.contact.model.Contact;
import de.dc.fx.ui.jregis.metro.ui.util.ImageHelper;
import javafx.scene.image.Image;

public class ContactFolderService extends BaseFolderService<Contact>{

	public void copyImageTo(Contact contact, String filename, Image image) {
		ImageHelper.saveToFile(getFolderBy(contact) + "/" + filename, image);
	}

	public void copyFile(Contact contact, File file) {
		try {
			copyFile(contact, file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void copyFile(Contact contact, String filePath) throws IOException {
		FileUtils.copyFileToDirectory(new File(filePath), getFolderBy(contact));
	}
	
	@Override
	protected String resFolderName() {
		return "contact";
	}

	@Override
	public File getFolderBy(Contact t) {
		return getFolderBy(t.getId());
	}

	@Override
	public File createFolder(Contact t) {
		return createFolder(t.getId());
	}

}

package de.dc.fx.ui.jregis.metro.ui.service;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import de.dc.fx.ui.jregis.metro.ui.control.binding.DocumentContext;
import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.util.ImageHelper;
import javafx.scene.image.Image;

public class DocumentFolderService extends BaseFolderService<Document>{

	public Document lastSelectedDocument;
	
	@Override
	protected String resFolderName() {
		return "document";
	}
	
	public void copyImageTo(DocumentContext context) {
		Image image = context.clipboardImageContent.get();
		String filename = context.clipboardFileName.get()+".png";
		Document document = context.current.get();
		copyImageTo(document, filename,image);
	}
	
	public void copyImageTo(Document document, String filename, Image image) {
		ImageHelper.saveToFile(getFolderBy(document) + "/" + filename, image);
	}

	public void copyFile(Document document, File file) {
		copyFile(document, file.getAbsoluteFile());
	}
	
	public void copyFile(Document document, String filePath) throws IOException {
		FileUtils.copyFileToDirectory(new File(filePath), getFolderBy(document));
	}

	public File downloadFile(DocumentContext context) throws IOException {
		String destination = getFolderPathBy(context.current.get());
		File file = new File(destination, context.downloadFileName.get());
		FileUtils.copyURLToFile(new URL(context.downloadUrl.get()), file, 10000, 10000);
		return file;
	}
	
	public File openFolder(Document document) throws Exception {
		File folder = getFolderBy(document);
		Desktop.getDesktop().open(folder);
		return folder;
	}
	
	public File openFile(Document document, String filename) throws Exception {
		String destination = getFolderPathBy(document);
		File file = new File(destination, filename);
		Desktop.getDesktop().open(file);
		return file;
	}

	public File openFile(File file) throws Exception {
		Desktop.getDesktop().open(file);
		return file;
	}
	
	public void deleteFile(Document document, Attachment attachment) {
		String filePath = getFolderPathBy(document)+ "/" + attachment.getName();
		deleteFile(filePath);
	}

	
	public File getAttachment(Document document, Attachment documentAttachment) {
		String baseFolder = getFolderPathBy(document);
		return new File(baseFolder, documentAttachment.getName());
	}

	public File getAttachmentByName(Document document, String attachmentName) {
		String baseFolder = getFolderPathBy(document);
		return new File(baseFolder, attachmentName);
	}
	
	@Override
	public File getFolderBy(Document t) {
		this.lastSelectedDocument=t;
		return getFolderBy(t.getId()); 
	}

	@Override
	public File createFolder(Document t) {
		return createFolder(t.getId());
	}

}

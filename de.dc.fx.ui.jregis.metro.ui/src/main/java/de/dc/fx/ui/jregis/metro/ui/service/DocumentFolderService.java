package de.dc.fx.ui.jregis.metro.ui.service;

import java.io.File;

import de.dc.fx.ui.jregis.metro.ui.model.Attachment;
import de.dc.fx.ui.jregis.metro.ui.model.Document;

public class DocumentFolderService extends BaseFolderService<Document>{

	public Document lastSelectedDocument;
	
	@Override
	protected String resFolderName() {
		return "document";
	}

	public void deleteFile(Document document, Attachment attachment) {
		String filePath = getFolderPathBy(document)+ "/" + attachment.getName();
		deleteFile(filePath);
	}

	
	public File getAttachment(Document document, Attachment documentAttachment) {
		String baseFolder = getFolderPathBy(document);
		String filePath = baseFolder+"/"+documentAttachment.getName();
		return new File(filePath);
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

package de.dc.fx.ui.jregis.metro.ui.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public abstract class BaseFolderUtil<T> {
	
	public static final File rootFolder = new File("");
	public static final File contentFolder = new File(rootFolder.getAbsoluteFile() + "/content");
	public File resFolder;

	public File lastSelectedFolder;
	
	protected abstract String resFolderName();
	
	public abstract File getFolderBy(T t);
	public abstract File createFolder(T t);
	
	public File[] getFolderContent(T t) {
		return getFolderBy(t).listFiles();
	}
	
	public void createIfNotExist() {
		existFolder(contentFolder);
		existFolder(getResFolder());
	}
	
	public File getResFolder() {
		if (resFolder ==null) {
			resFolder = new File(contentFolder.getAbsolutePath()+ "/" + resFolderName());
		}
		return resFolder;
	}
	
	public File getFolderBy(Long id) {
		String number = String.format ("%016d", id);
		lastSelectedFolder = new File(contentFolder.getAbsolutePath()+ "/" + resFolderName() + "/" + number);
		if (!lastSelectedFolder.exists()) {
			lastSelectedFolder.mkdirs();
		}
		return lastSelectedFolder;
	}
	
	public String getFolderPathBy(T t) {
		return getFolderBy(t).getAbsolutePath();
	}
	
	public File createFolder(long id) {
		String number = String.format ("%016d", id);
		lastSelectedFolder = new File(contentFolder.getAbsolutePath()+ "/" + resFolderName() + "/" + number);
		lastSelectedFolder.mkdirs();
		return lastSelectedFolder;
	}
	
	public void deleteFolderWithContent(T t) {
		deleteFolderWithContentByFile(getFolderBy(t));
	}
	
	public void deleteFolderWithContentByFile(File folder) {
		try {
			FileUtils.deleteDirectory(folder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFile(String filePath) {
		try {
			FileUtils.forceDelete(new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void existFolder(File folder) {
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}
	
	public boolean copyFileTo(File sourceFile, File destinationFile) {
		try {
			if (!sourceFile.getAbsolutePath().equals(destinationFile.getAbsolutePath())) {
				FileUtils.copyFile(sourceFile, destinationFile);
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}

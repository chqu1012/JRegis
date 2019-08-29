package de.dc.fx.ui.jregis.metro.ui.control.screenshot.model;

import javafx.scene.image.Image;

public class ScreenshotContext {

	private Image image;
	private String name;
	
	public ScreenshotContext(Image image, String name) {
		this.image = image;
		this.name = name;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

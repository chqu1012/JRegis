package de.dc.spring.fx.ui.jregis.metro.ui.document;

import org.apache.log4j.Logger;
import org.controlsfx.control.Rating;

public abstract class BaseDocumentDetails extends AbstractFxmlDocumentDetails{
	
	protected Logger log = Logger.getLogger(getClass().getSimpleName());
	protected Rating rating = new Rating(5);
	
	public void initialize() {
		hboxTitle.getChildren().add(rating);
	}
}

package de.dc.fx.ui.jregis.metro.ui;

import java.time.LocalDateTime;
import java.util.Random;

import de.dc.fx.ui.jregis.metro.ui.model.Category;
import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.repository.CategoryRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentRepository;

public class DummyDocumentCreator {

	Random random = new Random();
	
	public void createDummyDocuments() throws Exception {
		DocumentRepository repository = new DocumentRepository();
		String[] titles = {"Steuererklärung 2019", "Schulung Java", "Besprechung JIRA", "Review 2011", "Sommerfest 2017",
				"Einkaufen IT", "Bestellung Hardware", "Raspberry Pi Installation"};
		for (int i = 0; i < titles.length; i++) {
			long categoryId = i;
			String name = titles[i];
			LocalDateTime createdOn = LocalDateTime.now();
			LocalDateTime updatedOn = LocalDateTime.now();
			repository.save(new Document(name, createdOn, updatedOn, categoryId , "A small description", ""));
		}
	}
	
	public void createDummyCategories() {
		CategoryRepository repository = new CategoryRepository();
		String[] titles = {"School", "Work", "Information Technology", "Shopping", "Banking", "Others"};
		for (int i = 0; i < titles.length; i++) {
			LocalDateTime createdOn = LocalDateTime.now();
			LocalDateTime updatedOn = LocalDateTime.now();
			repository.save(new Category(titles[i], createdOn, updatedOn, i));
		}
	}
	
	public static void main(String[] args) throws Exception {
		DummyDocumentCreator creator = new DummyDocumentCreator();
		creator.createDummyCategories();
		creator.createDummyDocuments();
		System.out.println("Dummy document created!");
	}
}

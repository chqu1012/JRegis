package de.dc.fx.ui.jregis.metro.ui.control;

import java.util.List;
import java.util.Optional;

import de.dc.fx.ui.jregis.metro.ui.model.Document;
import de.dc.fx.ui.jregis.metro.ui.repository.CategoryRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentRepository;

public class MainSQL {

	public static void main(String[] args) {
		DocumentRepository documentRepository = new DocumentRepository();
		CategoryRepository categoryRepository = new CategoryRepository();
		
		documentRepository.findAll().forEach(e->System.out.println(e));
		System.out.println("SIZE: "+documentRepository.findAll().size());
		System.out.println("***************************************************");
		categoryRepository.findAll().forEach(e->System.out.println(e));
	}
}

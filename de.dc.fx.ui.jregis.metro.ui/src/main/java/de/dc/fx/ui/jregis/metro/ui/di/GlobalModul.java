package de.dc.fx.ui.jregis.metro.ui.di;

import com.google.inject.AbstractModule;

import de.dc.fx.ui.jregis.metro.ui.control.UserManagementPage;
import de.dc.fx.ui.jregis.metro.ui.eventbus.EventBroker;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import de.dc.fx.ui.jregis.metro.ui.repository.AttachmentRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.CategoryRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.ClipboardNameSuggestionRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentNameRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.RoleRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.UserRepository;
import de.dc.fx.ui.jregis.metro.ui.service.DocumentFolderService;
import de.dc.fx.ui.jregis.metro.ui.service.HistoryService;


public class GlobalModul extends AbstractModule {

	@Override
	protected void configure() {
		bind(DocumentRepository.class).asEagerSingleton();
		bind(CategoryRepository.class).asEagerSingleton();
		bind(HistoryRepository.class).asEagerSingleton();
		bind(AttachmentRepository.class).asEagerSingleton();
		bind(DocumentNameRepository.class).asEagerSingleton();
		bind(ClipboardNameSuggestionRepository.class).asEagerSingleton();
		bind(UserRepository.class).asEagerSingleton();
		bind(RoleRepository.class).asEagerSingleton();
		
		bind(HistoryService.class).asEagerSingleton();
		
		bind(DocumentFolderService.class).asEagerSingleton();
		bind(IEventBroker.class).to(EventBroker.class).asEagerSingleton();
		
		bind(UserManagementPage.class).asEagerSingleton();
	}
}

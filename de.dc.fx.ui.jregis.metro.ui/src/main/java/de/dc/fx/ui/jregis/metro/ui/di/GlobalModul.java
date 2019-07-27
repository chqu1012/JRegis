package de.dc.fx.ui.jregis.metro.ui.di;

import com.google.inject.AbstractModule;

import de.dc.fx.ui.jregis.metro.ui.eventbus.EventBroker;
import de.dc.fx.ui.jregis.metro.ui.eventbus.IEventBroker;
import de.dc.fx.ui.jregis.metro.ui.repository.AttachmentRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.CategoryRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.DocumentRepository;
import de.dc.fx.ui.jregis.metro.ui.repository.HistoryRepository;
import de.dc.fx.ui.jregis.metro.ui.util.DocumentUtil;


public class GlobalModul extends AbstractModule {

	@Override
	protected void configure() {
		bind(DocumentRepository.class).asEagerSingleton();
		bind(CategoryRepository.class).asEagerSingleton();
		bind(HistoryRepository.class).asEagerSingleton();
		bind(AttachmentRepository.class).asEagerSingleton();

		bind(DocumentUtil.class).asEagerSingleton();
		bind(IEventBroker.class).to(EventBroker.class).asEagerSingleton();
	}
}

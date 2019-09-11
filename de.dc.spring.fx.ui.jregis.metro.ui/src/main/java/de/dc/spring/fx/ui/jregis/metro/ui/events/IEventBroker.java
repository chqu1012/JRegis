package de.dc.spring.fx.ui.jregis.metro.ui.events;

public interface IEventBroker {

	void register(Object obj);

	void unregister(Object obj);
	
	void post(EventContext<?> context);
}

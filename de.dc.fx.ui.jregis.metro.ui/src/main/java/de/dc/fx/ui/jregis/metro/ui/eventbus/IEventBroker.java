package de.dc.fx.ui.jregis.metro.ui.eventbus;

public interface IEventBroker {

	void register(Object obj);

	void unregister(Object obj);
	
	void post(EventContext<?> context);
}

package de.dc.spring.fx.ui.jregis.metro.ui.events;

import org.springframework.stereotype.Service;

import com.google.common.eventbus.EventBus;

@Service
public class EventBroker {

	private static EventBus eventBus;

	private EventBroker() {
	}

	public static EventBus getDefault() {
		if (eventBus == null) {
			eventBus = new EventBus();
		}
		return eventBus;
	}

	public void register(Object obj) {
		eventBus.register(obj);
	}

	public void post(EventContext<?> context) {
		eventBus.post(context);
	}

	public void unregister(Object obj) {
		eventBus.unregister(obj);
	}

}
